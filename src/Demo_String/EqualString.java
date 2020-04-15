package Demo_String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        System.out.println("stringBuffer.toString().contentEquals(stringBuilder): "+stringBuffer.toString().contentEquals(stringBuilder));

        System.out.println("stringBuffer.hashCode() = "+stringBuffer.hashCode());    // 885284298
        System.out.println("stringBuilder.hashCode() = "+stringBuilder.hashCode());  // 1389133897

        Pattern patternNew =Pattern.compile("string");
        Matcher matcherNew ;

    }
}
