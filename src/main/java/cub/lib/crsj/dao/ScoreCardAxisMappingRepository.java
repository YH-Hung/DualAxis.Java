package cub.lib.crsj.dao;

import cub.lib.crsj.entities.ScoreCardAxisMapping;
import cub.lib.crsj.entities.ScoreCardAxisMappingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreCardAxisMappingRepository extends JpaRepository<ScoreCardAxisMapping, ScoreCardAxisMappingId> {
}