package day;

public class day66 {

    public int[] plusOne(int[] digits) {
        int add = 1;
        int i = digits.length - 1;
        while (add == 1 && i >= 0) {
            if (digits[i] + add >= 10) {
                digits[i] = 10 - (digits[i] + add);
            } else {
                digits[i] = digits[i] + add;
                add = 0;
            }
            i--;
        }
        if (add == 1) {
            int[] addDigits = new int[digits.length + 1];
            addDigits[0] = 1;
            for (int j = 1; j <= addDigits.length - 1; j++) {
                addDigits[j] = digits[j - 1];
            }
            return addDigits;
        }
        return digits;
    }
}
