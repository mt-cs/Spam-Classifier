import java.util.ArrayList;

/**
 * this method test out all methods in FreqDist.java
 */
public class FreqDistTest {
    public static void main(String[] args) {
        ArrayList<String> spamWords;
        ArrayList<String> hamWords;
        FreqDist spamd = new FreqDist();
        FreqDist hamd = new FreqDist();

        Processor spamp = new Processor("/Users/marisatania/IdeaProjects/project-1-spam-classifier-mt-cs/spamtrain/0012.7bc8e619ad0264979edce15083e70a02");
        Processor hamp = new Processor("/Users/marisatania/IdeaProjects/project-1-spam-classifier-mt-cs/hamtrain/0006.ee8b0dba12856155222be180ba122058");

        spamWords = spamp.parseFile();
        hamWords = hamp.parseFile();

        for (String w : spamWords){
            spamd.add(w);
        }

        for (String w : hamWords){
            hamd.add(w);
        }

        System.out.println("Spam!");
        for (String w : spamd.frequencies.keySet()){
            System.out.println(w + " " + spamd.get(w));
        }

        System.out.println("\nHam!");
        for (String w : hamd.frequencies.keySet()){
            System.out.println(w + " " + hamd.get(w));
        }
    }
}
