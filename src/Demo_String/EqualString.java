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


        String textFromArticle = "End-of-Chapter Questions\n" +
                "Short questions covering the key points of each chapter are included at the end of\n" +
                "each chapter. The answers can be found in Appendix C, “Answers to Questions.”\n" +
                "These questions are intended as a self-test for readers, to ensure that they have\n" +
                "understood the material.\n" +
                "Experiments\n" +
                "We include some suggested activities for the reader. These experiments often involve\n" +
                "using the Workshop applets or example programs to examine certain features of an\n" +
                "algorithm’s operation, but some are pencil-and-paper or “thought experiments.”\n" +
                "Programming Projects\n" +
                "Most importantly, we have included at the end of each chapter a number (usually\n" +
                "five) of challenging programming projects. They cover a range of difficulty. The\n" +
                "easiest are simple variations on the example programs. The most challenging are\n" +
                "implementations of topics discussed in the text but for which there are no example\n" +
                "programs. Solutions to the Programming Projects are not provided in this book, but\n" +
                "see the adjacent note.\n" +
                "NOTE\n" +
                "It is expected that the programming projects will be useful for instructors looking for class\n" +
                "assignments. To this end, qualified instructors can obtain suggested solutions to the program�ming projects in the form of source code and executable code. Contact the Sams Web site for\n" +
                "information on Instructors Programs.\n" +
                "What This Book Is About\n" +
                "This book is about data structures and algorithms as used in computer programming.\n" +
                "Data structures are ways in which data is arranged in your computer’s memory \n" +
                "(or stored on disk). Algorithms are the procedures a software program uses to \n" +
                "manipulate the data in these structures.\n" +
                "2 Data Structures & Algorithms in Java, Second Edition\n" +
                "01 0672324539 intro 10/10/02 9:08 AM Page 2\n" +
                "01 0672324539 intro 10/10/02 9:08 AM Page 3\n" +
                "Introduction 3\n" +
                "Almost every computer program, even a simple one, uses data structures and algo�rithms. For example, consider a program that prints address labels. The program\n" +
                "might use an array containing the addresses to be printed and a simple for loop to\n" +
                "step through the array, printing each address.\n" +
                "The array in this example is a data structure, and the for loop, used for sequential\n" +
                "access to the array, executes a simple algorithm. For uncomplicated programs with\n" +
                "small amounts of data, such a simple approach might be all you need. However, for\n" +
                "programs that handle even moderately large amounts of data, or which solve prob�lems that are slightly out of the ordinary, more sophisticated techniques are neces�sary. Simply knowing the syntax of a computer language such as Java or C++ isn’t\n" +
                "enough.\n" +
                "This book is about what you need to know after you’ve learned a programming\n" +
                "language. The material we cover here is typically taught in colleges and universities\n" +
                "as a second-year course in computer science, after a student has mastered the \n" +
                "fundamentals of programming.\n" +
                "What’s Different About This Book\n" +
                "There are dozens of books on data structures and algorithms. What’s different about\n" +
                "this one? Three things:\n" +
                "• Our primary goal in writing this book is to make the topics we cover easy to\n" +
                "understand.\n" +
                "• Demonstration programs called Workshop applets bring to life the topics we\n" +
                "cover, showing you step by step, with “moving pictures,” how data structures\n" +
                "and algorithms work.\n" +
                "• The example code is written in Java, which is easier to understand than C,\n" +
                "C++, or Pascal, the languages traditionally used to demonstrate computer\n" +
                "science topics.\n" +
                "Let’s look at these features in more detail.\n" +
                "Easy to Understand\n" +
                "Typical computer science textbooks are full of theory, mathematical formulas, and\n" +
                "abstruse examples of computer code. This book, on the other hand, concentrates on\n" +
                "simple explanations of techniques that can be applied to real-world problems. We\n" +
                "avoid complex proofs and heavy math. There are lots of figures to augment the text.\n" +
                "Many books on data structures and algorithms include considerable material on soft�ware engineering. Software engineering is a body of study concerned with designing\n" +
                "and implementing large and complex software projects.\n" +
                "However, it’s our belief that data structures and algorithms are complicated enough\n" +
                "without involving this additional discipline, so we have deliberately de-emphasized\n" +
                "software engineering in this book. (We’ll discuss the relationship of data structures\n" +
                "and algorithms to software engineering in Chapter 1, “Overview.”)\n" +
                "Of course, we do use an object-oriented approach, and we discuss various aspects \n" +
                "of object-oriented design as we go along, including a mini-tutorial on OOP in\n" +
                "Chapter 1. Our primary emphasis, however, is on the data structures and algorithms\n" +
                "themselves.\n" +
                "Workshop Applets\n" +
                "From the Sams Web site you can download demonstration programs, in the form of\n" +
                "Java applets, that cover the topics we discuss. These applets, which we call Workshop\n" +
                "applets, will run on most Web browsers. (See Appendix A, “Running the Workshop\n" +
                "Applets and Example Programs,” for more details.) The Workshop applets create\n" +
                "graphic images that show you in “slow motion” how an algorithm works.\n" +
                "For example, in one Workshop applet, each time you push a button, a bar chart\n" +
                "shows you one step in the process of sorting the bars into ascending order. The\n" +
                "values of variables used in the sorting algorithm are also shown, so you can see\n" +
                "exactly how the computer code works when executing the algorithm. Text displayed\n" +
                "in the picture explains what’s happening.\n" +
                "Another applet models a binary tree. Arrows move up and down the tree, so you \n" +
                "can follow the steps involved in inserting or deleting a node from the tree. There \n" +
                "are more than 20 Workshop applets, at least one for each of the major topics in \n" +
                "the book.\n" +
                "These Workshop applets make it far more obvious what a data structure really looks\n" +
                "like, or what an algorithm is supposed to do, than a text description ever could. Of\n" +
                "course, we provide a text description as well. The combination of Workshop applets,\n" +
                "clear text, and illustrations should make things easy.\n" +
                "These Workshop applets are standalone graphics-based programs. You can use them\n" +
                "as a learning tool that augments the material in the book. Note that they’re not the\n" +
                "same as the example code found in the text of the book, which we’ll discuss next.\n" +
                "NOTE\n" +
                "The Workshop applets, in the form of Java .class files, are available on the Sams Web site at\n" +
                "http://www.samspublishing.com/. Enter this book’s ISBN (without the hyphens) in the\n" +
                "Search box and click Search. When the book’s title is displayed, click the title to go to a page\n" +
                "where you can download the applets.\n" +
                "4 Data Structures & Algorithms in Java, Second Edition\n" +
                "01 0672324539 intro 10/10/02 9:08 AM Page 4\n" +
                "01 0672324539 intro 10/10/02 9:08 AM Page 5\n" +
                "Introduction 5\n" +
                "Java Example Code\n" +
                "The Java language is easier to understand (and write) than languages such as C and\n" +
                "C++. The biggest reason for this is that Java doesn’t use pointers. Some people are\n" +
                "surprised that pointers aren’t necessary for the creation of complex data structures\n" +
                "and algorithms. In fact, eliminating pointers makes such code not only easier to\n" +
                "write and to understand, but more secure and less prone to errors as well.\n" +
                "Java is a modern object-oriented language, which means we can use an object�oriented approach for the programming examples. This is important, because object�oriented programming (OOP) offers compelling advantages over the old-fashioned\n" +
                "procedural approach, and is quickly supplanting it for serious program development.\n" +
                "Don’t be alarmed if you aren’t familiar with OOP. It’s not that hard to understand,\n" +
                "especially in a pointer-free environment such as Java. We’ll explain the basics of\n" +
                "OOP in Chapter 1.\n" +
                "NOTE\n" +
                "Like the Workshop applets, the example programs (both source and executable files) can be\n" +
                "downloaded from the Sams Web site.\n" +
                "Who This Book Is For\n" +
                "This book can be used as a text in a Data Structures and Algorithms course, typically\n" +
                "taught in the second year of a computer science curriculum. However, it is also\n" +
                "designed for professional programmers and for anyone else who needs to take the\n" +
                "next step up from merely knowing a programming language. Because it’s easy to\n" +
                "understand, it is also appropriate as a supplemental text to a more formal course.\n" +
                "What You Need to Know Before You Read This Book\n" +
                "The only prerequisite for using this book is a knowledge of some programming\n" +
                "language.\n" +
                "Although the example code is written in Java, you don’t need to know Java to follow\n" +
                "what’s happening. Java is not hard to understand, and we’ve tried to keep the syntax\n" +
                "as general as possible, avoiding baroque or Java-specific constructions whenever\n" +
                "possible.\n" +
                "Of course, it won’t hurt if you’re already familiar with Java. Knowing C++ is essen�tially just as good, because Java syntax is based so closely on C++. The differences are\n" +
                "minor as they apply to our example programs (except for the welcome elimination\n" +
                "of pointers), and we’ll discuss them in Chapter 1.\n" +
                "The Software You Need to Use This Book\n" +
                "To run the Workshop applets, you need a Web browser such as Microsoft Internet\n" +
                "Explorer or Netscape Communicator. You can also use an applet viewer utility.\n" +
                "Applet viewers are available with various Java development systems, including the\n" +
                "free system from Sun Microsystems, which we’ll discuss in Appendix A. \n" +
                "To run the example programs, you can use the MS-DOS utility in Microsoft Windows\n" +
                "(called MS-DOS Prompt) or a similar text-oriented environment.\n" +
                "If you want to modify the source code for the example programs or write your own\n" +
                "programs, you’ll need a Java development system. Such systems are available\n" +
                "commercially, or you can download an excellent basic system from Sun\n" +
                "Microsystems, as described in Appendix A.\n" +
                "How This Book Is Organized\n" +
                "This section is intended for teachers and others who want a quick overview of the\n" +
                "contents of the book. It assumes you’re already familiar with the topics and terms\n" +
                "involved in a study of data structures and algorithms.\n" +
                "The first two chapters are intended to ease the reader into data structures and \n" +
                "algorithms as painlessly as possible.\n" +
                "Chapter 1, “Overview,” presents an overview of the topics to be discussed and intro�duces a small number of terms that will be needed later on. For readers unfamiliar\n" +
                "with object-oriented programming, it summarizes those aspects of this discipline\n" +
                "that will be needed in the balance of the book, and for programmers who know C++\n" +
                "but not Java, the key differences between these languages are reviewed.\n" +
                "Chapter 2, “Arrays,” focuses on arrays. However, there are two subtexts: the use of\n" +
                "classes to encapsulate data storage structures and the class interface. Searching, inser�tion, and deletion in arrays and ordered arrays are covered. Linear searching and\n" +
                "binary searching are explained. Workshop applets demonstrate these algorithms with\n" +
                "unordered and ordered arrays.\n" +
                "In Chapter 3, “Simple Sorting,” we introduce three simple (but slow) sorting tech�niques: the bubble sort, selection sort, and insertion sort. Each is demonstrated by a\n" +
                "Workshop applet.\n" +
                "Chapter 4, “Stacks and Queues,” covers three data structures that can be thought of\n" +
                "as Abstract Data Types (ADTs): the stack, queue, and priority queue. These structures\n" +
                "reappear later in the book, embedded in various algorithms. Each is demonstrated by\n" +
                "a Workshop applet. The concept of ADTs is discussed.\n" +
                "6 Data Structures & Algorithms in Java, Second Edition\n" +
                "01 0672324539 intro 10/10/02 9:08 AM Page 6\n" +
                "01 0672324539 intro 10/10/02 9:08 AM Page 7\n" +
                "Introduction 7\n" +
                "Chapter 5, “Linked Lists,” introduces linked lists, including doubly linked lists and\n" +
                "double-ended lists. The use of references as “painless pointers” in Java is explained. A\n" +
                "Workshop applet shows how insertion, searching, and deletion are carried out.\n" +
                "In Chapter 6, “Recursion,” we explore recursion, one of the few chapter topics that is\n" +
                "not a data structure. Many examples of recursion are given, including the Towers of\n" +
                "Hanoi puzzle and the mergesort, which are demonstrated by Workshop applets.\n" +
                "Chapter 7, “Advanced Sorting,” delves into some advanced sorting techniques:\n" +
                "Shellsort and quicksort. Workshop applets demonstrate Shellsort, partitioning (the\n" +
                "basis of quicksort), and two flavors of quicksort.\n" +
                "In Chapter 8, “Binary Trees,” we begin our exploration of trees. This chapter covers\n" +
                "the simplest popular tree structure: unbalanced binary search trees. A Workshop\n" +
                "applet demonstrates insertion, deletion, and traversal of such trees.\n" +
                "Chapter 9, “Red-Black Trees,” explains red-black trees, one of the most efficient\n" +
                "balanced trees. The Workshop applet demonstrates the rotations and color switches\n" +
                "necessary to balance the tree.\n" +
                "In Chapter 10, “2-3-4 Trees and External Storage,” we cover 2-3-4 trees as an example\n" +
                "of multiway trees. A Workshop applet shows how they work. We also discuss 2-3\n" +
                "trees and the relationship of 2-3-4 trees to B-trees, which are useful in storing exter�nal (disk) files.\n" +
                "Chapter 11, “Hash Tables,” moves into a new field, hash tables. Workshop applets\n" +
                "demonstrate several approaches: linear and quadratic probing, double hashing, and\n" +
                "separate chaining. The hash-table approach to organizing external files is discussed.\n" +
                "In Chapter 12, “Heaps,” we discuss the heap, a specialized tree used as an efficient\n" +
                "implementation of a priority queue.\n" +
                "Chapters 13, “Graphs,” and 14, “Weighted Graphs,” deal with graphs, the first with\n" +
                "unweighted graphs and simple searching algorithms, and the second with weighted\n" +
                "graphs and more complex algorithms involving the minimum spanning trees and\n" +
                "shortest paths.\n" +
                "In Chapter 15, “When to Use What,” we summarize the various data structures\n" +
                "described in earlier chapters, with special attention to which structure is appropriate\n" +
                "in a given situation.\n" +
                "Appendix A, “Running the Workshop Applets and Example Programs,” provides\n" +
                "details on how to use these two kinds of software. It also tells how to use the\n" +
                "Software Development Kit from Sun Microsystems, which can be used to modify the\n" +
                "example programs and develop your own programs, and to run the applets and\n" +
                "example programs.\n" +
                "Appendix B, “Further Reading,” describes some books appropriate for further reading\n" +
                "on data structures and other related topics.\n" +
                "Appendix C, “Answers to Questions,” contains the answers to the end-of-chapter\n" +
                "questions in the text.\n" +
                "Enjoy Yourself!\n" +
                "We hope we’ve made the learning process as painless as possible. Ideally, it should\n" +
                "even be fun. Let us know if you think we’ve succeeded in reaching this ideal, or if\n" +
                "not, where you think improvements might be made.\n" +
                "8 Data Structures & Algorithms in Java, Second Edition\n" +
                "01 0672324539 intro 10/10/02 9:08 AM Page 8\n" +
                "IN THIS CHAPTER\n" +
                "• What Are Data Structures and\n" +
                "Algorithms Good For?\n" +
                "• Overview of Data Structures\n" +
                "• Overview of Algorithms\n" +
                "• Some Definitions\n" +
                "• Object-Oriented\n" +
                "Programming\n" +
                "• Software Engineering\n" +
                "• Java for C++ Programmers\n" +
                "• Java Library Data Structures\n" +
                "1\n" +
                "Overview\n" +
                "As you start this book, you may have some questions:\n" +
                "• What are data structures and algorithms?\n" +
                "• What good will it do me to know about them?\n" +
                "• Why can’t I just use arrays and for loops to handle\n" +
                "my data?\n" +
                "• When does it make sense to apply what I learn here?\n" +
                "This chapter attempts to answer these questions. We’ll also\n" +
                "introduce some terms you’ll need to know and generally\n" +
                "set the stage for the more detailed chapters to follow.\n" +
                "Next, for those of you who haven’t yet been exposed to an\n" +
                "object-oriented language, we’ll briefly explain enough\n" +
                "about OOP to get you started. Finally, for C++ program\u0002mers who don’t know Java we’ll point out some of the\n" +
                "differences between these languages.\n" +
                "What Are Data Structures and\n" +
                "Algorithms Good For?\n" +
                "The subject of this book is data structures and algorithms.\n" +
                "A data structure is an arrangement of data in a computer’s\n" +
                "memory (or sometimes on a disk). Data structures include\n" +
                "arrays, linked lists, stacks, binary trees, and hash tables,\n" +
                "among others. Algorithms manipulate the data in these\n" +
                "structures in various ways, such as searching for a particu\u0002lar data item and sorting the data.";

        Pattern pattern = Pattern.compile("die");
        Pattern patternEmptyPlace = Pattern.compile("[\\W0-9 ]");
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

//        String[] wordArrFrom = Arrays.stream(wordsArrWithoutDuplicate).parallel(filter(s -> s.length()!=0 && (s.charAt(0)=='b' || s.charAt(0)=='B'))).filter(s -> s.length()!=0 && (s.charAt(0)=='b' || s.charAt(0)=='B')).toArray(String[]::new);

        System.out.println("wordArrFromM: " + Arrays.stream(wordArrFromM).collect(Collectors.toList())
                +"\n"+ "wordArrFromM.length= "+wordArrFromM.length);
        System.out.println("wordArrFromA: " + Arrays.stream(wordArrFromA).collect(Collectors.toList())
                +"\n"+ "wordArrFromM.length= "+wordArrFromA.length);
        System.out.println("wordArrFromB: " + Arrays.stream(wordArrFromB).collect(Collectors.toList())
                +"\n"+ "wordArrFromM.length= "+wordArrFromB.length);

        ParserOfWordByLetter parserOfWordByLetter = new ParserOfWordByLetter();
        System.out.println(Arrays.toString(parserOfWordByLetter.ParserByLetter(wordsArrWithoutDuplicate, 'c')));
        System.out.println(Arrays.toString(parserOfWordByLetter.ParserByLetter(wordsArrWithoutDuplicate, 'a')));
        System.out.println(Arrays.toString(parserOfWordByLetter.ParserByLetter(wordsArrWithoutDuplicate, 'l')));
        System.out.println(Arrays.toString(parserOfWordByLetter.ParserByLetter(wordsArrWithoutDuplicate, 'o')));


    }
}
