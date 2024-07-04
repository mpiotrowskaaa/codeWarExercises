//https://www.codewars.com/kata/595519279be6c575b5000016
public class BattleOfTheCharacters {
    public static void main(String[] args) {
        System.out.println(battle("AAA", "Z"));
        System.out.println(battle("ONE", "TWO"));
        System.out.println(battle("ONE", "NEO"));
        System.out.println(battle("FOUR", "FIVE"));
    }

    public static String battle(final String x, final String y) {
        int sumWordX = calculateWordPower(x);
        int sumWordY = calculateWordPower(y);

        if (sumWordX > sumWordY) {
            return x;
        } else if (sumWordX < sumWordY) {
            return y;
        } else {
            return "Tie!";
        }
    }

    private static int calculateWordPower(String word) {
        return word.chars().map(element -> element - 'A' + 1).sum();
    }
}
