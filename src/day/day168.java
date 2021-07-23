package day;

public class day168 {

    public String convertToTitle(int columnNumber) {
        StringBuffer title = new StringBuffer();
        while (columnNumber > 0){
            columnNumber--;
            title.append((char)(columnNumber % 26 + 'A'));
            columnNumber = columnNumber / 26;
        }
        // 翻转字符串
        return title.reverse().toString();
    }
}
