public class Main {
    public static void main(String[] args) {

    Vec2[] points=new Vec2[3];
    points[0]=new Vec2(100,10);
    points[1]=new Vec2(40,198);
    points[2]=new Vec2(190,78);
    Shape triangle=new Polygon(points);
   // triangle=new SolidFilledShapeDecorator(triangle,"blue");
   // triangle = new StrokeShapeDecorator(triangle, "green", 2);

//    Shape ellipse = new Ellipse(new Vec2(100, 100), 80, 70);
//    ellipse = new SolidFilledShapeDecorator(ellipse, "blue");
//    ellipse = new StrokeShapeDecorator(ellipse, "green", 24);
//
//    Shape polygon = new Polygon(points);
//    polygon=new SolidFilledShapeDecorator(polygon,"red");
//    TransformationDecorator shape = new TransformationDecorator
//            .Builder(polygon)
//            .translate(new Vec2(20,30))
//            .rotate(90,new Vec2(40,50))
//            .scale(new Vec2(1,1))
//            .build();




//        DropShadowDecorator  TriangeShadow= new DropShadowDecorator(triangle);
//        TriangeShadow.setIndex(10);
//        String shadow= TriangeShadow.DropShadow();


        GradientFillShapeDecorator TriangeGradient = new GradientFillShapeDecorator(triangle);
        TriangeGradient.setIndex(10);
        GradientFillShapeDecorator gradient = new GradientFillShapeDecorator
                .Builder(triangle)
                .MakeGradient("red",0)
                .MakeGradient("blue",50)
                .MakeGradient("green",100)
                .build();




    SvgScene scene=new SvgScene();
   // scene.addGradient();
 //    scene.addShape(triangle);
scene.addShape(TriangeGradient);
        scene.addGradients(TriangeGradient.LinearGradient());
//    scene.addShadow(shadow);

//    scene.addShape(ellipse);
//    scene.addShape(shape);
    scene.save("scene.html");








    }
}