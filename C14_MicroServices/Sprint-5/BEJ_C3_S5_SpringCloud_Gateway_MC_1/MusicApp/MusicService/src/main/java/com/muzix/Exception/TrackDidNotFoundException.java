package com.muzix.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Track from this Id not Found")
public class TrackDidNotFoundException extends Exception{
}
