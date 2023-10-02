package com.example.lyricalapes.repositories;

import com.example.lyricalapes.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
