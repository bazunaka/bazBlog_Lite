package ru.bazblog.bazdiary.entity;

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
@Table(name = "bazblog_posts")
public class Post {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;
}
