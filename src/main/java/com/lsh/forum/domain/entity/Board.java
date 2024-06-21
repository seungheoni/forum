package com.lsh.forum.domain.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
@Table(name = "board")
public class Board extends Auditable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String boardId;
    @Column(nullable = false, length = 255)
    private String boardName;
    @OneToMany(mappedBy = "board")
    private Set<Post> posts;
}