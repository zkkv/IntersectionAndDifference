package org.github.zkkv;

import java.util.HashSet;
import java.util.Set;

public class UnionOperations<T> {

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> c = new HashSet<>(a);
        c.retainAll(b);
        return c;
    }

    public static <T> Set<T> difference(Set<T> a, Set<T> b) {
        Set<T> c = new HashSet<>(a);
        c.removeAll(b);
        return c;
    }
}
