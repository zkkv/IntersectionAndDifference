package org.github.zkkv;

import java.util.Set;

final public class Problem {
    String hash;
    Set<String> data;

    public Problem(String hash, Set<String> data) {
        this.hash = hash;
        this.data = data;
    }
}
