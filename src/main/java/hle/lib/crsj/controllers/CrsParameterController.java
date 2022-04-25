package hle.lib.crsj.controllers;

import hle.lib.crsj.dao.ScoreCardAxisCodeRepository;
import hle.lib.crsj.entities.ScoreCardAxisCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parameter")
public class CrsParameterController {

    private final ScoreCardAxisCodeRepository scoreCardAxisCodeRepository;

    public CrsParameterController(ScoreCardAxisCodeRepository scoreCardAxisCodeRepository) {
        this.scoreCardAxisCodeRepository = scoreCardAxisCodeRepository;
    }

    @GetMapping("/{cardType}")
    public List<ScoreCardAxisCode> GetAxisCodes(@PathVariable String cardType) {
        return scoreCardAxisCodeRepository.findById_ScoreCardTypeIs(cardType);
    }


}
