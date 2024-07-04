import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class OnesAndZeros {
    public static void main(String[] args) {
        System.out.println(ConvertBinaryArrayToInt2(new ArrayList<>(Arrays.asList(0,1,1,0))));
    }

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        int sum = 0;
        for (int i = 0; i < binary.size(); i++) {
            int v = (int) Math.pow(2, binary.size() - 1 - i) * binary.get(i);
            sum += v;
        }
        return sum;
    }

    public static int ConvertBinaryArrayToInt2(List<Integer> binary) {
        return IntStream.range(0, binary.size())
                .map(i -> binary.get(i) * (int) Math.pow(2, binary.size() - 1 - i))
                .sum();
    }
}
