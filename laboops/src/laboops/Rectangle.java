package laboops;

class Rectangle extends Shape {
    double length;
    double width;

    Rectangle(String color, double length, double width) {
        super(color, 4); // Rectangle has 4 sides
        this.length = length;
        this.width = width;
    }

    @Override
    double calcArea() {
        return length * width;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Area: " + calcArea());
    }
}
