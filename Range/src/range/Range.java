package range;

public final class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        if (to < from) {
            throw new IllegalArgumentException("поле to должно быть больше чем from");
        }

        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return this.from + " " + this.to;
    }

    public final double getLength() {
        return to - from;
    }

    public final Range getRangesIntersection(Range range) {
        if (range.to >= from && range.from <= to) {
            return new Range(Math.max(from, range.from), Math.min(to, range.to));
        }

        return null;
    }

    public final Range[] getRangesUnion(Range range) {
        if (range.to >= from && range.from <= to) {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
        }

        return new Range[]{new Range(from, to), new Range(range.from, range.to)};
    }

    public final Range[] getRangesDifference(Range range) {
        if (from <= range.from && to <= range.to) {
            return new Range[]{new Range(from, range.from)};
        }

        if (from >= range.from && to >= range.to) {
            return new Range[]{new Range(range.to, to)};
        }

        if (range.from <= from && range.to >= to) {
            return new Range[]{new Range(range.from, from), new Range(to, range.to)};
        }

        if (range.from >= from && range.to <= to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        }

        return null;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }
}
