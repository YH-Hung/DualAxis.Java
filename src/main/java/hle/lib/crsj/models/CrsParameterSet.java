package hle.lib.crsj.models;

import hle.lib.crsj.entities.ScoreCardAxisCode;
import hle.lib.crsj.entities.ScoreCardAxisMapping;
import lombok.Data;

import java.util.List;

@Data
public class CrsParameterSet {
    List<ScoreCardAxisMapping> rawAxisMapping;
    List<ScoreCardAxisCode> rawAxisCode;
}
