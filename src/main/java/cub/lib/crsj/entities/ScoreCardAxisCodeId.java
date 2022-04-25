package cub.lib.crsj.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ScoreCardAxisCodeId implements Serializable {
    private static final long serialVersionUID = -11132843873308578L;
    @Column(name = "score_card_type", nullable = false, length = 8)
    private String scoreCardType;

    @Column(name = "sub_type", nullable = false, length = 10)
    private String subType;

    @Column(name = "variable_name", nullable = false, length = 35)
    private String variableName;

    @Column(name = "axis_type", nullable = false, length = 1)
    private String axisType;

    @Column(name = "order_no", nullable = false)
    private Integer orderNo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ScoreCardAxisCodeId entity = (ScoreCardAxisCodeId) o;
        return Objects.equals(this.variableName, entity.variableName) &&
                Objects.equals(this.orderNo, entity.orderNo) &&
                Objects.equals(this.scoreCardType, entity.scoreCardType) &&
                Objects.equals(this.subType, entity.subType) &&
                Objects.equals(this.axisType, entity.axisType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variableName, orderNo, scoreCardType, subType, axisType);
    }

}