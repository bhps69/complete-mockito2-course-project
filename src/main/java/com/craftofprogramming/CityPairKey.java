package com.craftofprogramming;

import java.util.Objects;

public class CityPairKey {
    final String from;
    final String to;

    private CityPairKey(String from, String to) {
        this.from = from;
        this.to = to;
    }

    static CityPairKey valueOf(String from, String to) {
        return new CityPairKey(from, to);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CityPairKey that = (CityPairKey) o;
        return from.equals(that.from) &&
                to.equals(that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public String toString() {
        return String.format("%s->%s", from, to);
    }
}
