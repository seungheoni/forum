package com.lsh.forum.domain.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "post")
public class Post extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(nullable = false, length = 255)
    private String title;
    @Lob
    @Column(nullable = false)
    private String content;
}