package ms.me.utils

import org.junit.Test

import static org.assertj.core.api.Assertions.assertThat

class EnumUtilsTest {

    @Test
    void 열거형_생성시_이넘타입으로_생성할수있다(){
        Map<String, ThresholdType> stringThresholdTypeMap = EnumUtils.createEnumMap(ThresholdType.class)
        assertThat(stringThresholdTypeMap).isNotEmpty()
    }

    @Test
    void 열거형_생성시_이넘타입과_필드명으로_생성할수있다(){
        Map<String, ThresholdType> thresholdName = EnumUtils.createEnumMap(ThresholdType.class, "thresholdName")
        assertThat(thresholdName.get(ThresholdType.TARGET_CLICK.getThresholdName())).isEqualTo(ThresholdType.TARGET_CLICK)
        assertThat(thresholdName.get(ThresholdType.AI_PLUS.getThresholdName())).isEqualTo(ThresholdType.AI_PLUS)

        assertThat(ThresholdType.of("PROGRAM_AD")).isNotNull()

    }

    @Test(expected = RuntimeException.class)
    void 이넘타입에서_값_이넘타입의쌍으로_맵을만들때_값이유일하지않으면_오류가발생한다(){
        Map<SubtractiveType, PointType> desc = createEnumMap(PointType.class, "subtractiveType", SubtractiveType.class)
        assertThat(desc.get(PointType.BONUS_INTEGRATION.getSubtractiveType())).isEqualTo(PointType.BONUS_INTEGRATION)
    }


    @Test
    void 첫글자만대문자로변경(){
        assertThat(EnumUtils.capitalize("Hello")).isEqualTo("Hello")
        assertThat(EnumUtils.capitalize("world")).isEqualTo("World")
        assertThat(EnumUtils.capitalize("BYE")).isEqualTo("BYE")
        assertThat(EnumUtils.capitalize("!")).isEqualTo("!")
        assertThat(EnumUtils.capitalize("M")).isEqualTo("M")
        assertThat(EnumUtils.capitalize("e")).isEqualTo("E")
        assertThat(EnumUtils.capitalize("123")).isEqualTo("123")
    }
}