public class SolidFilledShapeDecorator extends ShapeDecorator{
    private String color;

    public SolidFilledShapeDecorator(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }
@Override
    public String toSvg(String parameter){
    String fill = "fill=\""+this.color+"\"" + parameter;
        return super.toSvg(fill);
    }

}
