package com.board.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BoardEntity {
    @Id
    private int id;
    private String title;
    private String content;
    private String author;
}
