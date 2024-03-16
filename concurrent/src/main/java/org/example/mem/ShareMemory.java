package org.example.mem;

public class ShareMemory {
    private static int shared = 0;
    public synchronized static void inc(){
        shared++;
        dec();
    }

    public synchronized static  void dec(){
        shared--;
    }

    public static int getShared(){
        return shared;
    }
}
