package com.boyz.streaming.manager.service;

import com.boyz.streaming.manager.entity.Artist;
import com.boyz.streaming.manager.repository.ArtistRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArtistService {
    final private ArtistRepository artistRepository;

    public UUID addArtist(String name) {
        var artistEntity = artistRepository.findByName(name);
        if (artistEntity.isPresent()) {
            log.info("Artist {} already exists", name);
            return artistEntity.get().getId();
        }

        var newArtist = new Artist();
        newArtist.setName(name);
        try {
            newArtist = artistRepository.save(newArtist);
        } catch (Exception e) {
            log.error("Error while saving artist: {}", e.getMessage());
            throw new RuntimeException("Error while saving artist: " + e.getMessage());
        }

        log.info("Artist {} added", name);
        return newArtist.getId();
    }

    public void deleteArtist(UUID artistId) {
        try {
            artistRepository.deleteById(artistId);
        } catch (Exception e) {
            log.error("Error while deleting artist: {}", e.getMessage());
            throw new RuntimeException("Error while deleting artist: " + e.getMessage());
        }

        log.info("Artist {} deleted", artistId);
    }
}
