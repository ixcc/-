package offer;

public class Offer05 {

    public String replaceSpace(String s) {
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                str.append("%20");
            } else {
                str.append(c);
            }
        }
        return str.toString();

//        return s.replace(" ", "%20");
    }
}
