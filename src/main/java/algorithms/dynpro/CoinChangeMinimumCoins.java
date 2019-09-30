package algorithms.dynpro;

import java.util.Arrays;

public class CoinChangeMinimumCoins {

    public String solve(int[] coins, int amount) {
        if (amount == 0) return "";

        Arrays.sort(coins);
        int[][] matrix = new int[coins.length][amount+1];

        for (int j = 1; j < matrix[0].length; j++) {
            int currentCoin = coins[0];
            int currentAmount = j;
            if (currentAmount >= currentCoin && currentAmount % currentCoin == 0) {
                matrix[0][j] = currentAmount / currentCoin;
            } else {
                matrix[0][j] = Integer.MAX_VALUE - 1;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int currentCoin = coins[i];
                int currentAmount = j;
                int remainingAmount = currentAmount - currentCoin;
                if (remainingAmount >= 0) {
                    matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][remainingAmount] + 1);
                } else {
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }

        print(matrix);

        if (matrix[matrix.length-1][matrix[0].length-1] == Integer.MAX_VALUE - 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int currentAmount = amount;
        int coinIndex = matrix.length - 1;
        int counter = 0;
        while (currentAmount > 0 && coinIndex >= 0) {
            if (coinIndex > 0 && matrix[coinIndex][currentAmount] == matrix[coinIndex-1][currentAmount]) {
                if (counter > 0) {
                    sb.append(coins[coinIndex]);
                    sb.append(" * ");
                    sb.append(counter);
                    sb.append(" + ");
                }
                coinIndex--;
                counter = 0;
            } else {
                counter++;
                currentAmount = currentAmount - coins[coinIndex];
            }
        }

        if (counter > 0) {
            sb.append(coins[coinIndex]);
            sb.append(" * ");
            sb.append(counter);
            sb.append(" + ");
        }

        return sb.substring(0, sb.length()-3);
    }

    private void print(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

}
