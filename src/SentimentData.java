import java.util.ArrayList;

public class SentimentData {
    private ArrayList<String> words;
    private ArrayList<Double> wordValues;

    public SentimentData(String file) {
        words = new ArrayList<>();
        wordValues = new ArrayList<>();

        // parsing words and wordValues from the file
        ArrayList<String> sentiments = FileReader.toStringList(file);

        for (int i = 0; i < sentiments.size(); i++) {
            String theLine = sentiments.get(i);
            int comma = theLine.indexOf(",");
            String theWord = theLine.substring(0, comma);
            String theSentimentValue = theLine.substring(comma + 1);
            double theDoubledSentimentValue = Double.parseDouble(theSentimentValue);
            words.add(theWord);
            wordValues.add(theDoubledSentimentValue);
        }


    }

    public SentimentData(ArrayList<String> words, ArrayList<Double> values) {
        this.words = words;
        this.wordValues = values;

    }

    public Double getWordValue(String word) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equalsIgnoreCase(word)) {
                return wordValues.get(i);
            }
        }
        return null; 
        
    }

    public boolean containsWord(String theWord) {
        return words.contains(theWord);
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public ArrayList<Double> getWordValues() {
        return wordValues;
    }
    
    public int size() {
        return words.size();
    }

    public int size2() {
        return wordValues.size();
    }




}
