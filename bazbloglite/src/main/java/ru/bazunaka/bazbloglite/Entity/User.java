package ru.bazunaka.bazbloglite.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Data
@Entity
@Table(name = "bazblog_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String userName;
    private String password;
    private String roles;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.roles = "USER";
    }
}
