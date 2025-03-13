package com.example.CMS.DTO;

import com.example.CMS.Entity.Task;

public class ResponseMessage {
    private String message;
    private Task task;

    public ResponseMessage(String message, Task task) {
        this.message = message;
        this.task = task;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}

