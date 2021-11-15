package day;

/**
 * 灯泡开关
 */
public class day319 {

    /**
     * 计算n的开方值--求约数
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n + 0.5);
    }

    /**
     * 模拟--超时
     * @param n
     * @return
     */
    public static int bulbSwitch2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 4) {
            return 1;
        }
        int[] arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = 1;
        }
        int time = 2;
        while (time <= n) {
            int temp = time;
            while (temp <= n) {
                arr[temp] = arr[temp] == 1 ? 0 : 1;
                temp = temp + time;
            }
            time++;
        }
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }
        return count;
    }
}
