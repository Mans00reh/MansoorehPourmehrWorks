package com.mansoorehCo.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="file size is too long")
public class FileSizeIsTooLong extends RuntimeException {
}
