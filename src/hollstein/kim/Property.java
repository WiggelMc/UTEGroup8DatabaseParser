package hollstein.kim;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Property {

    public final String key;
    public final String parseString;

    public Property(String key, String parseString) {
        this.key = key;
        this.parseString = parseString;
    }

    public String parse(String text) {
        String regex = "(?<=("+parseString+":\\n))( +[^\\n\\r]*[\\n\\r]+)*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (!matcher.find())
            return "";

        String regexMatch = matcher.group();
        String[] regexMatches = regexMatch.split("\n");

        List<String> matches = new ArrayList<>();
        for (String s : regexMatches) {
            String m = s.trim();
            if (m.length() >= 1)
                matches.add(m);
        }

        if (matches.size() == 0)
            return "";

        return "    " + key + ": " + encodeMatches(matches) + ",\n";
    }

    public abstract String encodeMatches(List<String> matches);
}
