package com.astra.core.entity;

import com.astra.core.common.Status;
import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Builder
@Table(name = "task")
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Status status;
    private String title;
    private String text;
    @ElementCollection
    @CollectionTable(name = "users_comments", joinColumns =
    @JoinColumn(name = "comment_id"))
    @Column(name = "comment")
    private Set<String> comments;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    public User owner;
    @ElementCollection
    @CollectionTable(name = "responsible_users", joinColumns =
    @JoinColumn(name = "responsible_id"))
    @Column(name = "username")
    private Set<String> usernames;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Task(Integer id, Status status, String title, String text, Set<String> comments, User owner, Set<String> usernames, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.status = status;
        this.title = title;
        this.text = text;
        this.comments = comments;
        this.owner = owner;
        this.usernames = usernames;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Task() {
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

    public Set<String> getComments() {
        return comments;
    }

    public void setComments(Set<String> comments) {
        this.comments = comments;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
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
