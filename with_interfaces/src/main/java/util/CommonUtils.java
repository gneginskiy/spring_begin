package util;// Created by Neginskiy Gregoriy.

public class CommonUtils {
    public static void sleep(int countSeconds) {
        try {
            Thread.sleep(countSeconds*countSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
