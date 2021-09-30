package hu.petrik;

public class Main {
    private int simaAdattag = 0;
    private static int statikusAdattag = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(Veletlen.velEgesz(10, 50) + " ");
        }
        System.out.println();
        for (int i = 0; i < 30; i++) {
            System.out.println(Veletlen.velKarakter('a', 'z') + " ");
        }
    }
}
