package cub.lib.crsj.dao;

import cub.lib.crsj.entities.ScoreCardAxisCode;
import cub.lib.crsj.entities.ScoreCardAxisCodeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreCardAxisCodeRepository extends JpaRepository<ScoreCardAxisCode, ScoreCardAxisCodeId> {
    List<ScoreCardAxisCode> findById_ScoreCardTypeIs(String scoreCardType);


}