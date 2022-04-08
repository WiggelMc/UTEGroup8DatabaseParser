package hollstein.kim;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ParseDatabase {

    public static void parseProperties(List<Property> properties, String sourceDirPath, String outFilePath) throws IOException {
        Path sourceDir = Paths.get(sourceDirPath);
        Path outFile = Paths.get(outFilePath);

        Charset charset = StandardCharsets.UTF_8;

        StringBuilder builder = new StringBuilder();


        for (final File file : Objects.requireNonNull(sourceDir.toFile().listFiles())) {
            List<String> lines = Files.readAllLines(file.toPath(), charset);
            String content = String.join("\n", lines);
            builder.append(parseFile(content, properties));
        }

        BufferedWriter wr = Files.newBufferedWriter(outFile, charset);
        wr.write(builder.toString());
        wr.close();
    }

    private static String parseFile(String content, List<Property> properties) {
        StringBuilder builder = new StringBuilder();
        builder.append("  {\n");
        for (Property property : properties) {
            builder.append(property.parse(content));
        }
        builder.append("  },\n");
        return builder.toString();
    }
}
