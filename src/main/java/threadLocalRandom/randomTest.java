package threadLocalRandom;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class randomTest {
    public static void test01(){
        Random random = new Random();
        for (int i=0;i<10;i++){
            System.out.println(random.nextInt(5));
        }
    }
    /*
    每个 Random 实例里面都有一个原子性的种子变量用来记录当前种子值，当要生成新的随机数时需要根据当前种子计算新的种子并更新回原子变量。在多线程
    下使用单个 Random 实例生成随机数时，当多个线程同时计算随机数来计算新的种子时，多个线程会竞争同一个原子变量的更新操作，由于原子变量更新是
    CAS 操作，同时只有一个线程会成功，所以会造成大量线程进行自旋重试 这会降低并发性能，所以ThreadLocalRandom 应运而生。
    */
    /*原理类似于threadLocal，每个线程维护一个属于自己的随机数种子*/
    public static void test02(){
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int i=0;i<10;i++){
            System.out.println(threadLocalRandom.nextInt(5));
        }
    }

    public static void main(String[] args) {
        test02();
    }
}
