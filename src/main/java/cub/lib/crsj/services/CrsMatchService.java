package cub.lib.crsj.services;

import cub.lib.crsj.entities.ScoreCardAxisCode;
import cub.lib.crsj.entities.ScoreCardAxisMapping;
import cub.lib.crsj.models.CrsParameterSet;
import cub.lib.crsj.models.CrsVarMarkType;
import cub.lib.crsj.models.AxisVariableInput;
import cub.lib.crsj.models.CrsVariableInput;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

@Service
public class CrsMatchService {

    public String GetGroupCode(CrsVariableInput input, CrsParameterSet parameterSet) {
        var xOrder = GetAxisOrderNo(input.getXInput(), parameterSet.getRawAxisCode());
        var yOrder = GetAxisOrderNo(input.getYInput(), parameterSet.getRawAxisCode());

        return parameterSet.getRawAxisMapping().stream()
            .filter(m -> m.getId().getVariableName().equals(input.getVariableName())
            && m.getId().getOrderNoX().equals(xOrder)
            && m.getId().getOrderNoY().equals(yOrder))
            .findFirst()
            .map(ScoreCardAxisMapping::getGroupCode)
            .orElse("Not found");
    }

    public Integer GetAxisOrderNo(AxisVariableInput input, List<ScoreCardAxisCode> rawAxisCodes) {
        var axisCodes = rawAxisCodes.stream()
            .filter(m -> m.getId().getSubType().equals(input.getSubType())
                && m.getId().getVariableName().equals(input.getVariableName())
                && m.getId().getAxisType().equals(input.getSAxis().toString()))
            .sorted(Comparator.comparingInt(m -> m.getId().getOrderNo()))
            .filter(m -> matchMarkValue(CrsVarMarkType.fromString(m.getMark()), input.getAxisValue(), m.getCriticalValue()))
            .findFirst()
            .map(m -> m.getId().getOrderNo())
            .orElse(0);

        return axisCodes;
    }

    public Boolean matchMarkValue(CrsVarMarkType mark, String inputValue, String criticalValue) {
        switch (mark) {
            case SpecifiedValue:
                return inputValue.equalsIgnoreCase(criticalValue);
            case BelowIncluded:
                return safeCompareDecimal(inputValue, criticalValue, (l, r) -> l.compareTo(r) <= 0);
            case BelowNotIncluded:
                return safeCompareDecimal(inputValue, criticalValue, (l, r) -> l.compareTo(r) < 0);
            case GreaterIncluded:
                return safeCompareDecimal(inputValue, criticalValue, (l, r) -> l.compareTo(r) >= 0);
            case GreaterNotIncluded:
                return safeCompareDecimal(inputValue, criticalValue, (l, r) -> l.compareTo(r) > 0);
        }

        return false;
    }

    private Boolean safeCompareDecimal(String left, String right, BiPredicate<BigDecimal, BigDecimal> comparer) {
        var leftNumber = new BigDecimal(left);
        var rightNumber = new BigDecimal(right);

        return comparer.test(leftNumber, rightNumber);
    }
}
