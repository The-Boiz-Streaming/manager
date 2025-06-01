package com.boyz.streaming.manager.controller;

import com.boyz.streaming.manager.dto.*;
import com.boyz.streaming.manager.entity.enums.ReleaseType;
import com.boyz.streaming.manager.service.ArtistService;
import com.boyz.streaming.manager.service.ReleaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/manager")
@RequiredArgsConstructor
@Slf4j
public class ManagerController {
    final private ReleaseService releaseService;
    final private ArtistService artistService;

    @GetMapping("/status")
    public String status() {
        return "OK";
    }

    @PostMapping("/add/release")
    public ResponseEntity<String> addRelease(@RequestBody CreateReleaseDTO release) {
        if (!validateRelease(release)) {
            return ResponseEntity.badRequest().body("Bad Request");
        }
        for (var track : release.getTracks().values()) {
            if (!validateTrack(track)) {
                return ResponseEntity.badRequest().body("Bad Request");
            }
        }

        UUID releaseId = releaseService.addRelease(release);
        return ResponseEntity.ok(releaseId.toString());
    }

    @DeleteMapping("/delete/release")
    public ResponseEntity<String> deleteRelease(@RequestParam UUID releaseId) {
        releaseService.deleteRelease(releaseId);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/add/artist")
    public ResponseEntity<String> addArtist(@RequestBody CreateArtistDTO artist) {
        UUID uuid = artistService.addArtist(artist.getName());
        return ResponseEntity.ok(uuid.toString());
    }

    @DeleteMapping("/delete/artist")
    public ResponseEntity<String> deleteArtist(@RequestParam UUID artistId) {
        artistService.deleteArtist(artistId);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("release/types")
    public ResponseEntity<String> getReleaseTypes() {
        return ResponseEntity.ok(Arrays.toString(ReleaseType.values()));
    }

    @GetMapping("release")
    public ResponseEntity<ReleaseResponseDTO> getRelease(@RequestParam Optional<List<UUID>> releaseId) {
        return ResponseEntity.ok(new ReleaseResponseDTO(releaseService.getRelease(releaseId)));
    }

    @GetMapping("track")
    public ResponseEntity<TrackResponseDTO> getTrack(@RequestParam Optional<List<UUID>> trackId) {
        return ResponseEntity.ok(new TrackResponseDTO(releaseService.getTracks(trackId)));
    }

    @GetMapping("artist")
    public ResponseEntity<ArtistResponseDTO> getArtist(@RequestParam Optional<List<UUID>> artistId) {
        return ResponseEntity.ok(new ArtistResponseDTO(artistService.getArtists(artistId)));
    }

    private boolean validateRelease(CreateReleaseDTO release) {
        if (release.getName() == null || release.getName().isEmpty()) {
            log.error("Bad Request: release name is empty");
            return false;
        } else if (release.getReleaseType() == null || release.getReleaseType().isEmpty()) {
            log.error("Bad Request: release type is empty");
            return false;
        } else if (release.getReleaseYear() == null) {
            log.error("Bad Request: release year is empty");
            return false;
        } else if (release.getArtistId() == null) {
            log.error("Bad Request: artist id is empty");
            return false;
        } else if (release.getTracks() == null || release.getTracks().isEmpty()) {
            log.error("Bad Request: tracks is empty");
            return false;
        } else {
            try {
                var releaseType = ReleaseType.valueOf(release.getReleaseType());
            } catch (IllegalArgumentException e) {
                log.error("Bad Request: release type is invalid: {}", release.getReleaseType());
                return false;
            }
        }
        return true;
    }

    private boolean validateTrack(TrackMetaDTO track) {
        if (track.getDuration() == null) {
            log.error("Bad Request: track duration is empty");
            return false;
        } else if (track.getTrackNumber() == null) {
            log.error("Bad Request: track number is empty");
            return false;
        } else if (track.getFileId() == null) {
            log.error("Bad Request: track file id is empty");
            return false;
        }
        return true;
    }
}
