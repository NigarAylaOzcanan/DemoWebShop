package Utility;

public class MyFunc {
    public static void wait(int sn){

        try {
            Thread.sleep(sn*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}