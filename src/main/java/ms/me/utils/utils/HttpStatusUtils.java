package ms.me.utils.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HttpStatusUtils {

    /**
     * HttpStatus Code에 의한 결과를 기반으로 200번대는 OK처리합니다.
     */
    public static boolean isOk(int statusCodeValue){
        return statusCodeValue / 100 == 2;
    }

    public static boolean isNotOk(int statusCodeValue){
        return !isOk(statusCodeValue);
    }
}
