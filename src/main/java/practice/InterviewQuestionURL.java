package practice;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class InterviewQuestionURL {
    /*
    for this question, you are given a log file from a simple web server . each line in the log file
    contains a URL and nothing else. your job is to write code that will fetch / download the log file from the internet
    process it, and output the most popular URL in the file. you do not need to normalize the URLs
    in the log files.

    use the following sample log files:

    logfile1 = "https://public.karat.io/content/urls2.txt"  -> the most common URL is
    http://www.example.com (with 1170 occurrences)
    logfile2 = "https://public.karat.io/content/q015/single_url.txt" -> the result is
    http://www.example.com (1 occurrence)
     */
    public static void main(String[] args) {
        String logfile1 = "https://public.karat.io/content/urls2.txt";
        String logfile2 = "https://public.karat.io/content/q015/single_url.txt";

        try {
            URLResult result1 = findMostPopularURL(logfile1);
            System.out.println("Most popular URL in logfile1: " + result1.url + " (" + result1.count + " occurrences)");

            URLResult result2 = findMostPopularURL(logfile2);
            System.out.println("Most popular URL in logfile2: " + result2.url + " (" + result2.count + " occurrence" +
                    (result2.count > 1 ? "s" : "") + ")");
        } catch (IOException e) {
            System.err.println("Error processing log files: " + e.getMessage());
        }
    }

    public static URLResult findMostPopularURL(String logFileUrl) throws IOException {
        Map<String, Integer> urlCountMap = new HashMap<>();

        // Open the URL stream
        URL url = new URL(logFileUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        // Read the lines from the log file
        String line;
        while ((line = reader.readLine()) != null) {
            urlCountMap.put(line, urlCountMap.getOrDefault(line, 0) + 1);
        }
        reader.close();

        // Find the most popular URL
        String mostPopularUrl = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : urlCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopularUrl = entry.getKey();
            }
        }

        return new URLResult(mostPopularUrl, maxCount);
    }

    static class URLResult {
        String url;
        int count;

        URLResult(String url, int count) {
            this.url = url;
            this.count = count;
        }
    }
}