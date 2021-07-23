package offer;

public class Offer58I {

    public String reverseWords(String s) {
        s = s.trim(); // 去掉首尾空格
        String cut = "\\s+";// 分割串，此处为至少一个空格
        String[] newStr = s.split(cut);// 分割成数组
        String str = "";
        for (int i = newStr.length - 1; i > 0; i--) {
            str += newStr[i] + " ";
        }
        str += newStr[0];
        return str;
    }

    public String reverseWords2(String s) {
        s = s.trim(); // 去掉首尾空格
        int i = s.length() - 1, j = i;
        StringBuilder str = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' '){
                // 找到单词后的第一个空格位置
                i--;
            }
            // str追加搜索到的单词
            str.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') {
                // 找到空格后的下一个单词末尾字符或字母
                i--;
            }
            j = i;
        }
        // 转为目标字符串去掉末尾空格
        return str.toString().trim();
    }
}
