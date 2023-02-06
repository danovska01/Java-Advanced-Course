package _06_SetsAndMapsAdvanced_Ex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _07_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, String> emailsLog = new LinkedHashMap<>();
        String regex1 = "[\\w]{1,}[.]?[\\w]{1,}@[\\w]{1,}.[c][o][m]";
        String regex2 = "[\\w]{1,}[.]?[\\w]{1,}@[\\w]{1,}.[u][k]";
        String regex3 = "[\\w]{1,}[.]?[\\w]{1,}@[\\w]{1,}.[u][s]";

        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        Pattern pattern3 = Pattern.compile(regex3);


        while (!input.equals("stop")){
            String name = input;
            String email= scanner.nextLine();
            Matcher matcher1 = pattern1.matcher(email);
            Matcher matcher2 = pattern2.matcher(email);
            Matcher matcher3 = pattern3.matcher(email);
            if(matcher1.find() || matcher2.find() || matcher3.find()){
                input=scanner.nextLine();
                continue;
            }


            emailsLog.put(name, email);
            input=scanner.nextLine();
        }


        for(Map.Entry<String, String>entry:emailsLog.entrySet()){
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
