package net.mshome.twisted.algorithm.huawei.online;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 调整多边形坐标
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2020/12/5
 */
public class AdjustPolygonCoordinate {

    @Getter
    static class Edge {

        private final Point from;
        private final Point to;

        private Edge(Point from, Point to) {
            this.from = from;
            this.to = to;
        }

    }

    @Getter
    static class Point {

        private final double x;
        private final double y;

        private Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public static Point of(double x, double y) {
            return new Point(x, y);
        }

    }

    private static final double radius = 2;
    private static final List<Point> POINTS = new ArrayList<>();
    private static final double space = 5;

    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                POINTS.add(Point.of(i * 5, j * 5));
            }
        }
    }

    private static final Point[] POLYGON_POINTS = {Point.of(6, 6), Point.of(6, 25), Point.of(25, 17), Point.of(6, 17)};


    public static void adjust() {
        for (Point point : POLYGON_POINTS) {

        }

        Point[][] pointsArr = new Point[20][20];


    }


}
