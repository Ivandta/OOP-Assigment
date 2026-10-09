package Inheritance_and_polymorphism;
public class Lingkaran extends Bentuk {
    private double radius;

    public Lingkaran(double radius, String warna) {
        super(warna);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double hitungLuas() {
        return Math.PI * radius * radius;
    }

    @Override
    public void printInfo() {
        System.out.println(
            "Lingkaran berwarna " + warna +
            ", luas = " + hitungLuas()
        );
    }
}