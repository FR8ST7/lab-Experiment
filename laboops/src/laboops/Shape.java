package laboops;

abstract class Shape {
    String color;
    int sides;

    Shape(String color, int sides) {
        this.color = color;
        this.sides = sides;
    }

    abstract double calcArea();

    void display() {
        System.out.println("Color: " + color);
        System.out.println("Number of Sides: " + sides);
    }
}
