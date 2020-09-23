import java.util.ArrayList;
import java.util.HashMap;

/**
 * this method test out all methods in FreqDist.java
 */
public class FreqDistTest {
    public static void main(String[] args) {
        /* Test out methods */
        FreqDist fd = new FreqDist();
        fd.add("dog");
        System.out.println("Should print 1: " + fd.get("dog"));

        HashMap<String, Integer> testMap = new HashMap<>();
        testMap.put("cat",2);
        testMap.put("bird",1);

        fd.setFrequencies(testMap);
        for (String w : fd.getFrequencies().keySet()){
            System.out.println(w + " " + fd.get(w));
        }

        fd.setTotalCount(3);
        System.out.println("Should print 3: " + fd.getTotalCount());
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
        for (String w : spamd.getFrequencies().keySet()){
            System.out.println(w + " " + spamd.get(w));
        }

        System.out.println("\nHam!");
        for (String w : hamd.getFrequencies().keySet()){
            System.out.println(w + " " + hamd.get(w));
        }
    }
}
