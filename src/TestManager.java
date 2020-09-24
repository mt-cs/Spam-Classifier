import java.io.File;
import java.util.ArrayList;
import java.util.Objects;


/**
 * This method calls Processor, parse file, count words using FreqDist,
 * and compute loglikelihood using Predictor
 */
public class TestManager {

    public static void main(String[] args) {
        FreqDist spam = new FreqDist();
        FreqDist ham = new FreqDist();

        ArrayList<String> words;
        Processor p;
        Predictor pr = new Predictor();
        double spamval, hamval;
        int correctSpam = 0, correctHam=0, incorrectSpam = 0, incorrectHam = 0;

        /* read in 100 spam and store in a FreqDist. */
        File spamFolder = new File("spamtrain");
        for (String filename : Objects.requireNonNull(spamFolder.list())) {
            p = new Processor("spamtrain/" + filename);
            words = p.parseFile();
            for (String w : words) {
                spam.add(w);
            }
        }

        /* read in 100 ham and store in a FreqDist */
        File hamFolder = new File("hamtrain");
        for (String filename : Objects.requireNonNull(hamFolder.list())) {
            p = new Processor("hamtrain/" + filename);
            words = p.parseFile();
            for (String w : words) {
                ham.add(w);
            }
        }

        /* take 50 ham test emails, compute loglikelihood */
        File spamTestFolder = new File("spamtest");
        for (String filename : Objects.requireNonNull(spamTestFolder.list())) {
            p = new Processor("spamtest/" + filename);
            words = p.parseFile();
            spamval = pr.computeLogLikelihood(spam, words);
            hamval = pr.computeLogLikelihood(ham, words);
            System.out.println(spamval + " " + hamval);
            if (spamval > hamval) {
                System.out.println("Correct");
                correctSpam++;
            } else {
                System.out.println("Incorrect");
                incorrectSpam++;
            }
        }

        /* take 50 spam test emails, compute loglikelihood */
        File hamTestFolder = new File("hamtest");
        for (String filename : Objects.requireNonNull(hamTestFolder.list())) {
            p = new Processor("hamtest/" + filename);
            words = p.parseFile();
            spamval = pr.computeLogLikelihood(spam, words);
            hamval = pr.computeLogLikelihood(ham, words);
            System.out.println(spamval + " " + hamval);
            if (spamval < hamval) {
                System.out.println("Correct");
                correctHam++;
            } else {
                System.out.println("Incorrect");
                incorrectHam++;
            }
        }

        /* Display how many emails of each type were classified correctly. */
        System.out.println("\nSPAM");
        System.out.println("==================");
        System.out.println("Correct spam: " + correctSpam);
        System.out.println("Incorrect spam: " + incorrectSpam);
        System.out.println("\nHAM");
        System.out.println("==================");
        System.out.println("Correct ham: " + correctHam);
        System.out.println("Incorrect ham: " + incorrectHam);
    }
}








