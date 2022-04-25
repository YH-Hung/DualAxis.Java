package cub.lib.crsj;

import cub.lib.crsj.models.CrsVarMarkType;
import cub.lib.crsj.services.CrsMatchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class CrsJApplicationTests {

    @Autowired
    CrsMatchService crsMatchService;

    @Test
    void matchNotNumericValue() {
        var result = crsMatchService.matchMarkValue(CrsVarMarkType.SpecifiedValue,
                "MISSING", "missing");

        assertThat(result).isTrue();
    }

    @Test
    void matchNumericValue() {
        var result = crsMatchService.matchMarkValue(CrsVarMarkType.BelowIncluded,
                "0.0002", "0.00020");

        assertThat(result).isTrue();
    }

}
