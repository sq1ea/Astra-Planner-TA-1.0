package com.astra.core.dto.task;

import com.astra.core.common.Status;
import com.astra.core.dto.user.UserRead;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class TaskRead {

     Integer id;
     Status status;
     String title;
     String text;
     Set<String> comment;
     UserRead owner;
     Set<String> usernames;
     LocalDateTime createdAt;
     LocalDateTime updatedAt;

    public TaskRead(Integer id, Status status, String title, String text, Set<String> comment, UserRead owner, Set<String> usernames, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.status = status;
        this.title = title;
        this.text = text;
        this.comment = comment;
        this.owner = owner;
        this.usernames = usernames;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<String> getComment() {
        return comment;
    }

    public void setComment(Set<String> comment) {
        this.comment = comment;
    }

    public UserRead getOwner() {
        return owner;
    }

    public void setOwner(UserRead owner) {
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
