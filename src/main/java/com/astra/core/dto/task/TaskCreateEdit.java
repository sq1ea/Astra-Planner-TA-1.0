package com.astra.core.dto.task;

import com.astra.core.common.Status;
import lombok.Builder;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@FieldNameConstants
@Builder(toBuilder = true)
public class TaskCreateEdit {

    private Status status;
    private String title;
    private String text;
    private Set<String> comments;
    private Integer owner;
    private Set<String> usernames;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TaskCreateEdit() {
    }

    public TaskCreateEdit(Status status, String title, String text, Set<String> comments, Integer owner, Set<String> usernames, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.status = status;
        this.title = title;
        this.text = text;
        this.comments = comments;
        this.owner = owner;
        this.usernames = usernames;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<String> getComments() {
        return comments;
    }

    public void setComments(Set<String> comments) {
        this.comments = comments;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public Set<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(Set<String> usernames) {
        this.usernames = usernames;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
