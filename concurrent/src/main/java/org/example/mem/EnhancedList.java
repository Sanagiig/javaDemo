package org.example.mem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnhancedList {
    static public List<String> list;

    static {
        list = Collections.synchronizedList(new ArrayList<String>());
    }
}
