import java.util.HashMap;
import java.util.Map;


/**
 * Created by zhaogang3 on 2016/6/21.
 */
public class Test {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("test1", "test1");
        map.put("test2", "test2");
        MyMap myMap = new MyMap(map.entrySet());

        System.out.println(myMap.get("test1"));
        System.out.println(myMap.containsKey("test1"));

    }
}
