package com.boyz.streaming.manager.repository;

import com.boyz.streaming.manager.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrackRepository extends JpaRepository<Track, UUID> {
}
