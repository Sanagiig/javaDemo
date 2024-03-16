package org.example.mem;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EnhancedMap {
    public static Map<String, String> map;

    static {
        EnhancedMap.map = Collections.synchronizedMap(new HashMap<>());
    }

    public EnhancedMap(Map<String, String> map) {

    }

    public static String putIfAbsent(String key, String value) {
        String old = map.get(key);
        if (old != null) {
            return old;
        }
        return put(key, value);
    }

    public static String put(String key, String value) {
        return EnhancedMap.map.put(key, value);
    }
    //…
}