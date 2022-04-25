package hle.lib.crsj.models;

import lombok.Data;

@Data
public class AxisVariableInput {
    String subType;
    String variableName;
    CrsAxis sAxis;
    String axisValue;
}
