package day;

/**
 * 句子相似性
 */
public class day1813 {

    /**
     * 双指针
     * @param sentence1
     * @param sentence2
     * @return
     */
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        int i = 0, j = 0;
        int n = arr1.length, m = arr2.length;
        while (i < n && i < m && arr1[i].equals(arr2[i])) {
            i++;
        }
        while (j < n - i && j < m - i && arr1[n - j - 1].equals(arr2[m - j - 1])) {
            j++;
        }
        return i + j == Math.min(n, m);
    }
}
