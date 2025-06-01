package com.boyz.streaming.manager.entity;

import com.boyz.streaming.manager.entity.enums.ReleaseType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "release")
public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "artist_id")
    private UUID artistId;

    @Column(name = "release_type")
    @Enumerated(EnumType.STRING)
    private ReleaseType releaseType;

    private String name;

    @Column(name = "release_year")
    private Short releaseYear;

    @OneToMany(mappedBy = "releaseId", cascade = CascadeType.ALL)
    private List<Track> tracks;
}
