package com.lsh.forum.domain.dto;

import com.lsh.forum.domain.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRegistrationRequest {

    /**
     * 사용자 이름
     */
    @NotBlank(message = "이름 정보가 필요합니다.")
    private String username;

    /**
     * 이메일 정보
     */
    @NotBlank(message = "이메일 정보가 필요합니다.")
    @Email(message = "Invalid email format")
    private String email;

    /**
     * 패스워드 정보
     */
    @NotBlank(message = "패스워드 정보가 필요합니다.")
    private String passwordHash;

    public UserRegistrationRequest(String username, String email, String passwordHash) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public static User toEntity(UserRegistrationRequest request) {
        return new User(request.getUsername(), request.getEmail(), request.getPasswordHash());
    }
}
