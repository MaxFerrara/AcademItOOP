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

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        if (to < from) {
            throw new IllegalArgumentException("поле to должно быть больше чем from");
        }

        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        if (to < from) {
            throw new IllegalArgumentException("поле to должно быть больше чем from");
        }

        this.to = to;
    }

    @Override
    public String toString() {
        return "(" + this.from + ";" + this.to + ")";
    }

    public double getLength() {
        return to - from;
    }

    public Range getIntersection(Range range) {
        if (range.to >= from && range.from <= to) {
            return new Range(Math.max(from, range.from), Math.min(to, range.to));
        }

        return null;
    }

    public Range[] getUnion(Range range) {
        if (range.to >= from && range.from <= to) {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
        }

        return new Range[]{new Range(from, to), new Range(range.from, range.to)};
    }

    public Range[] getDifference(Range range) {
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
}
