//This is an edited version of the code
import java.util.PriorityQueue;
import java.util.Scanner;

//I am changing the scanner objects name:
public class Least_Penalty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Read the number of banks and the penalty rate
        int numberOfBanks = sc.nextInt();
        double penaltyRate = sc.nextDouble();
        // Create a min-heap to store bank amounts
        PriorityQueue<Double> bankAmounts = new PriorityQueue<>();
        // Read and add each bank's amount to the min-heap
        for (int i = 0; i < numberOfBanks; i++) {
            bankAmounts.add(sc.nextDouble());
        }
        // Merge banks until only one remains
        while (bankAmounts.size() > 1) {
            double smallest = bankAmounts.poll();
            double nextSmallest = bankAmounts.poll();
            // Calculate the combined amount after applying the penalty
            double combinedAmount = smallest + nextSmallest;
            double amountAfterPenalty = combinedAmount - (combinedAmount * (penaltyRate / 100.0));
            // Add the new amount back to the min-heap
            bankAmounts.add(amountAfterPenalty);
        }
        // Print the final amount with two decimal places
        System.out.printf("%.2f\n", bankAmounts.poll());
        // Close the scanner
        sc.close();
    }
}
