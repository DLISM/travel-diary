package com.github.dlism.traveldiary.controller.exceptin;

import com.github.dlism.traveldiary.model.out.ErrorRestOut;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private static final List<Class<? extends Exception>> EXCEPTIONS_STATUS_400 =
            List.of(
                    MethodArgumentNotValidException.class,
                    IOException.class
            );

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.error("Exception handler catch exception {}", ex.getMessage());
        return handleExceptionInternal(
                ex,
                createErrorRestOut(ex),
                new HttpHeaders(),
                defineStatus(ex),

                request
        );
    }

    private HttpStatusCode defineStatus(Exception exception) {
        if (EXCEPTIONS_STATUS_400.contains(exception.getClass())){
            return HttpStatusCode.valueOf(400);
        }
        return HttpStatusCode.valueOf(500);
    }

    private ErrorRestOut createErrorRestOut(Exception exception){
        return ErrorRestOut.builder()
                .message(exception.getMessage())
                .timestamp(ZonedDateTime.now().toString())
                .build();
    }
}
