package hollstein.kim;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class RandomStringProperty extends Property {
    private final Function<Random, String> func;
    private static final Random random = new Random();

    public RandomStringProperty(String key, Function<Random, String> func) {
        super(key, "");
        this.func = func;
    }

    @Override
    public String parse(String text) {
        random.setSeed(text.hashCode());
        return "    " + key + ": \"" + func.apply(random) + "\",\n";
    }

    @Override
    public String encodeMatches(List<String> matches) {
        return null;
    }
}
