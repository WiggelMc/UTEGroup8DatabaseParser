package hollstein.kim;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ParseDatabase {
    public static final List<Property> properties = Arrays.asList(
            new IDProperty(),

            new StringProperty("title","Titel"),
            new StringProperty("series","Serie"),

            new StringProperty("lang","Sprache"),

            new StringArrayProperty("authors","Autoren"),
            new StringArrayProperty("tags","Schlagwörter"),
            new StringArrayProperty("abstract","Abstract"),
            new StringArrayProperty("notes","Notizen"),

            new StringProperty("publicationInfo","Publikationsinformationen"),
            new StringProperty("releaseYear","Jahr erschienen"),
            new StringProperty("releaseType","Publikationstyp"),

            new StringProperty("documentType","Dokumenttyp"),
            new StringProperty("medium","Umfang"),

            new StringArrayProperty("isbn","ISBN"),
            new StringProperty("accessionNr","Akzessionsnummer"),

            new StringProperty("cover", "Cover")      //Custom
    );


    public static void main(String[] args) throws IOException {
        Path sourceDir = Paths.get("files/source/");
        Path outDir = Paths.get("files/out/database.txt");

        Charset charset = StandardCharsets.UTF_8;

        StringBuilder builder = new StringBuilder();


        for (final File file : Objects.requireNonNull(sourceDir.toFile().listFiles())) {

            List<String> lines = Files.readAllLines(file.toPath(), charset);
            String content = String.join("\n", lines);
            builder.append(parseFile(content));
        }

        BufferedWriter wr = Files.newBufferedWriter(outDir, charset);
        wr.write(builder.toString());
        wr.close();
    }

    public static String parseFile(String content) {
        StringBuilder builder = new StringBuilder();
        builder.append("  {\n");
        for (Property property : properties) {
            builder.append(property.parse(content));
        }
        builder.append("  },\n");
        return builder.toString();
    }
}
