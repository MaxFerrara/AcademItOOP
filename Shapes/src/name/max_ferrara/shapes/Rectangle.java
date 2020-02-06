package name.max_ferrara.shapes;

public final class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getRectangleWidth() {
        return width;
    }

    public void setRectangleWidth(double rectangleWidth) {
        this.width = rectangleWidth;
    }

    public double getRectangleHeight() {
        return height;
    }

    public void setRectangleHeight(double rectangleHeight) {
        this.height = rectangleHeight;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public String toString() {
        return String.format("Rectangle width: %s, height: %s", width, height);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) obj;
        return width == rectangle.width && height == rectangle.height;
    }

    @Override
    public int hashCode() {
        final int prime = 45;
        int hash = 1;
        hash *= prime + Double.hashCode(height);
        hash *= prime + Double.hashCode(width);
        return hash;
    }
}
