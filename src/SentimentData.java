import java.util.ArrayList;

public class SentimentData {
    // I cleaned it up a lil for you
    // Thanks
    private ArrayList<String> words;
    private ArrayList<Double> wordValues;

    public SentimentData(String file) {
        words = new ArrayList<>();
        wordValues = new ArrayList<>();
    }

    public SentimentData(ArrayList<String> words, ArrayList<Double> values) {
        this.words = words;
        this.wordValues = values;

    }

    public Double getWordValue(String word) {
        if (words.indexOf(word) != 1) {
            return wordValues.get(index);
        }
        else {
            return null;
        }
    }

    public boolean containsWord(String theWord) {
        return words.contains(theWord);
    }

    public ArrayList<String> getWords() {
        return ArrayList<>(words);
    }

    public ArrayList<Double> getWordValues() {
        return ArrayList<>(wordValues);
    }
    
    public int size() {
        return words.size();
    }

    public int size2() {
        return wordValues.size();
    }




}
