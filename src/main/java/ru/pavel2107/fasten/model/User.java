package ru.pavel2107.fasten.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by admin on 24.04.2016.
 */

@Entity
@Table( name="users")
public class User {

    @Column( name="username")
    String userName;

    @Column( name = "password")
    String password;

    @Column( name = "email")
    @Email
    @Id
    String email;


    @Column( name = "enabled")
    Boolean enabled;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
