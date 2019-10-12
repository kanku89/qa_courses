package pl.stqa.pft.point;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistance1() {
        Point p1 = new Point(1, 9);
        Point p2 = new Point(7, 1);
        Assert.assertEquals(p1.distance(p2), 10);
    }

    @Test
    public void testDistance2() {
        Point p1 = new Point(16, 42);
        Point p2 = new Point(4, 33);
        Assert.assertEquals(p1.distance(p2), 15);
    }

    @Test
    public void testDistance3() {
        Point p1 = new Point(13, 24);
        Point p2 = new Point(8,12);
        Assert.assertEquals(p1.distance(p2), 13);
    }
}
