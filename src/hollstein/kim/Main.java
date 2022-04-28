package hollstein.kim;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
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

            new RandomIntProperty("rating", r -> (
                    r.nextInt(5) + 1
            )),

            new RandomIntProperty("availableEbook", r -> (
                    r.nextInt(2)
            )),
            new RandomIntProperty("availableRent", r -> (
                    r.nextInt(3)
            )),
            new RandomIntProperty("rentDelay", r -> (
                    r.nextInt(30) + 1
            )),
            new RandomIntProperty("availableThere", r -> (
                    r.nextInt(2)
            )),


            new StringProperty("cover", "Cover")      //Custom
    );

    public static void main(String[] args) throws IOException {
        ParseDatabase.parseProperties(properties, "files/source/", "files/out/database.txt");
    }
}
