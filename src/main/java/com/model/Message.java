package com.model;

import jakarta.persistence.*;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageID")
    private Integer messageID;

    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 50, nullable = false)
    private String lastName;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "message", nullable = false, columnDefinition = "TEXT")
    private String message;

    // Getters and Setters

    public Integer getMessageID() {
        return messageID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
