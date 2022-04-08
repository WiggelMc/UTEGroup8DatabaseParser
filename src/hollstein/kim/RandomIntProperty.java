package hollstein.kim;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class RandomIntProperty extends Property {
    private final Function<Random, Integer> func;
    private static final Random random = new Random();

    public RandomIntProperty(String key, Function<Random, Integer> func) {
        super(key, "");
        this.func = func;
    }

    @Override
    public String parse(String text) {
        random.setSeed(text.hashCode());
        return "    " + key + ": " + func.apply(random) + ",\n";
    }

    @Override
    public String encodeMatches(List<String> matches) {
        return null;
    }
}
