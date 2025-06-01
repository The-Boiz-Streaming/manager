package com.boyz.streaming.manager.dto;

import com.boyz.streaming.manager.entity.Artist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistResponseDTO {
    List<Artist> artists;
}
