package offer;

public class Offer58II {

    public String reverseLeftWords(String s, int n) {
        String str = "";
        str = s.substring(n - 2, s.length() - 1) + s.substring(0, n);
        return str;
    }
}
