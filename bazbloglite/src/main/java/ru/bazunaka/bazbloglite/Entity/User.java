package ru.bazunaka.bazbloglite.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "full_name")
    private String fullName;
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;
    @Column(name = "biography")
    private String bio;
}
