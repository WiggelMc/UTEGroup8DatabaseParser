package hollstein.kim;

import java.util.List;
import java.util.stream.Collectors;

public class StringArrayProperty extends Property {
    public StringArrayProperty(String key, String parseString) {
        super(key, parseString);
    }

    @Override
    public String encodeMatches(List<String> matches) {
        return "[\n"+matches.stream().map(s -> "      \""+s+"\",\n").collect(Collectors.joining())+"    ]";
    }
}
