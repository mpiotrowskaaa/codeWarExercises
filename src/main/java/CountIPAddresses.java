import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountIPAddresses {
    public static void main(String[] args) {
        System.out.println(ipsBetween("10.0.0.0", "10.0.0.50"));
        System.out.println(ipsBetween("20.0.0.10", "20.0.1.0"));
        System.out.println(ipsBetween("0.0.0.0", "255.255.255.255"));
        System.out.println(ipsBetween("10.0.0.0", "10.0.0.50"));
        System.out.println(ipsBetween("10.0.0.0", "10.0.1.0"));
        System.out.println(ipsBetween("20.0.0.10", "20.0.1.0"));
    }

    public static long ipsBetween(String start, String end) {
        String[] startTable = start.split("\\.");
        String[] endTable = end.split("\\.");
        List<Integer> startTableInt = convertToIntegerList(startTable);
        List<Integer> endTableInt = convertToIntegerList(endTable);

        long startSum = calculateSum(startTableInt);
        long endSum = calculateSum(endTableInt);
        return endSum - startSum;
    }

    private static List<Integer> convertToIntegerList(String[] table) {
        return Arrays.stream(table)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static long calculateSum(List<Integer> table) {
        long sum3 = table.get(3);
        long sum2 = table.get(2);
        long sum1 = table.get(1);
        long sum0 = table.get(0);

        if (sum3 == 0 && sum2 > 0) {
            sum3 = (long) (255 * Math.pow(sum3,3));
        }
        if (sum2 == 0 && sum1 > 0) {
            sum2 = (long) (255 * Math.pow(sum2,3));
        }
        if (sum1 == 0 && sum0!=0) {
            sum1 = (long) (255 * Math.pow(sum2,2));
        }

        return sum3 + sum2 + sum1;
    }
}
