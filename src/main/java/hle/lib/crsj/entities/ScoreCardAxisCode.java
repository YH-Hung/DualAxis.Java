package hle.lib.crsj.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "score_card_axis_code", schema = "rdmsup")
public class ScoreCardAxisCode {
    @EmbeddedId
    private ScoreCardAxisCodeId id;

    @Column(name = "critical_value", length = 20)
    private String criticalValue;

    @Column(name = "mark", length = 5)
    private String mark;

}
