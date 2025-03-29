import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class faceTest {

    public static void main(String[] args)  throws FileNotFoundException {

        File file = new File("/Users/caidennelson/IdeaProjects/UNWSP Java Class/week 9/src/faceData.txt");
        Scanner fileScanner = new Scanner(file);
        double[][] measure = new double[5][6];
        double[][] ratio = new double[5][15];
        int person = 0;

        while (fileScanner.hasNextLine() && person < 5) {
            String line = fileScanner.nextLine();
            String[] values = line.split(" ");

            for (int i = 0; i < 6; i++) {
                measure[person][i] = Double.parseDouble(values[i]);
            }

            person++;

            }
        fileScanner.close();

        for (person = 0; person < 5; person++) {

            ratio[person][0] = measure[person][0] / measure[person][1];  // A/B
            ratio[person][1] = measure[person][0] / measure[person][2];  // A/C
            ratio[person][2] = measure[person][0] / measure[person][3];  // A/D
            ratio[person][3] = measure[person][0] / measure[person][4];  // A/E
            ratio[person][4] = measure[person][0] / measure[person][5];  // A/F
            ratio[person][5] = measure[person][1] / measure[person][2];  // B/C
            ratio[person][6] = measure[person][1] / measure[person][3];  // B/D
            ratio[person][7] = measure[person][1] / measure[person][4];  // B/E
            ratio[person][8] = measure[person][1] / measure[person][5];  // B/F
            ratio[person][9] = measure[person][2] / measure[person][3];  // C/D
            ratio[person][10] = measure[person][2] / measure[person][4]; // C/E
            ratio[person][11] = measure[person][2] / measure[person][5]; // C/F
            ratio[person][12] = measure[person][3] / measure[person][4]; // D/E
            ratio[person][13] = measure[person][3] / measure[person][5]; // D/F
            ratio[person][14] = measure[person][4] / measure[person][5]; // E/F
        }

        double[] userMeasure = new double[6];

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the measurements for the user:");

        for (int i = 0; i < 6; i++) {

            System.out.print("Measurement #" + (i + 1) + ": ");
            userMeasure[i] = userInput.nextDouble();

        }

        double[] userRatios = new double[15];
        userRatios[0] = userMeasure[0] / userMeasure[1];  // A/B
        userRatios[1] = userMeasure[0] / userMeasure[2];  // A/C
        userRatios[2] = userMeasure[0] / userMeasure[3];  // A/D
        userRatios[3] = userMeasure[0] / userMeasure[4];  // A/E
        userRatios[4] = userMeasure[0] / userMeasure[5];  // A/F
        userRatios[5] = userMeasure[1] / userMeasure[2];  // B/C
        userRatios[6] = userMeasure[1] / userMeasure[3];  // B/D
        userRatios[7] = userMeasure[1] / userMeasure[4];  // B/E
        userRatios[8] = userMeasure[1] / userMeasure[5];  // B/F
        userRatios[9] = userMeasure[2] / userMeasure[3];  // C/D
        userRatios[10] = userMeasure[2] / userMeasure[4]; // C/E
        userRatios[11] = userMeasure[2] / userMeasure[5]; // C/F
        userRatios[12] = userMeasure[3] / userMeasure[4]; // D/E
        userRatios[13] = userMeasure[3] / userMeasure[5]; // D/F
        userRatios[14] = userMeasure[4] / userMeasure[5]; // E/F


        int bestMatch = -1;
        double bestDifference = Double.MAX_VALUE;

        for (person = 0; person < 5; person++) {

            double sumOfSquares = 0.0;

            for (int j = 0; j < 15; j++) {

                double difference = (userRatios[j] - ratio[person][j]) / ratio[person][j];
                sumOfSquares += difference * difference;


            }

            if (sumOfSquares < bestDifference) {

                bestDifference = sumOfSquares;
                bestMatch = person;
            }
        }


        System.out.println("The closest match is Person #" + (bestMatch + 1));
    }
}
