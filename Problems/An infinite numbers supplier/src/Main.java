import java.util.concurrent.atomic.AtomicLong;
import java.util.function.*;

class FunctionUtils {

    public static Supplier<Integer> getInfiniteRange() {
        // write your code here
        AtomicLong x = new AtomicLong();
        return () -> Math.toIntExact(x.getAndIncrement());
    }

}