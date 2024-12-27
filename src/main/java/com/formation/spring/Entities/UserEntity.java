package com.formation.spring.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="users")
public class UserEntity {
    @Id
    @GeneratedValue
    private  long id;
    @Column(nullable = false,length = 50)
    private String userId;
    @Column(nullable = false,length = 100)
    private String nickname;
    @Column(nullable = false,length = 100, unique = true)
    private String email;
    @Column(nullable = false,length = 255)
    private String encryptPassword;
    @Column(nullable = false)
    private Boolean admin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptPassword() {
        return encryptPassword;
    }

    public void setEncryptPassword(String encryptPassword) {
        this.encryptPassword = encryptPassword;
    }

    public Boolean getAdmin() {
        return admin;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAdmin(Boolean admin) {
        this.admin = false;
    }
}
