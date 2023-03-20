package com.example.RoleBasedProject.Entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {
    @Id
   private int id;
   private String username;
   private String password;
    private String role;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
