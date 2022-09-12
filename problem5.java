import java.nio.*;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;
import java.net.Socket;

class MyThread extends Thread {

    MyThread(String name) {

        super(name);
    }

    public void readAndSort(Integer intArr[], int startIndex, int endIndex, int size, FileWriter sortedIntWriter) {

        int[] threadArr = new int[size / 3];
        int i = 0;
        int j = startIndex;
        for (i = 0, j = startIndex; j < endIndex; i++, j++) {

            threadArr[i] = intArr[j];
        }

        Arrays.sort(threadArr);
        System.out.println("Sorted: " + Arrays.toString(threadArr));

        if (super.getName() == "t4") {

            try {

                sortedIntWriter.write(Arrays.toString(threadArr));
                sortedIntWriter.flush();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
}

public class question5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        File intFile = new File("Integers");
        File sortedInt = new File("SortedIntegers");
        System.out.println("Enter total number of integers");
        int n = sc.nextInt();

        try {

            intFile.createNewFile();
            sortedInt.createNewFile();

        } catch (IOException e) {

            System.out.println("IOException while creating file");
        }

        System.out.print("Enter " + n + " integers:");
        int i = 0;
        Integer[] intArr = new Integer[n];
        try {

            FileWriter intWriter = new FileWriter(intFile);
            for (i = 0; i < n; i++) {

                intArr[i] = sc.nextInt();
                intWriter.write(Integer.toString(intArr[i]) + "\n");
                intWriter.flush();
            }
            System.out.println(Arrays.toString(intArr));

        } catch (IOException e) {

            e.printStackTrace();
        }

        MyThread t1 = new MyThread("t1");
        try {

            FileWriter sortedIntWriter = new FileWriter(sortedInt);
            t1.start();
            t1.readAndSort(intArr, 0, n / 3, n, sortedIntWriter);
            t1.join();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        MyThread t2 = new MyThread("t2");

        try {

            FileWriter sortedIntWriter = new FileWriter(sortedInt);
            t2.start();
            t2.readAndSort(intArr, n / 3, 2 * n / 3, n, sortedIntWriter);
            t2.join();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        MyThread t3 = new MyThread("t3");

        try {

            FileWriter sortedIntWriter = new FileWriter(sortedInt);
            t3.start();
            t3.readAndSort(intArr, 2 * n / 3, n, n, sortedIntWriter);
            t3.join();

        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        MyThread t4 = new MyThread("t4");
        try {

            FileWriter sortedIntWriter = new FileWriter(sortedInt);
            t4.start();
            t4.readAndSort(intArr, 0, n, 3 * n, sortedIntWriter);
            t4.join();

        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
