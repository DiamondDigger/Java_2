package Demo_String;

import java.util.Arrays;

public class ParserOfWordByLetter {
    private char letter;
    private String[] words;

    String[] ParserByLetter(String[] text, char letter) {
        this.letter = letter;
        this.words = Arrays.stream(text).filter(s -> s.length() > 0 && s.charAt(0) == letter).toArray(String[]::new);
        return words;
    }

}
