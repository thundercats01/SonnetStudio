package com.example.lyricalapes.repositories;

import com.example.lyricalapes.models.Like;
import com.example.lyricalapes.models.User;
import com.example.lyricalapes.models.Verse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepo extends JpaRepository<Like,Long> {
    boolean existsByUserAndVerse(User user, Verse verse);
    List<Like> findAllByVerse(Verse verse);
}
