package pl.stqa.pft.point;

public class Point {

    public double x;
    public double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double distance(Point p2) {

        double dis_x = (this.x - p2.x) * (this.x - p2.x);
        double dis_y = (this.y - p2.y) * (this.y - p2.y);
        double dis = Math.sqrt(dis_x+dis_y);

        return dis;
    }

}
