import java.util.ArrayList;

/**
 * This class contains a simple main method to test out Processor.java
 */
public class ProcessorTest {
    public static void main(String[] args) {
        ArrayList<String> parsedWords;
        Processor processor1 = new Processor("/Users/marisatania/IdeaProjects/project-1-spam-classifier-mt-cs/spamtrain/0004.1874ab60c71f0b31b580f313a3f6e777");
        parsedWords = processor1.parseFile();

        String test = "eat21331!";
        test = processor1.stripPunctuation(test);
        System.out.println(processor1.isStopword(test));
        System.out.println(processor1.isJunk(test));

        for (String w: parsedWords){
            System.out.println(w);
        }
    }
}
