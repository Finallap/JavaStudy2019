package sys.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCollection {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("red", "yellow", "green");
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
    }
}
