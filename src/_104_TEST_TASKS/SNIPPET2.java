package _104_TEST_TASKS;

public class SNIPPET2 {
    //How many times will the following loop iterate? - endless!!!!

    public static void main(String[] args) {
        int balance = 10;
        while (balance>=1){
         if(balance<9){
             continue;
         }
         balance=balance-9;
        }
    }
}
