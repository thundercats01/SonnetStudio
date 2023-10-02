package com.example.lyricalapes.repositories;

import com.example.lyricalapes.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepo extends JpaRepository<Like,Long> {

}
