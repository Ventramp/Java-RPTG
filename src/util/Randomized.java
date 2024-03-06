package util;
import java.util.Random;
public interface Randomized {
    static int rng (int min, int max){
        return new Random().nextInt(max-min+1)+min;
    }
}
