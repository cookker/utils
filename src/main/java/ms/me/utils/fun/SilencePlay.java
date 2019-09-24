package ms.me.utils.fun;

@FunctionalInterface
public interface SilencePlay {
    void execute() throws Exception;

    static void ignoreError(final SilencePlay annoyingPlay) {
        try {
            annoyingPlay.execute();
        } catch (Exception ignore) {
        }
    }
}
