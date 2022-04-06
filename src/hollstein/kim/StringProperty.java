package hollstein.kim;

import java.util.List;

public class StringProperty extends Property {
    public StringProperty(String key, String parseString) {
        super(key, parseString);
    }

    @Override
    public String encodeMatches(List<String> matches) {
        return "\""+matches.get(0)+"\"";
    }
}
