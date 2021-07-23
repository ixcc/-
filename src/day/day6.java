package day;

public class day6 {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (s.length() == numRows) {
            return s;
        }
        String str = "";
        String[] strBuffer = new String[numRows];
        strBuffer[0] = String.valueOf(s.charAt(0)) ;
        int index = 0;
        while (index <= s.length() - 1){
            int i = 1;
            while (i <= numRows - 1 && index < s.length() - 1) {
                index++;
                if (strBuffer[i] == null) {
                    strBuffer[i] = String.valueOf(s.charAt(index));
                } else {
                    strBuffer[i] = strBuffer[i] + String.valueOf(s.charAt(index));
                }
                i++;
            }
            int j = numRows - 2;
            while (j >= 0 && index < s.length() - 1) {
                index++;
                if (strBuffer[j] == null) {
                    strBuffer[j] = String.valueOf(s.charAt(index));
                } else {
                    strBuffer[j] = strBuffer[j] + String.valueOf(s.charAt(index));
                }
                j--;
            }
        }
        for (String s1 : strBuffer) {
            str = str + s1;
        }
        return str;
    }
}
