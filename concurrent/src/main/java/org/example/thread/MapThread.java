package org.example.thread;

import org.example.mem.EnhancedMap;

import java.util.HashMap;
import java.util.Map;

public class MapThread extends Thread {
    private int id;


    public MapThread(int id){
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            EnhancedMap.putIfAbsent(id +" test" + i, "test");
        }
//        try {
//
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
