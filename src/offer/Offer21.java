package offer;

public class Offer21 {
    public static void main(String[] args) {
        System.out.println(exchange(new int[]{1,2,3,4}));
    }

    public static int[] exchange(int[] nums) {
        //左右指针，分别指向数组两端
        int left = 0 ,right = nums.length-1;
            while (left<right){
                if((nums[left] & 1) == 0 && (nums[right] & 1) != 0){
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                    right--;
                }else if((nums[right] & 1) == 0){
                    right--;
                }else if((nums[left] & 1) != 0){
                    left++;
                }
            }
            return nums;


//        //左右指针，分别指向数组两端
//       int left = 0 ,right = nums.length-1;
//       while (left<=right){
//           //找到左侧偶数和右侧奇数--则交换
//           if(nums[left]%2 == 0 && nums[right]%2 != 0){
//               int temp = nums[left];
//               nums[left] = nums[right];
//               nums[right] = temp;
//               left++;
//               right--;
//           }else if(nums[right]%2 == 0){
//               //右侧非偶--右指针减一
//               right--;
//           }else if(nums[left]%2 != 0){
//               //左侧非奇--左指针加一
//               left++;
//           }
//       }
//       return nums;
    }

    public static int[] exchange2(int[] nums) {
        //快慢指针
        int low = 0 ,fast = 1;
        while (fast<=nums.length-1){
            //找到左侧偶数和右侧奇数--则交换
            if((nums[fast] & 1) != 0){
                int temp = nums[low];
                nums[low] = nums[fast];
                nums[fast] = temp;
                low++;
            }
            fast++;
        }
        return nums;
    }
}
