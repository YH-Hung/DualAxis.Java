package hle.lib.crsj.dao;

import hle.lib.crsj.entities.ScoreCardAxisMapping;
import hle.lib.crsj.entities.ScoreCardAxisMappingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreCardAxisMappingRepository extends JpaRepository<ScoreCardAxisMapping, ScoreCardAxisMappingId> {
}
