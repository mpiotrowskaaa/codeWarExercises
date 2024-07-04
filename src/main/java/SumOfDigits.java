public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(digital_root3(456));
    }

    public static int digital_root(int n) {
        while (String.valueOf(n).length()>1) {
            int sum = 0;
            for (char element : String.valueOf(n).toCharArray()) {
                int elementInt = Integer.parseInt(String.valueOf(element));
                sum = sum + elementInt;
            }
            n = sum;
        }
        return n;
    }

    public static int digital_root2(int n) {
        while (String.valueOf(n).length()>1) {
            int sum = 0;
            for (char element : String.valueOf(n).toCharArray()) {
                sum += Integer.parseInt(String.valueOf(element));
            }
            n = sum;
        }
        return n;
    }

    public static int digital_root3(int n) {
        while (n >= 10) {
            n = String.valueOf(n)
                    .chars()
                    .map(Character::getNumericValue)
                    .sum();
        }
        return n;
    }

}
