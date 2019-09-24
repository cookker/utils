package ms.me.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class VerifyUtilsTest {
    @Test
    public void 인자가모두참이면_오류가나지말아야한다(){
        boolean hasFalse = VerifyUtils.mustBeAllTrue()
                .and(1 == 1)
                .and(2 == 2)
                .hasWrong();
        assertThat(hasFalse).isFalse();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 인자중_하나라도거짓이면_오류가나야한다(){
        VerifyUtils.mustBeAllTrue()
                .and(1 == 1)
                .and(2 == 3)
                .and(5 == 5)
                .elseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void 정해진_익셉션클래스로_오류가나야한다(){
        VerifyUtils.mustBeAllTrue()
                .and(1 == 1)
                .and(2 == 3)
                .elseThrow(() -> new RuntimeException());
    }

    @Test
    public void 모두거짓이어야하는경우_오류가없을경우_확인(){
        boolean hasFalse = VerifyUtils.mustBeAllFalse()
                .and(1 == 2)
                .and(2 == 3)
                .hasWrong();
        assertThat(hasFalse).isFalse();
    }

    @Test
    public void 모두거짓이어야하는경우_오류가있을경우_확인(){
        boolean hasFalse = VerifyUtils.mustBeAllFalse()
                .and(1 == 2)
                .and(2 == 3)
                .and(5 == 5) //같다.
                .hasWrong();
        assertThat(hasFalse).isTrue();
    }
}