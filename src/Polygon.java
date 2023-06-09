import java.util.Locale;

public class Polygon implements Shape {
    Vec2 points[];
    public Polygon(Vec2[] points) {
        this.points = points;
    }

    public String toSvg(String parameter) {
        String pointsString = "";
        for(Vec2 point : points)
            pointsString += point.x + "," + point.y + " ";
        return String.format(Locale.ENGLISH,"<polygon points=\"%s\"%s />", pointsString,parameter);
    }


}
