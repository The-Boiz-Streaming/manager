package com.boyz.streaming.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackMetaDTO {
    private Integer duration;
    private Short trackNumber;  // inside release
    private UUID fileId;    // in S3
}
