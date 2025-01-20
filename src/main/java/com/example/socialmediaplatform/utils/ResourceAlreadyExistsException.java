package com.example.socialmediaplatform.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourceAlreadyExistsException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public ResourceAlreadyExistsException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ResourceAlreadyExistsException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }


}

