package net.itspartner.test.n2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    /**
     * Description: Application extracts specified query parameter from URL
     * For example: http://itspartner.net/api?user=pavel&age=50
     * Task: Find a bug and fix it. Code should work for any parameter at any position.
     * Implement unit tests (JUnit) to show correctness of the solution.
     */
    public static void main(String[] args) {

        QueryExtractor queryExtractor = new QueryExtractor();
        System.out.println(queryExtractor.extract("http://itspartner.net/api?user=pavel&age=50", "user"));
        System.out.println(queryExtractor.extract("http://itspartner.net/api?user=pavel&age=50", "age"));

        System.out.println(queryExtractor.extract("http://itspartner.net/api?user=pavel&age=50&height=190", "age"));
    }
}

@SuppressWarnings("all")
class QueryExtractor {

    public String extract(String url, String paramName) {

//        Pattern pattern = Pattern.compile("?" + paramName + "=(.*)&");  // source
//        Pattern pattern = Pattern.compile("[\\?&]" + paramName + "=([^&]*)&"); // it is was
        Pattern pattern = Pattern.compile("[\\?&]" + paramName + "=([^\\&]*)&?");  // new desision

        Matcher matcher = pattern.matcher(url);         // source
//        Matcher matcher = pattern.matcher(url + "&");  // it is was
        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }
}
