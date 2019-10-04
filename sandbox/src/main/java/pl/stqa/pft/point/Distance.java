package pl.stqa.pft.point;

public class Distance {

    public static void main(String[] args) {

        Point p1 = new Point(1, 9);
        Point p2 = new Point(7, 1);

        System.out.println("This is the distance between two points: " + p1.distance(p1, p2));

    }

}
