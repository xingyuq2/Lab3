import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
/**
 * Retrieve contents from a URL and return them as a string.
 *
 * @param url url to retrieve contents from
 * @return the contents from the url as a string, or an empty string on error
 */
public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
        urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
        return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
        }

        public static void main(String[] unused) {
    String[] input = urlToString("http://erdani.com/tdpl/hamlet.txt").split(" ");
    System.out.println("Total word count is:" + input.length);

    int count = 0;
    Scanner lineScanner = new Scanner(System.in);
    System.out.println("Enter the word: ");
    String word = lineScanner.nextLine();
    for (int i = 0; i < input.length; i++) {
        if (input[i].toLowerCase().equals(word.toLowerCase())) {
            count++;
        }
    }
    System.out.println("The count for the input is:" +  count);

    int sum = input.length;
    for (int i = 0; i < input.length ; i++) {
        for (int j = 0; j < i; j++) {
            if (input[i].toLowerCase().equals(input[j].toLowerCase())) {
                sum--;
                break;
            }
        }
    }
    System.out.println("The count for unique word is:" +  sum);
}
}
