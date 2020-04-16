package Demo_String;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EqualString {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = new String(str1);

        System.out.println("str1.equals(str2) = " + str1.equals(str2));
        System.out.println("str1==str2 = " + (str1 == str2));

        // String.compareTo and compareToIgnore
        String[] arrStr = {"new", "cat", "Bully", "coin", "book", "wood", "catt"};

        for (int i = 0; i < arrStr.length; i++) {
            for (int j = i + 1; j < arrStr.length; j++) {
                if (arrStr[j].compareTo(arrStr[i]) < 0) {
                    String temp = arrStr[j];
                    arrStr[j] = arrStr[i];
                    arrStr[i] = temp;
                }
            }
        }

        System.out.println("\nString.compareTo:");
        for (String s : arrStr) {
            System.out.println(s);
        }

        for (int i = 0; i < arrStr.length; i++) {
            for (int j = i + 1; j < arrStr.length; j++) {
                if (arrStr[j].compareToIgnoreCase(arrStr[i]) < 0) {
                    String temp = arrStr[j];
                    arrStr[j] = arrStr[i];
                    arrStr[i] = temp;
                }
            }
        }

        System.out.println("\nString.compareToIgnoreCase:");
        for (String s : arrStr) {
            System.out.println(s);
        }


        // String.intern - ищет такой объект в пуле литералов - если находит - возврашщает ссылку на него, нет - добавляет в пул
        String s1 = "JavaMachine";
        String s2 = new String(s1);

        System.out.println("s1 == s2: " + (s1 == s2));
        s2 = s2.intern();
        System.out.println("s1 == s2: " + (s1 == s2));

//StringBuffer and StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer(35);
        stringBuilder.append("Java");
        stringBuffer.append("Java");
        System.out.println("stringBuffer.equals(stringBuilder): " + (stringBuffer.equals(stringBuilder)));
        System.out.println("stringBuffer.hashCode()==stringBuilder.hashCode(): " + (stringBuffer.hashCode() == stringBuilder.hashCode()));
        System.out.println("stringBuffer.toString().hashCode() == stringBuilder.toString().hashCode(): " + (stringBuffer.toString().hashCode() == stringBuilder.toString().hashCode()));
        System.out.println("stringBuffer.toString() == stringBuilder.toString(): " + (stringBuffer.toString() == stringBuilder.toString()));
        System.out.println("stringBuffer.toString().equals(stringBuilder.toString()): " + (stringBuffer.toString().equals(stringBuilder.toString())));
        System.out.println("stringBuffer.toString().contentEquals(stringBuilder): " + stringBuffer.toString().contentEquals(stringBuilder));

        System.out.println("stringBuffer.hashCode() = " + stringBuffer.hashCode());    // 885284298
        System.out.println("stringBuilder.hashCode() = " + stringBuilder.hashCode());  // 1389133897

// Pattern and Matcher
        /*
        Pattern patternNew = pattern.compile(String regex)   - создание patternNew
        Matcher matcherNew = patternNew.matcher(String str)     - создание matcherNew - класс строка
         */
        Pattern patternNew = Pattern.compile("string");
        Matcher matcherNew = patternNew.matcher("stringstring stringBuffer stringg 34string");
        int i = 1;
        while (matcherNew.find()) {
            System.out.println("matcherNew.group(): " + i + ". " + matcherNew.group());
            i++;
        }
        //Pattern.replaceAll
        String changedRegex = matcherNew.replaceAll("[*]");
        System.out.println("changedRegex: " + changedRegex);


        String textFromArticle = "Conan Doyle did not want Sherlock Holmes to live for so long! In fact he tried to stop writing  the Sherlock Holmes stories in 1893, with the story \"The Final Problem\". Holmes and Moriarty, his big enemy, had a fight at the Riechenbach Falls in Switzerland, and they fell together into the water. But the readers protested so much that Conan Doyle was forced to \"resurrect\" the detective. Holmes \"miraculously\" survived, and there was another book of stories ten years later. Now at Meiringen in Switzerland, at the site of the falls, there is a \"Sherlock Holmes pub\" and a \"Sherlock Holmes hotel\", and a large Sherlock Holmes museum.\n" +
                "   In England, there is a big \"Sherlock Holmes Society\". Members of the Society take the stories very seriously. They have meetings and discussions, where they talk about the books, and discuss some of the problems that still exist. For example, in one of the stories, Holmes took a train from London to Paris, but arrived in Paris before the train! How did he do it? One member looked at the train timetables of the 1890's, and found an explanation: He could have changed trains at Reading, near London, to arrive at the coast more quickly! It's elementary of course, for Sherlock Holmes.\n" +
                "   Sherlock Holmes is a legend that will not die.. Every week  about 40 cards and letters, addressed to Mr. Holmes, are delivered at his address, 221B, Baker Street, in London. People ask the detective to solve their personal mysteries for them — some letters even asked him to explain international events!\n" +
                "   There is a secretary who answers all the letters to Sherlock Holmes: she always says that Holmes has retired, and that he now lives in the country, where he keeps bees. It's a pity!";

        Pattern pattern = Pattern.compile("die");
        Pattern patternEmptyPlace = Pattern.compile("[\\W]");
        Matcher matcher = pattern.matcher(textFromArticle);
        String[] wordsArr = patternEmptyPlace.split(textFromArticle);

        System.out.println("Arrays.asList(wordsArr): " + Arrays.asList(wordsArr)
                + "\n" + Arrays.asList(wordsArr).size());
        int countOfRegex = 0;
        while (matcher.find()) {
            countOfRegex++;
        }
        System.out.println("countOfRegex = " + countOfRegex);
        String word = "to";
        int numW = (int) Arrays.stream(wordsArr).filter(word::equals).count();
        System.out.println("num= " + numW);

        String[] wordsArrWithoutDuplicate = Arrays.stream(wordsArr).distinct().sorted().toArray(String[]::new);
        for (int j = 0; j < wordsArrWithoutDuplicate.length; j++) {
            System.out.print(wordsArrWithoutDuplicate[j] + " ,");
            if (j == 100) {
                System.out.println("\n");
            }
        }
        System.out.println();
        System.out.println("wordsArrWithoutDuplicate.length= " + wordsArrWithoutDuplicate.length);

        List<String> list = Arrays.stream(wordsArr).distinct().collect(Collectors.toList());
        System.out.println("list: " + list + "\n" + "list.size()= " + list.size());
        String[] wordArrFromM = Arrays.stream(wordsArrWithoutDuplicate).filter(s -> s.length()!=0 && (s.charAt(0)=='m'|| s.charAt(0)=='M')).toArray(String[]::new);
        String[] wordArrFromA = Arrays.stream(wordsArrWithoutDuplicate).filter(s -> s.length()!=0 && (s.charAt(0)=='a'|| s.charAt(0)=='A')).toArray(String[]::new);
        String[] wordArrFromB = Arrays.stream(wordsArrWithoutDuplicate).filter(s -> s.length()!=0 && (s.charAt(0)=='b' || s.charAt(0)=='B')).toArray(String[]::new);

        System.out.println("wordArrFromM: " + Arrays.stream(wordArrFromM).collect(Collectors.toList())
                +"\n"+ "wordArrFromM.length= "+wordArrFromM.length);
        System.out.println("wordArrFromA: " + Arrays.stream(wordArrFromA).collect(Collectors.toList())
                +"\n"+ "wordArrFromM.length= "+wordArrFromA.length);
        System.out.println("wordArrFromB: " + Arrays.stream(wordArrFromB).collect(Collectors.toList())
                +"\n"+ "wordArrFromM.length= "+wordArrFromB.length);

    }
}
