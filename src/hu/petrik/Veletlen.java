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
    private static List<String> noikerNevek = feltolt("noiikernev.txt");
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

    public static int velEgesz(int min, int max) {
        return rnd.nextInt(max - min + 1) + min;
    }

    public static char velKarakter(char min, char max) {
        return (char)velEgesz(min, max);
    }

    public static String velVezeteknev() {
        return vezetekNevek.get(rnd.nextInt(vezetekNevek.size()));
        //return vezetekNevek.get(velEgesz(0, vezetekNevek.size() - 1));
    }

    /**
     * Véletlen keresztnnevet generáló függvény
     * @param nem a név neme amit szeretnénk generálni: true - férfi, false - nő
     * @return A generált keresztnév String
     */
    public static String velKeresztnev(boolean nem) {
        String keresztnev = "";
        if (nem) {
            keresztnev = ferfikerNevek.get(rnd.nextInt((ferfikerNevek.size())));
        } else {
            keresztnev = noikerNevek.get(rnd.nextInt((noikerNevek.size())));
        }

        return keresztnev;
    }

    public static String velKeresztnev() {
        return velKeresztnev(rnd.nextBoolean());
    }

    public static String velTeljesnev(boolean nem) {
        return String.format("%s %s", velVezeteknev(), velKeresztnev(nem));
    }

    public static String velTeljesnev() {
        return velTeljesnev(rnd.nextBoolean());
    }
}
