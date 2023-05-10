import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class SvgScene {
    private Shape shapes[] = new Shape[0];
    private String def[]=new String[0];
    private  static SvgScene instance=null;

    public static SvgScene getInstance(){
        if(instance==null)
        {
            instance=new SvgScene();
        }
        return instance;
    }


    public void addShape(Shape poly) {
        shapes = Arrays.copyOf(shapes, shapes.length + 1);
        shapes[shapes.length - 1] = poly;
    }

    public void save(String path) {
        try {
            FileWriter file = new FileWriter(path);
            file.write("<html>\n<body>\n");

            file.write(String.format("<svg width=1000 height=1000>\n"));



            for(Shape shape : shapes) {
                if (def.length > 0) {
                    file.write("<defs>\n"+String.join("",def)+"\n</defs>\n");
                }

                file.write("\t" + shape.toSvg("") + "\n");
            }
            file.write("</svg>\n</body>\n</html>\n");
            file.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void addShadow(String parameter) {
        def = Arrays.copyOf(def, def.length + 1);
        def[def.length - 1] = parameter;
    }

    public void addGradients(String parameter) {
        def = Arrays.copyOf(def, def.length + 1);
        def[def.length - 1] = parameter;
    }


}
