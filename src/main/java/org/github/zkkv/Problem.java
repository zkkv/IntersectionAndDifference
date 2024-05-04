package org.github.zkkv;

import java.util.Objects;
import java.util.Set;

final public class Problem {
    String hash;
    Set<String> data;

    public Problem(String hash, Set<String> data) {
        this.hash = hash;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || this.getClass() != o.getClass()) return false;

        Problem other = (Problem)o;

        return this.hash.equals(other.hash) && this.data.equals(other.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash, data);
    }
}
