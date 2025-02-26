import java.util.ArrayList;

public class SentimentAnalyzer {
    // list of words that are not included in sentiment analysis, since they are common and have no inherent sentiment meaning
    private ArrayList<String> stopWords; 
    
    // SentimentData objects corresponding to the word dictionary of each emotion
    private SentimentData positivityData; 
    private SentimentData pleasentnessData; 
    private SentimentData excitementData; 

    public SentimentAnalyzer(String stopWordsFile) {
        this.stopWords = parseStopWords(stopWordsFile); 

        String folder = "C:\\Users\\jason\\Desktop\\csa-project-u6\\n" + //
        "lp\\"; 

        this.positivityData = new SentimentData(folder + "words_positivity.txt"); 
        this.excitementData = new SentimentData(folder + "words_excitedness.txt"); 
        this.pleasentnessData = new SentimentData(folder + "words_pleasantness.txt"); 
    }

    private ArrayList<String> parseStopWords(String file) {
        ArrayList<String> stopWords = FileReader.toStringList(file); 

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

    public SentimentAnalysisResult calculateTotalSentiment(ArrayList<String> textList) {
        String totalText = "";
        for (String line : textList) {
            totalText += line + " "; 
        }
        return calculateTotalSentiment(totalText); 
    }
}
