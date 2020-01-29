package shapes;

public final class Rectangle implements Shape {
    private double rectangleWidth;
    private double rectangleHeight;

    public Rectangle(double rectangleHeight, double rectangleWidth) {
        this.rectangleHeight = rectangleHeight;
        this.rectangleWidth = rectangleWidth;
    }

    @Override
    public double getWidth() {
        return rectangleWidth;
    }

    @Override
    public double getHeight() {
        return rectangleHeight;
    }

    @Override
    public double getArea() {
        return rectangleWidth * rectangleHeight;
    }

    @Override
    public double getPerimeter() {
        return (rectangleWidth * rectangleHeight) * 2;
    }

    @Override
    public String toString() {
        return String.format("Rectangle width: %s, height: %s", rectangleWidth, rectangleHeight);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) obj;
        return rectangleWidth == rectangle.rectangleWidth && rectangleHeight == rectangle.rectangleHeight;
    }

    @Override
    public int hashCode() {
        final int prime = 45;
        int hash = 1;
        hash *= prime + Double.hashCode(rectangleHeight);
        hash *= prime + Double.hashCode(rectangleWidth);
        return Math.abs(hash);
    }

    public double getRectangleWidth() {
        return rectangleWidth;
    }

    public void setRectangleWidth(double rectangleWidth) {
        this.rectangleWidth = rectangleWidth;
    }

    public double getRectangleHeight() {
        return rectangleHeight;
    }

    public void setRectangleHeight(double rectangleHeight) {
        this.rectangleHeight = rectangleHeight;
    }
}
