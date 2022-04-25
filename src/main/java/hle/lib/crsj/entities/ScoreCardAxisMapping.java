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
@Table(name = "score_card_axis_mapping", schema = "rdmsup")
public class ScoreCardAxisMapping {
    @EmbeddedId
    private ScoreCardAxisMappingId id;

    @Column(name = "group_code", length = 2)
    private String groupCode;

}
