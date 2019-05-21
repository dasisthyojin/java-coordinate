package coordinatecalculator.domain;

import java.util.List;
import java.util.Objects;

public class Points {
    //TODO: 포인트 중복 예외 처리
    private final List<Point> points;

    public Points(final List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points1 = (Points) o;
        return Objects.equals(points, points1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}