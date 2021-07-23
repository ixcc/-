package day;

public class day67 {

    public String addBinary(String a, String b) {
        String add = "";
        int bin = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int temp = 0;
            if (i < 0) {
                temp = (b.charAt(j) - 48) + bin;
                j--;
            } else if (j < 0) {
                temp = (a.charAt(i) - 48) + bin;
                i--;
            } else {
                temp = (a.charAt(i) - 48) + (b.charAt(j) - 48) + bin;
                i--;
                j--;
            }
            if (temp == 3) {
                add = "1" + add;
                bin = 1;
            } else if (temp == 2) {
                add = "0" + add;
                bin = 1;
            } else if (temp == 1) {
                add = "1" + add;
                bin = 0;
            } else if (temp == 0) {
                add = "0" + add;
                bin = 0;
            }
        }
        if (bin == 1) {
            add = "1" + add;
        }
        return add;
    }
}
