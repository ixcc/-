package day;

public class day852 {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middel = (left + right) / 2;
            if (arr[middel] > arr[middel - 1] && arr[middel] > arr[middel + 1]) {
                return middel;
            } else if (arr[middel] > arr[middel - 1] && arr[middel] < arr[middel + 1]){
                left = middel;
            } else if (arr[middel] < arr[middel - 1] && arr[middel] > arr[middel + 1]){
                right = middel;
            }
        }
        return 0;
    }
}
