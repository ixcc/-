package offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Offer38 {

    List<String> list = new LinkedList<>(); // 存放排序字符串
    char[] array; // 存放s的字符数组
    public String[] permutation(String s) {
        array = s.toCharArray(); // 将字符串转换为数组
        dfs(0); // 从第一位数字开始
        String[] strings = new String[list.size()]; // 定义返回的字符串数组
        return list.toArray(strings); // list转数组
    }

    public void dfs(int index) {
        // 当前字符为最后一个字符
        if (index == array.length - 1) {
            list.add(String.valueOf(array)); // 排序后字符串追加进集合list
            return;
        }
        HashSet<Character> set = new HashSet<>(); // 定义hashSet用于记录是否重复数字
        for (int i = index; i < array.length; i++) {
            // 包含重复值则跳过继续--剪枝
            if (set.contains(array[i])) {
                continue;
            }
            // 不含重复值则加到hashSet中记录--避免同层出现相同元素
            set.add(array[i]);
            swap(i, index); // 交换，自己和自己或自己和其余可能节点数据（将某节点所有同层节点的情况处理一次）
            dfs(index + 1); // 遍历下一位
            swap(i, index); // 遍历完交换回来--保持数组顺序不变
        }
    }

    public void swap(int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
