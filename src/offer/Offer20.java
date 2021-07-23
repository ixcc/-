package offer;

public class Offer20 {

    public boolean isNumber(String s) {
        //边界处理
        if(s.length() == 0 || s == null){
            return false;
        }
        //符号出现标识
        Boolean numSeen = false; //数字
        Boolean dotSeen = false; //小数点.
        Boolean eSeen = false; //e或者E
        //处理字符串首字符空格并转为char遍历
        char[] str = s.trim().toCharArray();
        for(int i=0;i<str.length;i++){
            if(str[i] >= '0' && str[i] <= '9'){
                //是数字
                numSeen = true;
            }else if(str[i] == '.'){
                //小数点(.出现正确情况：只出现一次，且在e的前面) --之前出现过.或者e/E后面
                if(dotSeen || eSeen){
                    return false;
                }
                dotSeen = true;//标识为已出现
            }else if(str[i] == 'e' || str[i] == 'E'){
                //e或者E(‘e’出现正确情况：只出现一次，且出现前有数字)--之前出现过e/E,前面没数字
                if(!numSeen || eSeen){
                    return false;
                }
                numSeen = false;//为了避免123e这种情况，出现e之后需要还有数字出现，所以标志为false
                eSeen = true;//标识为已出现
            }else if(str[i] == '+' || str[i] == '-'){
                //符号--在非首位且前一位不是e/E
                if(i != 0 && str[i-1] != 'e' && str[i-1] != 'E'){
                    return false;
                }
            }else {
                //其他非法字符
                return false;
            }
        }
        return numSeen;
    }

}
