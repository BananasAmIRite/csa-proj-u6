public class SentimentAnalysisResult {
    private double positivity; 
    private double pleasentness; 
    private double excitement; 
    
    public SentimentAnalysisResult(double positivity, double pleasentness, double excitement) {
        this.positivity = positivity; 
        this.pleasentness = pleasentness; 
        this.excitement = excitement; 
    }

    public double getPositivity() {
        return positivity; 
    }

    public double getPleasantness() {
        return pleasentness; 
    }

    public double getExcitement() {
        return excitement; 
    }

    public String toString() {
        return "Sentiment Analysis: \n" + "----------------------\n" + 
        "Positivity: " + String.format("%.3f", positivity) + "\n" +  
        "Pleasantness: " + String.format("%.3f", pleasentness) + "\n" + 
        "Excitement: " +  String.format("%.3f", excitement);
    }
}
