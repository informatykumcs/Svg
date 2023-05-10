import java.util.Locale;

public class Ellipse implements Shape{
    private Vec2 center;
    double rx,ry;
    public Ellipse(Vec2 point1,double x,double y){

        this.center=point1;
        this.rx=x;
        this.ry=y;
    }



    public String toSvg(String parameter){
        return String.format(Locale.ENGLISH,"<ellipse cx=\"%f\" cy=\"%f\" rx=\"%f\" ry=\"%f\" %s/>", center.x,center.y,rx,ry, parameter);
    }



}
