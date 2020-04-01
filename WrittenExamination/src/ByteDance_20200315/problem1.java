package ByteDance_20200315;

import java.util.*;

/**
 * @description: problem1:模型去重，ac50%
 * @date: 2020/3/15 19:08
 * @author: Finallap
 * @version: 1.0
 */
public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Set<String>> map = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            String input = sc.nextLine();
            if (input.length() == 0)
                continue;
            String[] inputs = input.split(" ");
            String userType = inputs[0];
            String modelFile = inputs[1];
            Set<String> resultSet;
            if (map.containsKey(modelFile))
                resultSet = map.get(modelFile);
            else
                resultSet = new TreeSet<>();

            resultSet.add(userType);
            map.put(modelFile, resultSet);
        }

        for (String keys : map.keySet()) {
            StringBuffer sb = new StringBuffer();
            sb.append(keys + ' ');
            Set<String> resultSet = map.get(keys);
            List<String> list = new ArrayList<>(resultSet);
            Collections.sort(list);
            Iterator<String> iter = list.iterator();
            while (iter.hasNext()) {
                sb.append(iter.next() + ' ');
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}
