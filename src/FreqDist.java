import java.util.HashMap;

/**
 *  A freqDist is a wrapper for a Map that will tell us, for a given list of words,
 *  how often each word appeared in a corpus.
 */

public class FreqDist {
    private HashMap<String, Integer> frequencies;
    private int totalCount;

    /**
     * empty constructor
     */
    public FreqDist() {
        frequencies = new HashMap<>();
        totalCount = 0;
    }

    /**
     * accessor for frequencies
     * @return frequencies
     */
    public HashMap<String, Integer> getFrequencies() {
        return frequencies;
    }

    /**
     * mutator for frequencies
     * @param frequencies = hashmap
     */
    public void setFrequencies(HashMap<String, Integer> frequencies) {
        this.frequencies = frequencies;
    }

    /**
     * accessor for totalCount
     * @return totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * mutator for total count
     * @param totalCount total number of word
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * add new word to frequencies hashmap
     * @param newWord word to be added
     */
    public void add(String newWord) {
        int val;
        totalCount++;
        if (frequencies.containsKey(newWord)) {
            val = frequencies.get(newWord);
            val = val + 1;
            frequencies.put(newWord, val);
        } else {
            frequencies.put(newWord, 1);
        }
    }

    /**
     * if a word is not present in our frequency dictionary, assume it has a count of 1.
     * @param newWord word that you want to get from hashmap
     * @return frequencies.get(newWord) if present or -1 if not
     */
    public int get(String newWord) {
        return frequencies.getOrDefault(newWord, 1);
    }
}
