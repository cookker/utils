package ms.me.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

import static ms.me.utils.EnumUtils.*;

@AllArgsConstructor
@Getter
public enum ThresholdType {
    TARGET_CLICK("TC"),
    AI_PLUS("AI"),
    PROGRAM_AD("PR"),
    NONE("NO"),
    ;

    private String thresholdName;

    private static final Map<String, ThresholdType> BY_NAME = createEnumMap(ThresholdType.class);
    private static final Map<String, ThresholdType> BY_THRESHOLD_NAME = createEnumMap(ThresholdType.class, "thresholdName");

    public static ThresholdType of(String name) {
        return optionalEnumOf(BY_THRESHOLD_NAME, name.toUpperCase())
                .orElseGet(() -> enumOf(BY_NAME, name.toUpperCase()));
    }
}

