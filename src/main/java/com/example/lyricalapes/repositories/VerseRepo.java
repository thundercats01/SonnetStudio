package com.example.lyricalapes.repositories;

import com.example.lyricalapes.models.Verse;
import com.example.lyricalapes.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VerseRepo extends JpaRepository<Verse, Long> {
    List<Verse> findAllByUser(User loggedInUser);
}
