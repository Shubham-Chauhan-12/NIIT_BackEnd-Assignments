package com.muzix.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Track from this  Id already Exists")
public class TrackAlreadyExistsException extends Exception {
}
