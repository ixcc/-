package interview;

import java.sql.SQLOutput;
import java.util.*;

public class interview05 {

    /**
     * 数字1-10随机 排序 输出数字和序号
     * @param
     * @return
     */
//    public ArrayList<ArrayList<Integer>> sort(int[] array){
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < array.length; i++) {
//            map.put(array[i],i);
//        }
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0 ; i < 10; i++) {
//            while (!stack.isEmpty()) {
//                if (stack.pop() > map.get(i)) {
//
//                }
//            }
//            if ((stack.pop() != null && stack.pop() > map.get(i)) || stack.pop() == null) {
//                int[] arr = new int[2];
//                arr[0] = map.get(i);
////                arr[1] = map.get();
//            } else if (stack.pop() != null && map.get(i) < stack.pop()) {
//                stack.add(map.get(i));
//            }
//        }
//    }

    /**
     * map遍历方式
     */
    public void mapFor() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("aaa", 111);
        map.put("bbb", 222);
        map.put("ccc", 333);
        map.put("ddd", 444);
        //Map集合循环遍历方式一
        System.out.println("第一种：通过Map.keySet()遍历key和value：");
        for(String key:map.keySet()){//keySet获取map集合key的集合  然后在遍历key即可
            String value = map.get(key).toString();//
            System.out.println("key:"+key+" vlaue:"+value);
        }

        //Map集合循环遍历二  通过迭代器的方式
        System.out.println("第二种：通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Object> entry = it.next();
            System.out.println("key:"+entry.getKey()+"  key:"+entry.getValue());
        }

        // Map集合循环遍历方式三 推荐，尤其是容量大时
        System.out.println("第三种：通过Map.entrySet遍历key和value");
        for (Map.Entry<String, Object> m : map.entrySet()) {
            System.out.println("key:" + m.getKey() + " value:" + m.getValue());
        }

        // 第四种：
        System.out.println("第四种：通过Map.values()遍历所有的value，但不能遍历key");
        for(Object m:map.values()){
            System.out.println(m);
        }
    }

    public static void printRandBySort() {
        Random random = new Random();
        List list =  new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }
        Collections.sort(list); // 对集合排序
        Iterator it = list.iterator();
        int count = 0;
        while (it.hasNext()) {
            System.out.println(++count + ":" +it.next());
        }
    }

    public static void printRandBySort2() {
        Random random = new Random();
        List<Integer> list =  new ArrayList();
        List<Integer> list2 =  new ArrayList();
        for (int i = 0; i < 10; i++) {
            int ram = random.nextInt(10);
            list.add(ram);
            list2.add(ram);
        }
        System.out.println(list);
        Collections.sort(list2); // 对集合排序
        System.out.println(list2);
        int a = -1;
        for (int i = 0; i < list2.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list2.get(i) == list.get(j) && a != j) {
                    a = j;
                    if (i == 0) {
                        System.out.println("值：" + list2.get(i) + ":下标" + j);
                    }
                    if (i != 0 && list2.get(i) != list2.get(i-1)) {
                        System.out.println("值：" + list2.get(i) + ":下标" + j);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        printRandBySort2();
    }
}
