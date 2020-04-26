package algorithms.dynamicprog;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://algorithms.tutorialhorizon.com/colorful-numbers/
 */
public class ColorfulNumber {
// 123
    public static boolean isColorful(long number) {
        String str = String.valueOf(number);

        if (str.length() < 2) return false;

        Set<Long> products = new HashSet<>();
        HashMap<String, Long> memo = new HashMap<>();

        for (int start = 0; start < str.length(); start++) {
            long newProduct = Long.parseLong(String.valueOf(str.charAt(start)));
            if (products.contains(newProduct)) {
                return false;
            }
            products.add(newProduct);
            memo.put(start + "-" + start, newProduct);
        }

        for (int l = 2; l <= str.length() - 1; l++) {
            HashMap<String, Long> newProducts = new HashMap<>();
            for (int start = 0; start <= str.length() - l; start++) {
                int end = start + l - 1;
                long prevProduct = memo.get(start + "-" + (end - 1));
                long newProduct = prevProduct * Long.parseLong(String.valueOf(str.charAt(end)));
                if (products.contains(newProduct)) {
                    return false;
                }
                products.add(newProduct);
                newProducts.put(start + "-" + end, newProduct);
            }
            memo = newProducts;
        }
        return true;
    }
}
