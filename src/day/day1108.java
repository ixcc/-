package day;

/**
 * ip地址无效化
 */
public class day1108 {

    /**
     * stringbuffer
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                str.append("[.]");
            } else {
                str.append(address.charAt(i));
            }
        }
        return str.toString();
    }

    /**
     * replace("替换前"，"替换后")
     * @param address
     * @return
     */
    public String defangIPaddr2(String address) {
        return address.replace(".", "[.]");
    }
}
