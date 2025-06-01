package com.boyz.streaming.manager.service;

import com.boyz.streaming.manager.dto.CreateReleaseDTO;
import com.boyz.streaming.manager.entity.Release;
import com.boyz.streaming.manager.entity.Track;
import com.boyz.streaming.manager.entity.enums.ReleaseType;
import com.boyz.streaming.manager.repository.ReleaseRepository;
import com.boyz.streaming.manager.repository.TrackRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReleaseService {
    final private ReleaseRepository releaseRepository;
    final private TrackRepository trackRepository;

    public UUID addRelease(CreateReleaseDTO release) {
        Release releaseEntity = new Release();
        releaseEntity.setArtistId(release.getArtistId());
        releaseEntity.setName(release.getName());
        releaseEntity.setReleaseType(ReleaseType.valueOf(release.getReleaseType()));
        releaseEntity.setReleaseYear(release.getReleaseYear());
        try {
            releaseEntity = releaseRepository.save(releaseEntity);
        } catch (Exception e) {
            log.error("Error while saving release: {}", e.getMessage());
            throw new RuntimeException("Error while saving release: " + e.getMessage());
        }

        List<Track> tracks = new ArrayList<>();
        Release finalReleaseEntity = releaseEntity;
        release.getTracks().forEach((trackname, meta) -> {
            Track trackEntity = new Track();
            trackEntity.setReleaseId(finalReleaseEntity.getId());
            trackEntity.setDuration(meta.getDuration());
            trackEntity.setTrackNumber(meta.getTrackNumber());
            trackEntity.setFileId(meta.getFileId());
            trackEntity.setName(trackname);

            tracks.add(trackEntity);
        });

        try {
            trackRepository.saveAll(tracks);
        } catch (Exception e) {
            log.error("Error while saving tracks: {}", e.getMessage());
            throw new RuntimeException("Error while saving tracks: " + e.getMessage());
        }

        log.info("Release {} added", releaseEntity.getId());
        return releaseEntity.getId();
    }

    public void deleteRelease(UUID releaseId) {
        try {
            releaseRepository.deleteById(releaseId);
        } catch (Exception e) {
            log.error("Error while deleting release: {}", e.getMessage());
            throw new RuntimeException("Error while deleting release: " + e.getMessage());
        }

        log.info("Release {} deleted", releaseId);
    }
}
