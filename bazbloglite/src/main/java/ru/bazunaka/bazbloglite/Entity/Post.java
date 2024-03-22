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
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "user_ID")
    private Long userID;
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;
    @Column(name = "biography")
    private String bio;
}
