package hollstein.kim;

import sun.security.provider.MD5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class IDProperty extends Property {
    public static int id = 1;

    public IDProperty() {
        super("", "");
    }

    @Override
    public String parse(String text) {
        int rand = (int)(Math.random()*10000);
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(text.getBytes());
            byte[] b = m.digest();
            String str = String.format("%04d",id++) + "-" + new BigInteger(1,b).toString(16).toUpperCase();
            return "    id: \"" + str + "\",\n";
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String encodeMatches(List<String> matches) {
        return null;
    }
}
