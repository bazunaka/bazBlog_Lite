package ru.bazunaka.bazbloglite.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bazblog_user_profiles")
public class UserProfile {

    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String imageLink;
}
