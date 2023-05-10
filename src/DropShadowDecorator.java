import java.util.Locale;

public class DropShadowDecorator extends ShapeDecorator{
private static int index;

    public static void setIndex(int index) {
        DropShadowDecorator.index = index;
    }

    public DropShadowDecorator(Shape decoratedShape) {
        super(decoratedShape);

    }
    public String DropShadow(){
    String result = String.format(Locale.US, "\t<filter id=\"f%d\" x=\"-100%%\" y=\"-100%%\" width=\"300%%\" height=\"300%%\">\n" +
            "\t\t<feOffset result=\"offOut\" in=\"SourceAlpha\" dx=\"5\" dy=\"5\" />\n" +
            "\t\t<feGaussianBlur result=\"blurOut\" in=\"offOut\" stdDeviation=\"5\" />\n" +
            "\t\t<feBlend in=\"SourceGraphic\" in2=\"blurOut\" mode=\"normal\" />\n" +
            "\t</filter>", index);
        return result;
    }

    @Override
    public String toSvg(String parameter) {

        String result = String.format(Locale.US, "filter=\"url(#f%d)\" ", index);



        return super.toSvg(result);
    }
}
