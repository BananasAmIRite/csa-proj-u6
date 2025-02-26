import java.util.ArrayList;

public class SentimentAnalysisRunner {
    public static void main(String[] args) {
        String folder = "C:\\Users\\jason\\Desktop\\csa-project-u6\\n" + //
        "lp\\"; 
        SentimentAnalyzer analyzer = new SentimentAnalyzer(folder + "stopwords.txt"); 

        ArrayList<String> song1 = FileReader.toStringList(folder + "song.txt"); 
        System.out.println("Song Analysis for Song 1 (Champions)"); 
        System.out.println(analyzer.calculateTotalSentiment(song1)); 

        ArrayList<String> song2 = FileReader.toStringList(folder + "song2.txt"); 
        System.out.println("Song Analysis for Song 2 (The Taylor Swift One)"); 
        System.out.println(analyzer.calculateTotalSentiment(song2)); 
    }
}
