package Demo_String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private Pattern pattern;
    private Matcher matcher;
    private Matcher group;

    public Parser(String word) {
        this.pattern = Pattern.compile(word);
    }
}
