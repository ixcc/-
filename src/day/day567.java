package day;

public class day567 {
    public static void main(String[] args) {
        System.out.println(checkInclusion2("adc",
                "dcda"));
    }
    public static boolean checkInclusion2(String s1, String s2) {
        int n = s2.length();
        int[] dict = new int[26];
        int[] freq = new int[26];
        int size = 0;
        for(char c : s1.toCharArray()) {
            if(dict[c - 'a'] == 0) size++;
            dict[c - 'a']++;
        }
        int match = 0;
        int left = 0, right = 0;
        while(right < n) {
            char rc = s2.charAt(right);
            freq[rc - 'a']++;
            if(freq[rc - 'a'] == dict[rc - 'a']) match++;
            while(size == match) {
                if(right - left + 1 == s1.length()) return true;
                char lc = s2.charAt(left);
                freq[lc - 'a']--;
                if(freq[lc - 'a'] < dict[lc - 'a']) match--;
                left++;
            }
            right++;
        }
        return false;
    }


    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
           return false;
        }
        int[] array = new int[26];
        int[] temp = new int[26];
        int len = s1.length();
        int end = len;
        int times = 0;
        for (int i = 0; i < len; i++) {
            array[s1.charAt(i) - 97] ++;
            temp[s2.charAt(i) - 97]++;
        }
        for (int j = 0; j < 26; j++) {
            if (array[j] !=0 ) {
                times++;
            }
        }

        while (end <= s2.length()) {
            for (int i = 0; i < 26; i++) {
                if (array[i] == temp[i] && array[i] != 0) {
                    times--;
                    if (times == 0) {
                        return true;
                    }
                } else if (array[i] != temp[i]) {
                   times = len;
                   break;
                }
            }
            if (end == s2.length()) {
                return false;
            }
            temp[s2.charAt(end - len) - 97]--;
            temp[s2.charAt(end) - 97]++;
            end++;
        }
        return false;
    }
}
