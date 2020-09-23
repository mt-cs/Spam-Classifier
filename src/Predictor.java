import java.util.ArrayList;

/**
 * This predictor class contains computeLogLikelihood to
 * classify spam emails with Naive Bayes principal.
 */

public class Predictor {
    /**
     * takes as input a FreqDist and a list of words
     * and returns the sum of the log of the frequency for each word.
     * @param fd = FreqDist
     * @param wordsToScore a list of words
     * @return sum of the log of the frequency of each word
     */
    public double computeLogLikelihood(FreqDist fd, ArrayList<String> wordsToScore) {
        Double sum = 0.0;

        for(String w: wordsToScore){
                sum += Math.log(fd.get(w)/(double)fd.getTotalCount());
            }

        return sum;
    }
}
