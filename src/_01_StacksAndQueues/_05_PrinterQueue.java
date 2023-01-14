package _01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        ArrayDeque<String>printerQueue = new ArrayDeque<>();
        while (!command.equals("print")){
            if(command.equals("cancel")){
                if(printerQueue.isEmpty()){
                    System.out.println("Printer is on standby");
                }
                else {
                    String currentCommand= printerQueue.poll();
                    System.out.println("Canceled " + currentCommand);

                }

            }
            else {
                printerQueue.offer(command);
            }

            command=scanner.nextLine();
        }
        for(String thisCommand: printerQueue){
            System.out.println(thisCommand);
        }
    }
}
