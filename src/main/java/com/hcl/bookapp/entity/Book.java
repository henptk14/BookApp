package com.hcl.bookapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Title cannot be blank")
    @Size(max = 100)
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Description cannot be blank")
    @Size(max = 4000)
    @Column(nullable = false)
    private String description;

    @NotBlank(message = "Published Year cannot be blank")
    @Column(nullable = false)
    private String publishYear;

    @NotBlank(message = "Publisher cannot be blank")
    @Size(max = 100)
    @Column(nullable = false)
    private String publisher;

    @NotBlank(message =  "Author Name cannot be blank")
    @Size(max = 100)
    @Column(nullable = false)
    private String authName;

    private Date createdAt;

    @PrePersist
    protected void create() {
        createdAt = new Date();
    }

    private Date updatedAt;

    @NotBlank(message = "Status cannot be blank")
    @Column(nullable = false)
    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publishYear=" + publishYear +
                ", publisher='" + publisher + '\'' +
                ", authName='" + authName + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                '}';
    }
}
