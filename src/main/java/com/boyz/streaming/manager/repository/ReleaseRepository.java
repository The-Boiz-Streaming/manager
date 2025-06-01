package com.boyz.streaming.manager.repository;

import com.boyz.streaming.manager.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReleaseRepository extends JpaRepository<Release, UUID> {
}
