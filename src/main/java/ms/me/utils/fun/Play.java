package ms.me.utils.fun;

/**
 * 파라미터와 리턴 값이 모두 없는 Functional Interface 입니다.
*/
@FunctionalInterface
public interface Play {
    void execute();

    default Play andThen(Play after){
        return () -> {
            this.execute();
            after.execute();
        };
    }

    default Play before(Play before){
        return () -> {
            before.execute();
            this.execute();
        };
    }
}
