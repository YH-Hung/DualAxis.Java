package hle.lib.crsj.models;

import lombok.Data;

@Data
public class CrsVariableInput {
    String variableName;
    AxisVariableInput xInput;
    AxisVariableInput yInput;
}
