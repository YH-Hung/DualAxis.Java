package hle.lib.crsj.models;

import java.util.stream.Stream;

public enum CrsVarMarkType {
    SpecifiedValue("V"),
    BelowIncluded("BI"),
    BelowNotIncluded("BN"),
    GreaterIncluded("GI"),
    GreaterNotIncluded("GN");

    private final String code;

    CrsVarMarkType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static CrsVarMarkType fromString(String codeInDb) {
        return Stream.of(CrsVarMarkType.values())
                .filter(t -> t.code.equals(codeInDb))
                .findFirst()
                .orElseThrow();
    }
}
