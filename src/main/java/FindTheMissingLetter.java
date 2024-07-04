import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindTheMissingLetter {
    public static void main(String[] args) {
        System.out.println(findMissingLetter(new char[] { 'a','b','c','d','f' }));
        System.out.println(findMissingLetter(new char[]{'O', 'Q', 'R', 'S'}));
        System.out.println(findMissingLetter(new char[]{'f', 'g', 'i', 'j', 'k', 'l', 'm'}));
        System.out.println(findMissingLetter(new char[]{'C', 'E'}));
    }

    public static char findMissingLetter(char[] array) {
        List<Character> charList = IntStream.range(0, array.length)
                .mapToObj(i -> array[i])
                .collect(Collectors.toList());

        List<Character> alphabetList = Stream.concat(
                IntStream.range('A', 'Z' + 1).mapToObj(c -> (char) c),
                IntStream.range('a', 'z' + 1).mapToObj(c -> (char) c)
        ).collect(Collectors.toList());

        int indexOfFirstCharInAlphabet = alphabetList.indexOf(charList.get(0));
        int indexOfLastCharInAlphabet = indexOfFirstCharInAlphabet + charList.size() + 1;

        List<Character> subAlphabet = alphabetList.subList(indexOfFirstCharInAlphabet, indexOfLastCharInAlphabet);

        return subAlphabet.stream()
                .filter(e -> !charList.contains(e))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Character not found."));
    }
}
