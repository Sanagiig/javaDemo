package org.example.thread;

import org.example.mem.ShareMemory;

public class HelloThread extends Thread{
    @Override
    public void run(){
        int count = 1000;
        while(count -- > 0){
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            ShareMemory.dec();
        }

        System.out.println("Hello from a thread");
    }
}
