package _01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //2 types of browser instructions:
        //    • Normal navigation: a URL is set, given by a string;
        //    • The string "back" that sets the current URL to the last set URL

        String input = scanner.nextLine();

        ArrayDeque<String> stackURLs = new ArrayDeque<>();
        ArrayDeque <String> forwardsQueue = new ArrayDeque<>();

        while (!input.equals("Home")){
            if (input.equals("back")){
                if (stackURLs.size() < 2){
                    System.out.println("no previous URLs");
                }
                else {
                    String currentURL = stackURLs.pop();
                    forwardsQueue.push(currentURL);
                    System.out.println(stackURLs.peek());
                }
            }
          /*  else if (input.equals("forward")){
                if (forwardsQueue.isEmpty()){
                    System.out.println("no next URLs");
                }
                else {
                    String currentForward = forwardsQueue.pop();
                    System.out.println(currentForward);
                    stackURLs.push(currentForward);
                }
            }*/
            else {
                stackURLs.push(input);
                System.out.println(input);
                forwardsQueue.clear();
            }
            input = scanner.nextLine();
        }


    }
}
