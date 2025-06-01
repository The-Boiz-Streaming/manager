package com.boyz.streaming.manager.dto;

import com.boyz.streaming.manager.entity.Release;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReleaseResponseDTO {
    List<Release> releases;
}
