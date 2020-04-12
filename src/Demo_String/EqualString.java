package Demo_String;

public class EqualString {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = new String(str1);

        System.out.println("str1.equals(str2) = "+ str1.equals(str2));
        System.out.println("str1==str2 = "+ (str1==str2));

// String.compareTo and compareToIgnore

        String[] arrStr = {"new", "cat", "Bully","coin", "book", "wood", "catt"};

        for (int i = 0; i < arrStr.length ; i++) {
            for (int j = i+1; j < arrStr.length; j++) {
                if (arrStr[j].compareTo(arrStr[i])<0) {
                    String temp = arrStr[j];
                    arrStr[j]=arrStr[i];
                    arrStr[i]=temp;
                }
            }
        }

        System.out.println("\nString.compareTo:");
        for (String s : arrStr) {
            System.out.println(s);
        }

        for (int i = 0; i < arrStr.length ; i++) {
            for (int j = i+1; j < arrStr.length; j++) {
                if (arrStr[j].compareToIgnoreCase(arrStr[i])<0) {
                    String temp = arrStr[j];
                    arrStr[j]=arrStr[i];
                    arrStr[i]=temp;
                }
            }
        }

        System.out.println("\nString.compareToIgnoreCase:");
        for (String s : arrStr) {
            System.out.println(s);
        }
    }
}
