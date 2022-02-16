package offerII;

import java.util.ArrayList;
import java.util.List;

/**
 * 允许重复选择元素的组合
 */
public class Offer081 {
    /**
     * 回溯 dfs
     */
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<Integer>();
        dfs(list, candidates, target, 0, 0);
        return res;
    }

    public void dfs(List<Integer> list, int[] candidates, int target, int k, int index) {
        if (target == k) {
            res.add(new ArrayList<>(list));
        }
        if (target < k) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(list, candidates, target, k + candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}
