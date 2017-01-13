package com.test.lang;

import java.util.*;

/**
 * Created by zhaogang3 on 2016/9/5.
 */
public class MyMap<k, v> extends AbstractMap {

    private transient Set<Map.Entry<k, v>> entrySet = new AbstractSet<Entry<k, v>>() {
        @Override
        public Iterator<Entry<k, v>> iterator() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    };

    public MyMap(Set<Entry<k, v>> entrySet) {
        this.entrySet = entrySet;
    }

    public Set<Entry<k, v>> entrySet() {
        return entrySet;
    }

}
