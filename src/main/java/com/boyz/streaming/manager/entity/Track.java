package com.boyz.streaming.manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "track")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "release_id")
    private UUID releaseId;

    private String name;
    private Integer duration;

    @Column(name = "track_number")
    private Short trackNumber;

    @Column(name = "file_id")
    private UUID fileId;
}
