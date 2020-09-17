import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

/**
 * The Processor class will open a file and tokenize it.
 */
public class Processor {
    public static final String[] stopwords = {"i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "you're",
        "you've", "you'll", "you'd", "your", "yours", "yourself", "yourselves", "he", "him", "his", "himself", "she",
        "she's", "her", "hers", "herself", "it", "it's", "its", "itself", "they", "them", "their", "theirs",
        "themselves", "what", "which", "who", "whom", "this", "that", "that'll", "these", "those", "am", "is", "are",
        "was", "were", "be", "been", "being", "have", "has", "had", "having", "do", "does", "did", "doing",
        "a", "an", "the", "and", "but", "if", "or", "because", "as", "until", "while", "of", "at", "by", "for",
        "with", "about", "against", "between", "into", "through", "during", "before", "after", "above", "below", "to",
        "from", "up", "down", "in", "out", "on", "off", "over", "under", "again", "further", "then", "once", "here",
        "there", "when", "where", "why", "how", "all", "any", "both", "each", "few", "more", "most", "other", "some",
        "such", "no", "nor", "not", "only", "own", "same", "so", "than", "too", "very", "can", "will", "just", "don't",
        "should", "should've", "now", "aren't", "couldn't", "didn't", "doesn't",  "hasn't", "haven't", "isn't", "shouldn't",
        "wasn't", "weren't", "won't", "wouldn't"};

    String filename;

    /**
     * Constructor with file name as parameter
     * @param fname file name
     */
    public Processor(String fname) {
        this.filename = fname;
    }

    /**
     * Accessor for fileName
     * @return filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Mutator for fileName
     * @param filename = name of file
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }


    /**
     * THis method check if the input is in “stop words” or not
     * @param word input word
     * @return true if word is in stopwords
     */
    public boolean isStopword(String word) {
       for(String s: stopwords){
           if (s.equalsIgnoreCase(word)){
               return true;
           }
       }
       return false;
    }

    /**
     * This method check if the input word is a “junk” word.
     * Assume a word is junk if it contains anything except a letter.
     * @return true if character is not letter
     */
    public boolean isJunk(String word) {
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            if (!Character.isLetter(c)){
                return true;
            }
        }
        return false;
    }

    /**
     * This method removes trailing punctuation.
     * Assume that there is at most one punctuation character at the end of the word
     * @param w input word
     * @return wordStripped
     */
    public String stripPunctuation (String w) {
        String wordStripped = "";
        int i = w.length()-1;
        if(!Character.isLetter(w.charAt(i))) {
            wordStripped = w.substring(0, i);
        }
        return wordStripped;
    }

    /**
     * parseFile should take a filename as input, open the file, read in each token, convert to lower case,
     * check to see if it's in the stopword list, check to see if it's junk, and strip off trailing punctuation.
     * Return an ArrayList of Strings representing all words that meet these criteria. processed accordingly
     * @return lowerCaseWords
     */
    public ArrayList<String> parseFile() {
        ArrayList<String> lowerCaseWords = new ArrayList<>();
        try{
            Scanner s = new Scanner(new File(filename));
            while(s.hasNextLine()){
                String line = s.nextLine();
                //TODO: check line split
                String[] words = line.split(" ");
                for (String w: words){
                    String parseWord = w.toLowerCase();
                    parseWord = stripPunctuation(parseWord);
                    if(isStopword(parseWord) || isJunk(parseWord)){
                        continue;
                    }
                    parseWord = stripPunctuation(parseWord);
                    lowerCaseWords.add(parseWord);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lowerCaseWords;
    }
}
