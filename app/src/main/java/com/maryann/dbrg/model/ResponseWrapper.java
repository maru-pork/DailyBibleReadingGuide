package com.maryann.dbrg.model;

import java.util.List;

/**
 * Created by Rufo on 5/22/2016.
 */
public class ResponseWrapper<T> {

    private T entity;
    private String successMessage;
    private List<String> errorMessages;

    public ResponseWrapper(T entity) {
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
