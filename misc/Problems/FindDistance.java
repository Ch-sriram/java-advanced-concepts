package misc.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Finds distances between the inputted list of integers.
 *
 * @author chandrabhatta.sriram
 */
public class FindDistance {
    public static void main(String[] args) {
        System.out.println("Finds distances between the inputted list of integers.");
        try(Scanner s = new Scanner(System.in)) {
            System.out.print("int[] size? ");
            int size = s.nextInt();

            System.out.print("int[]: ");
            int[] inputList = new int[size];
            for (int i = 0; i < size; ++i) inputList[i] = s.nextInt();

            Map<Integer, List<Integer>> distances = new LinkedHashMap<>();
            for (int i = 0; i < inputList.length; i++) {
                int key = inputList[i];
                if (!distances.containsKey(key)) {
                    List<Integer> indices = Arrays.asList(i);
                    distances.put(key, new ArrayList<>(indices));
                } else {
                    List<Integer> indices = distances.get(key);
                    assert (indices != null);
                    indices.add(i);
                }
            }

            for (Map.Entry<Integer, List<Integer>> distance : distances.entrySet()) {
                System.out.print("Distances between each occurence of " + distance.getKey() + " are: ");
                List<Integer> indices = distance.getValue();
                if (indices.size() == 1) {
                    System.out.println(0);
                    continue;
                }
                for (int i = 1; i < indices.size(); ++i) {
                    int distanceBetweenCurrentAndPrevious = Math.abs(indices.get(i) - indices.get(i-1));
                    boolean isLastElement = (i + 1) == indices.size();
                    int previousIndex = indices.get(i-1);
                    int currentIndex = indices.get(i);
                    System.out.print(distanceBetweenCurrentAndPrevious + " (" + previousIndex +  " -> " + currentIndex + ")" + (!isLastElement ? ", " : "\n"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
