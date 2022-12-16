package ru.kpfu.itis.models;

import java.util.Objects;

public class User {
    private Long id;
    private String email;
    private String username;
    private String password;
    private String image;
    private String role;

    public User(Long id, String email, String username, String password, String image, String role) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.image = image;
        this.role = role;
    }

    public User(String email, String username, String password, String image, String role) {
        this.id = null;
        this.email = email;
        this.username = username;
        this.password = password;
        this.image = image;
        this.role = role;
    }

    public User(Long id, String email, String username, String password,String role) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String email, String username, String password,String role) {
        this.id = null;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && Objects.equals(email, user.email) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(image, user.image) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, username, password, image, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
