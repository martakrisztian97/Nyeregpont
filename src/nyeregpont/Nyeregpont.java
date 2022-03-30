package nyeregpont;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Nyeregpont {

    /**
     * Egy input szövegfájlból beolvassa a mátrixot egy double[][] tömbbe.
     * @param fajlnev A beolvasandó fájl neve.
     * @return A mátrixot tartalmazó double[][] tömböt adja vissza.
     */
    public static double[][] fajlBeolvasas(String fajlnev) {
        Scanner sc = null;
        try {
            sc = new Scanner(new BufferedReader(new FileReader(fajlnev)));
        } catch (IOException e) {
            System.out.println("HIBA: " + e.getMessage());
        }
        int sorDB = 0;
        String segedSor = null;
        while (sc.hasNextLine()) {
            segedSor = sc.nextLine();
            sorDB++;
        }
        int oszlopDB = segedSor.trim().split(" ").length;
        double[][] matrix = new double[sorDB][oszlopDB];

        try {
            sc = new Scanner(new BufferedReader(new FileReader(fajlnev)));
        } catch (IOException e) {
            System.out.println("HIBA: " + e.getMessage());
        }
        while (sc.hasNextLine()) {
            for (int i = 0; i < matrix.length; i++) {
                String[] aktualisSor = sc.nextLine().trim().split(" ");
                for (int j = 0; j < aktualisSor.length; j++) {
                    matrix[i][j] = Double.parseDouble(aktualisSor[j]);
                }
            }
        }
        return matrix;
    }

    /**
     * Kiírja a mátrixot.
     * @param matrix A mátrix.
     */
    public static void matrixKiir(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " \t");
            }
            System.out.println();
        }
    }

    /**
     * Megvizsgálja a mátrixot, hogy található-e benne nyeregpont.
     * @param matrix A mátrix.
     * @return Visszaadja, hogy a mátrixban található-e nyeregpont.
     */
    public static boolean nyeregpontVizsgal(double[][] matrix) {
        boolean nyeregpont = false;
        int sor = matrix.length;
        int oszlop = matrix[0].length;
        List<Double> sorMin = new ArrayList<>();    // sorok minimumai
        List<Double> oszlopMax = new ArrayList<>(); // oszlopok maximumai

        double min;
        for (int i = 0; i < sor; i++) {
            min = matrix[i][0];
            for (int j = 0; j < oszlop; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            sorMin.add(min);
        }

        double max;
        for (int i = 0; i < oszlop; i++) {
            max = matrix[0][i];
            for (int j = 0; j < sor; j++) {
                if (matrix[j][i] > max) {
                    max = matrix[j][i];
                }
            }
            oszlopMax.add(max);
        }

        for (int i = 0; i < sor; i++) {
            if (oszlopMax.contains(sorMin.get(i))) {
                nyeregpont = true;
            }
        }
        return nyeregpont;
    }

    public static void main(String[] args) {
        double[][] matrix = fajlBeolvasas("matrix.txt");
        matrixKiir(matrix);
        if (nyeregpontVizsgal(matrix)) {
            System.out.println("Ezen mátrix esetén nyeregpont található.");
        } else {
            System.out.println("Ezen mátrix esetén nyeregpont NEM található.");
        }
    }
}
