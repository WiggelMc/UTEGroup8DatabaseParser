package hollstein.kim;

import java.util.List;

public class ManualProperty extends Property {
    public ManualProperty(String key, String parseString) {
        super(key, parseString);
    }

    @Override
    public String parse(String text) {
        return "    "+key+": \""+parseString+"\",\n";
    }

    @Override
    public String encodeMatches(List<String> matches) {
        return null;
    }
}
