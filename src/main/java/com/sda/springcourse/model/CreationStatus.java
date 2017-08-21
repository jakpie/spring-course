package com.sda.springcourse.model;

public class CreationStatus {
    private boolean status;

    private String message;


    CreationStatus() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
