import java.util.Arrays;
import java.util.Locale;

public class GradientFillShapeDecorator extends ShapeDecorator{

    public GradientFillShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }
    private static int index;
    private Shape shape;
    private boolean gradient=false;
    private String gradients[]=new String[0];

    public static void setIndex(int index) {
        GradientFillShapeDecorator.index=index;
    }



    public static class Builder{
        private Shape shape;
        private String colour;
        private int offset;
        private static String gradients[]=new String[0];

        public Builder(Shape shape) {
            this.shape = shape;
        }


        public void addGradients(String colour, int offset) {
            gradients = Arrays.copyOf(gradients, gradients.length + 1);
            gradients[gradients.length - 1] =  String.format(Locale.US, "\t\t<stop offset=\"%d%%\" style=\"stop-color:%s\" />\n" , offset,colour);
        }

        public Builder MakeGradient(String colour, int offset) {
            this.colour = colour;
            this.offset = offset;
            addGradients(colour,offset);
            return this;
        }

        public GradientFillShapeDecorator build(){

            GradientFillShapeDecorator decorator = new GradientFillShapeDecorator(shape);


           return decorator;
        }


    }

 public String LinearGradient(){

        return  String.format(Locale.US, "\t<linearGradient id=\"g%d\" >\n",index)+String.join("", Builder.gradients)+"\t</linearGradient>";
 }



    @Override
    public String toSvg(String parameter) {

        String result = String.format(Locale.US, "fill=\"url(#g%d)\" ", index);



        return super.toSvg(result);
    }


    
}
