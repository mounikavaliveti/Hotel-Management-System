package com.hotel.operations.Dto;

import java.util.Objects;

public class ReturnResponse {
    public String message;
    public boolean status;

    public ReturnResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReturnResponse that = (ReturnResponse) o;
        return
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, status);
    }
}
