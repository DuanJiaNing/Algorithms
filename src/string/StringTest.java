package string;

import org.junit.Test;
import util.P;

/**
 * Created on 2018/1/16.
 *
 * @author DuanJiaNing
 */
public class StringTest {


    /**
     * 截取字符串，中文不能被错误截取
     */
    @Test
    public void test() {
        String str = "zaa中是aa我a 你a";
//        P.out(split(5, str));// zaa中
        P.out(reverse(str));// zaa中
    }

    // len为字节数
    private String split(int len, String str) {
        if (str == null || str.length() == 0 || len <= 0) {
            return null;
        }

        char[] cs = str.toCharArray();
        StringBuilder b = new StringBuilder();
        int co = 0;
        for (char c : cs) {
            if (co < len) {
                if (String.valueOf(c).getBytes().length > 1) { // 中文
                    if (co + 1 == len) return b.toString();
                    else {
                        b.append(c);
                        co += 2;
                    }
                } else {
                    co++;
                    b.append(c);
                }
            }
        }

        return b.toString();

    }

    // 倒序重组反转字符串
    private String reverse1(String str) {

        char[] cs = new char[str.length()];
        int len = str.length();
        for (char c : str.toCharArray()) {
            cs[--len] = c;
        }

        return new String(cs);

    }

    // 递归反转字符串
    private String reverse(String str) {
        if (str.length() <= 1) return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }


}
