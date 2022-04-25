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
public class ScoreCardAxisMappingId implements Serializable {
    private static final long serialVersionUID = -3007723876096319643L;
    @Column(name = "score_card_type", nullable = false, length = 8)
    private String scoreCardType;

    @Column(name = "sub_type", nullable = false, length = 10)
    private String subType;

    @Column(name = "variable_name", nullable = false, length = 35)
    private String variableName;

    @Column(name = "order_no_x", nullable = false)
    private Integer orderNoX;

    @Column(name = "order_no_y", nullable = false)
    private Integer orderNoY;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ScoreCardAxisMappingId entity = (ScoreCardAxisMappingId) o;
        return Objects.equals(this.variableName, entity.variableName) &&
                Objects.equals(this.scoreCardType, entity.scoreCardType) &&
                Objects.equals(this.orderNoX, entity.orderNoX) &&
                Objects.equals(this.subType, entity.subType) &&
                Objects.equals(this.orderNoY, entity.orderNoY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variableName, scoreCardType, orderNoX, subType, orderNoY);
    }

}