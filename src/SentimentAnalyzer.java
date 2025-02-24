import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class SentimentAnalyzer {
    private ArrayList<String> stopWords; 
    private SentimentData positivityData; 
    private SentimentData pleasentnessData; 
    private SentimentData excitementData; 

    public SentimentAnalyzer(String stopWordsFile) {
        this.stopWords = parseStopWords(stopWordsFile); 

        this.positivityData = new SentimentData("words_positivity.txt"); 
        this.excitementData = new SentimentData("words_excitedness.txt"); 
        this.pleasentnessData = new SentimentData("words_pleasantness.txt"); 
    }

    private ArrayList<String> parseStopWords(String file) {
        // TODO: use FileReader#toStringList (apparently it's not a built-in java method :P)
        List<String> stopWords = new ArrayList<>(); 
        try {
            stopWords = Files.readAllLines(new File(file).toPath());
        } catch (IOException e) {}

        // lowercase all stop words
        ArrayList<String> lowercaseStopWords = new ArrayList<>(); 
        for (String word : stopWords) lowercaseStopWords.add(word.toLowerCase()); 
        return lowercaseStopWords; 
    }

    private double calculateSentiment(String text, SentimentData data) {
        // parse text into individual words
        String[] words = text.split(" "); 

        // move data into ArrayList to allow for easy removal of items
        ArrayList<String> wordsList = new ArrayList<>(); 
        for (String word : words) {
            wordsList.add(word); 
        }

        // prune stop words from the words list
        for (int i = 0; i < wordsList.size(); i++) {
            if (stopWords.contains(wordsList.get(i))) {
                wordsList.remove(i); 
                i--; 
            }
        }

        // calculate total word score for the specific sentiment and how many words were factored in
        double score = 0; 
        int wordCount = 0; 

        for (String word : words) {
            Double wordScore = data.getWordValue(word);
            if (wordScore != null) {
                wordCount++; 
                score += wordScore;
            } 
        }

        // return word average score
        return score / wordCount; 
    }

    public SentimentAnalysisResult calculateTotalSentiment(String text) {
        return new SentimentAnalysisResult(
            calculateSentiment(text, positivityData), 
            calculateSentiment(text, pleasentnessData), 
            calculateSentiment(text, excitementData)
        ); 
    }
}
