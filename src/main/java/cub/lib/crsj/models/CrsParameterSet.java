package cub.lib.crsj.models;

import cub.lib.crsj.entities.ScoreCardAxisCode;
import cub.lib.crsj.entities.ScoreCardAxisMapping;
import lombok.Data;

import java.util.List;

@Data
public class CrsParameterSet {
    List<ScoreCardAxisMapping> rawAxisMapping;
    List<ScoreCardAxisCode> rawAxisCode;
}
