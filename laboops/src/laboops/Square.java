package laboops;

class Square extends Shape {
    double sideLength;

    Square(String color, double sideLength) {
        super(color, 4); // Square has 4 sides
        this.sideLength = sideLength;
    }

    @Override
    double calcArea() {
        return sideLength * sideLength;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Side Length: " + sideLength);
        System.out.println("Area: " + calcArea());
    }
}
