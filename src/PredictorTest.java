import java.util.ArrayList;
import java.util.Collections;

/**
 * This method tests out if the Predictor.java works
 */

public class PredictorTest {
    public static void main(String[] args) {
        String[] words = {"cat", "dog", "cat", "fish"};
        ArrayList<String> testList = new ArrayList<>();
        Collections.addAll(testList, words);
//        for (String w: words){
//            testList.add(w);
//        }

        FreqDist fd = new FreqDist();
        Predictor p = new Predictor();
        for (String word : testList){
            fd.add(word);
        }

        double val = p.computeLogLikelihood(fd, testList);
        System.out.println(val);
    }
}
