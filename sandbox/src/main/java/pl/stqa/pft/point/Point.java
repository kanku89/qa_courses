package pl.stqa.pft.point;

public class Point {

    public double x;
    public double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double distance(Point p1, Point p2) {

        double dis_x = (p1.x - p2.x) * (p1.x - p2.x);
        double dis_y = (p1.y - p2.y) * (p1.y - p2.y);
        double dis = Math.sqrt(dis_x+dis_y);

        return dis;
    }

}
