package com.demo.demo.exceptionhandler;

import lombok.*;
import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ApiException {
private String message;
private Throwable throwable;
private HttpStatus httpStatus;
private ZonedDateTime zonedDateTime;

}

