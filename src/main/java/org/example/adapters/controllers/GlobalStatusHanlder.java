package org.example.adapters.controllers;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.hateoas.JsonError;

@Controller()
@SuppressWarnings("rawtypes")
public class GlobalStatusHanlder {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalStatusHanlder.class);

    @Error(global = true, status = HttpStatus.BAD_REQUEST)
    public HttpResponse<?> handle400Error(HttpRequest request) {
        return handleError(request, HttpStatus.BAD_REQUEST);
    }

    @Error(global = true, status = HttpStatus.UNAUTHORIZED)
    public HttpResponse<?> handle401Error(HttpRequest request) {
        return handleError(request, HttpStatus.UNAUTHORIZED);
    }

    @Error(global = true, status = HttpStatus.FORBIDDEN)
    public HttpResponse<?> handle403rror(HttpRequest request) {
        return handleError(request, HttpStatus.FORBIDDEN);
    }

    @Error(global = true, status = HttpStatus.NOT_FOUND)
    public HttpResponse<?> handle404Error(HttpRequest request) {
        return handleError(request, HttpStatus.NOT_FOUND);
    }

    @Error(global = true, status = HttpStatus.METHOD_NOT_ALLOWED)
    public HttpResponse<?> handle405Error(HttpRequest request) {
        return handleError(request, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Error(global = true, status = HttpStatus.INTERNAL_SERVER_ERROR)
    public HttpResponse<?> handle500Error(HttpRequest request) {
        return handleError(request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private HttpResponse<JsonError> handleError(HttpRequest request, HttpStatus status) {
        LOGGER.error(MessageFormat.format("Request: {1}, status: {2}", request, status));
        return HttpResponse.<JsonError>status(status, status.getReason());
    }
}