package _10_FunctionalProgramming_Ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class _11_ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        //TPRF Commands are in the given format "{command;filter type;filter parameter}".

        BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));

        String[] names = bfReader.readLine().split(" ");

        String line;

        Map<String, Predicate<String>> predicates = new HashMap<>();

        while (!"Print".equals(line = bfReader.readLine())) {
            String[] tokens = line.substring(line.indexOf(";") + 1).split(";");
            String name = tokens[0] + tokens[1];

            if (line.contains("Add")) {
                Predicate<String> predicate = null;
                switch (tokens[0]) {
                    case "Starts with":
                        predicate = str -> str.startsWith(tokens[1]);
                        break;
                    case "Ends with":
                        predicate = str -> str.endsWith(tokens[1]);
                        break;
                    case "Length":
                        predicate = str -> str.length() == Integer.parseInt(tokens[1]);
                        break;
                    case "Contains":
                        predicate = str -> str.contains(tokens[1]);
                        break;
                }
                predicates.putIfAbsent(name, predicate);

            } else {
                predicates.remove(name);
            }
        }
        for (String name : names) {
            boolean isValid = true;
            for (String predicateName : predicates.keySet()) {
                if (predicates.get(predicateName).test(name)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                System.out.print(name + " ");
            }
        }
    }
}
