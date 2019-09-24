package ms.me.utils.utils;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class VerifyUtils {

    public static VerifyAllConditionBuilder mustBeAllTrue(){
        return new VerifyAllConditionBuilder(true);
    }

    public static VerifyAllConditionBuilder mustBeAllFalse(){
        return new VerifyAllConditionBuilder(false);
    }

    public static class VerifyAllConditionBuilder {
        private List<Boolean> conditionList = new ArrayList<>();
        private boolean willTrue;

        VerifyAllConditionBuilder(boolean mustBeSomething) {
            this.willTrue = mustBeSomething;
        }

        public VerifyAllConditionBuilder and(boolean mustBeSomething){
            conditionList.add(mustBeSomething);
            return this;
        }

        public boolean hasWrong(){
            return conditionList.stream().anyMatch(b -> b == !willTrue);
        }

        public void elseThrow(){
            if(hasWrong()){
                throw new IllegalArgumentException();
            }
        }

        public void elseThrow(String message){
            if(hasWrong()){
                throw new IllegalArgumentException(message);
            }
        }

        public <X extends RuntimeException> void elseThrow(Supplier<? extends X> exception){
            if(hasWrong()){
                throw exception.get();
            }
        }
    }
}
