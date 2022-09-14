package day;

public class day1598 {

    public static void main(String[] args) {
        System.out.println(minOperations(new String[]{"./","../","./"}));
    }

    public static int minOperations(String[] logs) {
        int count = 0;
        for (int i = 0; i < logs.length; i++) {
            if (logs[i] == "../" && count > 0) {
                count--;
            } else if (logs[i] == "./" || logs[i] == "../" && count == 0) {
                continue;
            } else {
                count++;
            }
        }
        return count;
    }
}
