package com.boyz.streaming.manager.repository;

import com.boyz.streaming.manager.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ArtistRepository extends JpaRepository<Artist, UUID> {
    Optional<Artist> findByName(String name);
}
