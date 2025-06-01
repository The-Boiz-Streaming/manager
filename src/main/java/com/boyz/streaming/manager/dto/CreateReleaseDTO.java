package com.boyz.streaming.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateReleaseDTO {
    private String name;
    private String releaseType;
    private Short releaseYear;
    private UUID artistId;
    private Map<String, TrackMetaDTO> tracks;   // trackname : meta
}
