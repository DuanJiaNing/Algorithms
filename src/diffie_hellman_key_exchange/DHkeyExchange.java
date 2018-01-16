package diffie_hellman_key_exchange;

import org.junit.Test;

/**
 * Created on 2018/1/16.
 * HTTPS 密钥交换算法 diffie-Hellman Key Exchange
 * 使密钥安全通过不安全网络环境交换的算法
 *
 * @author DuanJiaNing
 */
public class DHkeyExchange {

    // 通信双方约定好的随机质数
    private static final int p = 17;

    // 随机数字
    private static final int g = 22222222;

    // 发送方保密随机数字
    private static final int senderX = 788888;

    //接收方保密随机数字
    private static final int receiverY = 73412;

    /**
     * 计算通信双方交换的数字
     *
     * @param a 双方独立的保密数字
     * @return 结果
     */
    public int cacl(int a) {
        return (int) (Math.pow(g, a) % p);
    }

    /**
     * 通信双方获得cacl计算出的数字后可解密得出密钥
     *
     * @param b cacl结果
     * @param x 双方独立的保密数字
     * @return 密钥
     */
    public int dcacl(int b, int x) {
        return (int) (Math.pow(b, x) % p);
    }

    @Test
    public void test() {
        int a = cacl(senderX);
        int b = cacl(receiverY);

        int keySender = dcacl(b, senderX);
        int keyReceiver = dcacl(a, receiverY);
        System.out.println(keyReceiver + " " + keySender);
    }


}
