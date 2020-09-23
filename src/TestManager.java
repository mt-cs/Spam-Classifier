import java.io.File;
import java.util.ArrayList;


/**
 * Extend this to evaluate the fraction of spam and ham emails your classifier identifies correctly.
 */
public class TestManager {

    public static void main(String args[]) {
        FreqDist spam = new FreqDist();
        FreqDist ham = new FreqDist();

        ArrayList<String> words;
        Processor p;
        Predictor pr = new Predictor();
        double spamval, hamval;
        int totalSpam = 0, totalHam=0;

        /* read in 100 spam and store in a FreqDist. */
        File spamFolder = new File("spamtrain");
        for (String filename : spamFolder.list()) {
            p = new Processor("spamtrain/" + filename);
            words = p.parseFile();
            for (String w : words) {
                spam.add(w);
            }

        }

        /* read in 100 ham and store in a FreqDist */
        File hamFolder = new File("hamtrain");
        for (String filename : hamFolder.list()) {
            p = new Processor("hamtrain/" + filename);
            words = p.parseFile();
            for (String w : words) {
                ham.add(w);
            }

        }

        /* take 50 ham test emails, compute loglikelihood */
        File spamTestFolder = new File("spamtest");
        for (String filename : spamTestFolder.list()) {
            p = new Processor("spamtest/" + filename);
            words = p.parseFile();
            spamval = pr.computeLogLikelihood(spam, words);
            hamval = pr.computeLogLikelihood(ham, words);
            System.out.println(spamval + " " + hamval);
            if (spamval > hamval) {
                System.out.println("Correct");
                totalSpam++;
            } else {
                System.out.println("Incorrect");
            }
        }

        /* take 50 spam test emails, compute loglikelihood */
        File hamTestFolder = new File("hamtest");
        for (String filename : hamTestFolder.list()) {
            p = new Processor("hamtest/" + filename);
            words = p.parseFile();
            spamval = pr.computeLogLikelihood(spam, words);
            hamval = pr.computeLogLikelihood(ham, words);
            System.out.println(spamval + " " + hamval);
            if (spamval < hamval) {
                System.out.println("Correct");
                totalHam++;
            } else {
                System.out.println("Incorrect");
            }
        }

        System.out.println("Total spam: " + totalSpam);
        System.out.println("Total ham: " + totalHam);
    }
}








