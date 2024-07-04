// https://www.codewars.com/kata/513e08acc600c94f01000001
public class RgbToHex {
    public static void main(String[] args) {
        System.out.println(rgb(0, 0, 0));
        System.out.println(rgb2(0, 0, 0));
        System.out.println(rgb(1, 2, 3));
        System.out.println(rgb2(1, 2, 3));
        System.out.println(rgb(255, 255, 255));
        System.out.println(rgb2(255, 255, 255));
        System.out.println(rgb(254, 253, 252));
        System.out.println(rgb2(254, 253, 252));
        System.out.println(rgb(-20, 275, 125));
        System.out.println(rgb2(-20, 275, 125));
    }

    public static String rgb(int r, int g, int b) {
        r = checkValueRange(r);
        g = checkValueRange(g);
        b = checkValueRange(b);
        return toHex(r) + toHex(g) + toHex(b);
    }

    private static String toHex(int number) {
        int firstPart = Math.abs(number / 16);
        int secondPart = number - (16 * firstPart);
        return calculate(firstPart) + calculate(secondPart);
    }

    public static String rgb2(int r, int g, int b) {
        r = checkValueRange(r);
        g = checkValueRange(g);
        b = checkValueRange(b);
        return toHex2(r) + toHex2(g) + toHex2(b);
    }

    private static String toHex2(int number) {
        return String.format("%02X", number);
    }

    private static int checkValueRange(int number){
        return Math.max(0, Math.min(number, 255));
    }

    private static String calculate(int number) {
        if (number >= 0 && number <= 9) {
            return String.valueOf(number);
        } else if (number == 10) {
            return "A";
        } else if (number == 11) {
            return "B";
        } else if (number == 12) {
            return "C";
        } else if (number == 13) {
            return "D";
        } else if (number == 14) {
            return "E";
        } else {
            return "F";
        }
    }
}
