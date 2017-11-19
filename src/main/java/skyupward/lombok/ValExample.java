package skyupward.lombok;

import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author SkyUpward
 * Created at 2017/11/10 20:41
 */
public class ValExample {

    public String listExample() {
        val example = new ArrayList<String>();
        example.add("Hello, World!");
        val foo = example.get(0);
        return foo.toLowerCase();
    }

    public void mapExample() {
        val map = new HashMap<Integer, String>();
        map.put(0, "zero");
        map.put(5, "five");
        for (val entry : map.entrySet()) {
            System.out.printf("%d: %s\n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args){
        ValExample valExample = new ValExample();
        valExample.listExample();
        valExample.mapExample();
    }

}
