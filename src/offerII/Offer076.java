package offerII;

/**
 * 寻找数组第K大的元素
 */
public class Offer076 {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{1332802,1177178,1514891,871248,753214,123866,
                1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,
                1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,
                1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,
                937247,986578,798663}, 24));
    }

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        quick(nums, 0, n - 1,n - k);
        return nums[n - k];
    }

    public static void quick(int[] a, int left, int right, int k) {
        int i = left, j = right;
        int index = a[left];
        while (i < j) {
            while (i < j && a[j] >= index) {
                j--;
            }
            while (i <j && a[i] <= index) {
                i++;
            }
            swap(a, i, j);
        }
        swap(a,i,left);
        if (i < k) {
            quick(a, i + 1, right, k);
        }
        if (i > k) {
            quick(a, left, i - 1, k);
        }
    }
    public static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
