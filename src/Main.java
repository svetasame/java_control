import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import static java.lang.Integer.parseInt;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        ToyStore toyStore = new ToyStore();
        toyStore.addToy(1, newName(), 2);
        toyStore.addToy(2, newName(), 2);
        toyStore.addToy(3, newName(), 6);

        try {
            FileWriter fileWriter = new FileWriter("result.txt");
            for (int i = 0; i < 10; i++){
                String toy = toyStore.getRandomToyId();
                fileWriter.write(String.valueOf(toy));
                fileWriter.write("\n");
            }
            fileWriter.close();
            System.out.println("Результаты записаны в файл result.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

//проверка процента выпадения игрушек
        int id1Count = 0;
        int id2Count = 0;
        int id3Count = 0;
        int totalIterations = 100000;

        for (int i = 0; i < totalIterations; i++) {
            int id = parseInt(toyStore.getRandomToyId());
            switch (id) {
                case 1 -> id1Count++;
                case 2 -> id2Count++;
                case 3 -> id3Count++;
            }
        }
        double id1Percentage = (double) id1Count / totalIterations * 100;
        double id2Percentage = (double) id2Count / totalIterations * 100;
        double id3Percentage = (double) id3Count / totalIterations * 100;

        System.out.println("1: " + id1Percentage + "%");
        System.out.println("2: " + id2Percentage + "%");
        System.out.println("3: " + id3Percentage + "%");




    }


    private static String newName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }
}