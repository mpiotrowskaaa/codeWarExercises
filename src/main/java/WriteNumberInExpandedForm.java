import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WriteNumberInExpandedForm {
    public static void main(String[] args) {
        System.out.println(expandedForm(71548));
    }

    public static String expandedForm(int num) {
        List<Integer> elements = new ArrayList<>();

        String stringNumber = String.valueOf(num);

        for (int i = 0; i <= stringNumber.length() - 1; i++) {
            int digit = Character.getNumericValue(stringNumber.charAt(i));
            if (digit != 0) {
                int placeValue = (int) Math.pow(10, stringNumber.length() - i - 1);
                elements.add(digit * placeValue);
            }
        }

        return elements.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" + "));
    }

    public static String expandedForm2(int num) {
        String stringNumber = String.valueOf(num);

        List<Integer> elements = IntStream.range(0, stringNumber.length())
                .map(i -> Character.getNumericValue(stringNumber.charAt(i)) * (int) Math.pow(10, stringNumber.length() - i - 1))
                .filter(i -> i != 0)
                .boxed()
                .collect(Collectors.toList());

        return elements.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" + "));
    }
}
