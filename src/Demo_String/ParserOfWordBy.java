package Demo_String;

import java.util.Arrays;

public class ParserOfWordBy {
    private char letter;
    private int length;
    private String[] words;

    String[] parserByLetter(String[] wordsArr, char letter) {
        this.letter = letter;
        this.words = Arrays.stream(wordsArr).filter(s -> s.length() > 0 && s.charAt(0) == this.letter).toArray(String[]::new);
        return words;
    }

    String[] parseByLength(String[] wordsArr, int length){
        this.length= length;
        words = Arrays.stream(wordsArr).filter(s -> s.length()==this.length).toArray(String[]::new);
        return words;
    }

}
