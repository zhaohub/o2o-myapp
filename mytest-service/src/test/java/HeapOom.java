import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/7/25.
 */
public class HeapOom {
    static class OomObject{
    }

    public static void main(String[] args) throws InterruptedException {
        List<OomObject> list = new ArrayList<OomObject>();
        while (true){
            list.add(new OomObject());
            Thread.sleep(1);
        }
    }

}
