public class DuplicateEncoder {
    public static void main(String[] args) {
        System.out.println(encode("din"));
        System.out.println(encode("recede"));
        System.out.println(encode("Success"));
        System.out.println(encode("(( @"));
    }

    static String encode(String word){
        StringBuilder result = new StringBuilder();
        char[] charArray = word.toCharArray();
        for (char letter: charArray){
            long count = word.chars().filter(c -> (char) c == letter).count();
            if (count > 1){
                result.append(")");
            } else {
                result.append("(");
            }
        }
        return result.toString();
    }
}
