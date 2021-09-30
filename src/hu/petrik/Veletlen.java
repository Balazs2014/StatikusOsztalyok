package hu.petrik;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Veletlen {
    private static Random rnd = new Random();
    private static List<String> vezetekNevek = feltolt("veznev.txt");
    private static List<String> ferfikerNevek = feltolt("ferfikernev.txt");
    private Veletlen() {}

    private static List<String> feltolt(String fajlNev) {
        List<String> fajlSorai = new ArrayList<>();
        try {
            fajlSorai = Files.readAllLines(Paths.get(fajlNev));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return fajlSorai;
    }
}
