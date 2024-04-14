package com.astra.core.dto.user;

import com.astra.security.authority.Role;
import lombok.*;

import java.time.LocalDateTime;
@Value
public class UserRead {
     Integer id;
     Role role;
     String username;
     String password;
     String firstname;
     String lastname;
     LocalDateTime createdAt;
     LocalDateTime updatedAt;

     public UserRead(Integer id, Role role, String username, String password,String firstname, String lastname, LocalDateTime createdAt, LocalDateTime updatedAt) {
          this.id = id;
          this.role = role;
          this.username = username;
          this.password = password;
          this.firstname = firstname;
          this.lastname = lastname;
          this.createdAt = createdAt;
          this.updatedAt = updatedAt;
     }

     public Integer getId() {
          return id;
     }

     public String getUsername() {
          return username;
     }

     public String getFirstname() {
          return firstname;
     }

     public String getLastname() {
          return lastname;
     }

     public Role getRole() {
          return role;
     }
}
