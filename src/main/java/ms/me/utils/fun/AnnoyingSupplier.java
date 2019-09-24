package ms.me.utils.fun;

@FunctionalInterface
public interface AnnoyingSupplier<R> {
    R get() throws Exception;

    static <R> R quiet(final AnnoyingSupplier<R> noisySupplier) {
        try {
            return noisySupplier.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
