package day;

public class day88 {
    public static void main(String[] args) {
        day88 test = new day88();
        test.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
//        System.out.println(merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int index = m + n - 1;
        while (i >=0 || j >= 0) {
            if (j < 0 || (i >= 0 && nums1[i] >= nums2[j]) ) {
                nums1[index] = nums1[i];
                i--;
            } else if (i < 0 || (j >= 0 && nums1[i] < nums2[j])) {
                nums1[index] = nums2[j];
                j--;
            }
            index--;
        }
    }
}
