package ru.bazunaka.bazbloglite.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@Table
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @Column(nullable = false, updatable = false)
    private Instant createdTime;

    @ManyToOne(optional = false)
    private UserProfile userProfile;
}
