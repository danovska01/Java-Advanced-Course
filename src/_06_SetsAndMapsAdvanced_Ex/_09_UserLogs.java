package _06_SetsAndMapsAdvanced_Ex;

import java.util.*;

public class _09_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split(" ");


        Map<String, Map<String, Integer>> userLog = new TreeMap<>();

        while (!input[0].equals("end")){
            String IP = input[0].substring(3, input[0].length());
            //String message = input[1].substring(9, input[1].length()-1);
            String user = input[2].substring(5, input[2].length());

            if(!userLog.containsKey(user)){
                Map<String, Integer> ips= new LinkedHashMap<>();
                ips.put(IP, 1);
                userLog.put(user, ips);
            }
            else {
                Map<String, Integer> ips = userLog.get(user);
                if(!ips.containsKey(IP)){
                    ips.put(IP, 1);
                    userLog.put(user, ips);
                }
                else {
                    int index= ips.get(IP);
                    index++;
                    ips.put(IP, index);
                    userLog.put(user, ips);


                }
            }

            input=scanner.nextLine().split(" ");
        }
        for (Map.Entry<String, Map<String, Integer>> user: userLog.entrySet()) {
            List<String> ipRow = new ArrayList<>();
            System.out.printf("%s:%n", user.getKey());
            for (Map.Entry<String, Integer> entry : user.getValue().entrySet()) {
                ipRow.add(entry.getKey() + " => " + entry.getValue());
            }
            System.out.print(String.join(", ", ipRow));
            if (ipRow.size() > 0)
            {
                System.out.println(".");
            }
        }


    }
}
