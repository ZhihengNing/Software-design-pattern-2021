package exceptionhandle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandle {
    /**
     * 异常处理
     */
    public static int exception(){

        int s=-1;
        while(s==-1) {
            try {
                Scanner scan = new Scanner(System.in);
                s = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Exception thrown  :" + e);
                System.out.println("输入错误，应输入数字！！");
                s=-1;
            }
        }
        return s;
    }
}


