package ms.me.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

import static ms.me.utils.EnumUtils.createEnumMap;
import static ms.me.utils.EnumUtils.enumOf;

@AllArgsConstructor
@Getter
public enum PointType {
    BONUS_PLUS(SubtractiveType.ALL_OR_NOTHING, 1, "무료-플러스광고 전용", ThresholdType.NONE),
    BONUS_PICK(SubtractiveType.ALL_OR_NOTHING, 1, "무료-픽광고 전용", ThresholdType.NONE),
    BONUS_TARGET(SubtractiveType.PARTIAL, 1, "무료-타겟 전용", ThresholdType.TARGET_CLICK),
    BONUS_INTEGRATION(SubtractiveType.PARTIAL, 2, "무료-통합", ThresholdType.NONE),
    PAID(SubtractiveType.PARTIAL, 3, "유료", ThresholdType.NONE),
    BONUS_AI(SubtractiveType.PARTIAL, 1, "무료-AI_PLUS 포인트 전용", ThresholdType.AI_PLUS),
    BONUS_PROGRAM(SubtractiveType.PARTIAL, 1, "무료-AI_PLUS 포인트 전용", ThresholdType.PROGRAM_AD);

    private SubtractiveType subtractiveType;
    private int priority;
    private String desc;
    private ThresholdType thresholdType;

    private static final Map<String, PointType> BY_THRESHOLD_NAME = createEnumMap(PointType.class);

    public static PointType of(String name) {
        return enumOf(BY_THRESHOLD_NAME, name.toUpperCase());
    }

}
