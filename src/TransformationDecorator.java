import java.util.Locale;

public class TransformationDecorator extends ShapeDecorator {
    private boolean translate;
    private Vec2 translateVector;

    private boolean rotate;
    private double rotateAngle;
    private Vec2 rotateCenter;

    private boolean scale;
    private Vec2 scaleVector;
    private Shape shape;

    public TransformationDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public String toSvg(String paremeter) {

        String result = "transform=\"";

        if (translate) {
            result +=String.format(Locale.US, "translate(%f %f) ", this.translateVector.x, this.translateVector.y);
        }

        if (rotate) {
            result += String.format(Locale.US, "rotate(%f %f %f) ", rotateAngle, rotateCenter.x, rotateCenter.y);
        }

        if (scale) {
            result += String.format(Locale.US, "scale(%f %f) ", scaleVector.x, scaleVector.y);
        }

        result +="\"";

        return super.toSvg(result);
    }


    public static class Builder {
        private boolean translate = false;
        private Vec2 translateVector;

        private boolean rotate = false;
        private double rotateAngle;
        private Vec2 rotateCenter;

        private boolean scale = false;
        private Vec2 scaleVector;
        private Shape shape;

        public Builder(Shape shape) {
            this.shape = shape;
        }

        public Builder translate(Vec2 vector) {
            this.translate = true;
            this.translateVector = vector;
            return this;
        }

        public Builder rotate(double angle, Vec2 center) {
            this.rotate = true;
            this.rotateAngle = angle;
            this.rotateCenter = center;
            return this;
        }

        public Builder scale(Vec2 vector) {
            this.scale = true;
            this.scaleVector = vector;
            return this;
        }


        public TransformationDecorator build() {
            TransformationDecorator decorator = new TransformationDecorator(shape);
            if (translate == true) {
                decorator.translate = this.translate;
                decorator.translateVector = this.translateVector;
            }
            if (rotate == true) {
                decorator.rotate = this.rotate;
                decorator.rotateAngle = this.rotateAngle;
                decorator.rotateCenter = this.rotateCenter;
            }
            if (scale == true) {
                decorator.scale = this.scale;
                decorator.scaleVector = this.scaleVector;
            }
            return decorator;

        }

    }
}



