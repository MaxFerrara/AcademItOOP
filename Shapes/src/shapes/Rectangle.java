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
        return "shapes.Rectangle width/height/area: " + rectangleWidth + "/" + rectangleHeight + "/" + getArea();
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
        return (int) (rectangleHeight * rectangleWidth * getArea());
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
