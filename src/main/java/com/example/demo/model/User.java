package com.example.demo.model;

public class User {

    public static final String ROLE_USER = "USER";

    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;

    public User() {}

    public User(Long id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public String getPassword() {    // ✅ REQUIRED
        return password;
    }

    public String getRole() { return role; }

    public void setId(Long id) { this.id = id; }
    public void setRole(String role) { this.role = role; }
}
