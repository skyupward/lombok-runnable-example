package skyupward.lombok;

import lombok.ToString;
import org.junit.jupiter.api.Assertions;

/**
 * @author SkyUpward
 * Created at 2017/11/10 21:24
 */
@ToString(exclude="id")
public class ToStringExample {
    private static final int STATIC_VAR = 10;
    private String name;
    private Shape shape = new Square(5, 10);
    private String[] tags;
    private int id;

    public String getName() {
        return this.name;
    }

    @ToString(callSuper=true, includeFieldNames=true)
    public static class Square extends Shape {
        private final int width, height;

        public Square(int width, int height) {
            this.width = width;
            this.height = height;
        }

    }

    @ToString
    public static class Shape{
        private int id;
    }

    public static void main(String[] args){
        ToStringExample toStringExample = new ToStringExample();
        Assertions.assertEquals(
                "ToStringExample(name=null, shape=ToStringExample.Square(" +
                        "super=ToStringExample.Shape(id=0), width=5, height=10), tags=null)" ,
                toStringExample.toString());
    }
}
