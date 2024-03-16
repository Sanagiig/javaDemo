package org.example;

import org.example.mem.EnhancedList;
import org.example.mem.EnhancedMap;
import org.example.mem.ShareMemory;
import org.example.thread.HelloRunnable;
import org.example.thread.HelloThread;
import org.example.thread.MapThread;

public class Main {
    private volatile static boolean shutdown = false;

    static class HelloThread2 extends Thread {
        @Override
        public void run() {
            while (!shutdown) {
                // do nothing
            }
            System.out.println("exit hello");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        test2();
    }

    public static void test0() throws InterruptedException {
        Thread thread = new HelloThread2();
        thread.start();
        Thread.sleep(1000);
        shutdown = true;
        thread.join();
        System.out.println("exitmain");
    }

    public static void test() throws InterruptedException {
        Thread thread = new HelloThread();
        Thread thread1 = new Thread(new HelloRunnable());

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println(ShareMemory.getShared());
        System.out.println("exitmain");
    }

    public static void test1() throws InterruptedException {
        Thread thread = new MapThread(1);
        Thread thread1 = new MapThread(2);

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        EnhancedMap.put("1 test0", "1");
        EnhancedMap.put("2 test0", "2");

        System.out.println("exitmain " + EnhancedMap.map);
    }

    public static void test2() throws InterruptedException {
        Thread modifyThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                EnhancedList.list.add(String.valueOf(i));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread iteratorThread = new Thread(() -> {
            System.out.println("start");
            while (true) {
                synchronized (EnhancedList.list) {
                    for (String str : EnhancedList.list) {
                        System.out.println("list item: " + str);
                    }
                }
            }
        });

        modifyThread.start();
        iteratorThread.start();

        modifyThread.join();
        iteratorThread.join();
        System.out.println("exit-main");
    }
}