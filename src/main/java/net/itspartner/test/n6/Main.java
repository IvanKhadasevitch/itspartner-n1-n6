package net.itspartner.test.n6;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Task: Process file resources/n6/source in a special way and write result to the new file.
 * Source file contains data in following format:
 * username,password,email
 *
 * You need to:
 * 1) remove duplicates by username
 * 2) make email lowercase
 * 3) remove records where password doesn't meet following conditions:
 * 3.1) password length must be at least 8 symbols
 * 3.2) password must contain at least one special character (#, @, -)
 * 3.3) password must contain exactly one uppercase character
 *
 * All the rest records should be saved in new file in the same format.
 */
public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {

        URL resource = Main.class.getResource("/n6/source");
        File sourceFile = Paths.get(resource.toURI()).toFile();

        URL result = Main.class.getResource("/n6");
        String resultFilePath = Paths.get(result.toURI()).toFile().toString() + "\\result";

        writeResultFile(parseSourceFile(sourceFile), resultFilePath);

    }

    public static boolean isOneSpecialCharacter(String inString) {
        Pattern pattern = Pattern.compile("[#@-]");
        Matcher matcher = pattern.matcher(inString);
        boolean result = matcher.find();
        return result;
    }

    public static boolean isOneUpperCaseCharacter(String inString) {
        Pattern pattern = Pattern.compile("[A-ZА-Я]");
        Matcher matcher = pattern.matcher(inString);
        boolean result = matcher.find();
        return result;
    }

    public static HashMap<String,PasswordEmail> parseSourceFile(File sourceFile) throws IOException {
        HashMap<String,PasswordEmail> result = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(sourceFile));

        String stringFromFile;
        while ((stringFromFile = br.readLine())!= null) {
            String[] userPasswordEmail = stringFromFile.split(",");
            if (userPasswordEmail[1] != null && userPasswordEmail[1].length() >= 8 &&
                    isOneSpecialCharacter(userPasswordEmail[1]) &&
                    isOneUpperCaseCharacter(userPasswordEmail[1])) {
                if (userPasswordEmail[0] != null && !result.containsKey(userPasswordEmail[0])) {
                    result.put(userPasswordEmail[0],
                            new PasswordEmail(userPasswordEmail[1], userPasswordEmail[2].toLowerCase()));
                }
            }
        }
        br.close();

        return result;
    }

    public static void writeResultFile(HashMap<String,PasswordEmail> result, String outFilePath)
            throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(outFilePath));
        String lineSeparator = System.getProperty("line.separator");
        for (Map.Entry<String,PasswordEmail> entry : result.entrySet()) {
            String line = entry.getKey()
                               .concat(",")
                               .concat(entry.getValue().getPassword())
                               .concat(",")
                               .concat(entry.getValue().getEmail())
                               .concat(lineSeparator);
            bw.write(line);
        }
        bw.flush();
        bw.close();
    }
}
