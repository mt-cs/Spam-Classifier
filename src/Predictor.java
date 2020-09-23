import java.util.ArrayList;

/**
 * This method takes as input a FreqDist and a list of words
 * and returns the sum of the log of the frequency for each word.
 */

public class Predictor {
    /**
     * This method sum all the log of the freq
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
