package offerII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 含有重复元素的集合组合
 */
public class Offer082 {

    /**
     * 回溯，数组排序
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        dfs(list, candidates, target, 0, 0);
        return res;
    }

    public void dfs(List<Integer> list, int[] candidates, int target, int k, int index) {
        if (target == k) {
            List<Integer> li = new ArrayList<>(list);
            Collections.sort(li);
            if (!res.contains(li)) {
                res.add(li);
            }
            return;
        }
        if (target < k) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(list, candidates, target, k + candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }


}
