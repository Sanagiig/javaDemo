package org.example.thread;

import org.example.mem.ShareMemory;

public class HelloRunnable implements Runnable{
    @Override
    public void run() {
        int count = 1000;
        while(count -- > 0){
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            ShareMemory.inc();
        }
        System.out.println("hello runnable");
    }
}
