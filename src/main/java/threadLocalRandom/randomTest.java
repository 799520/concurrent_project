package threadLocalRandom;

import java.util.Random;

public class randomTest {
    public static void test01(){
        Random random = new Random();
        for (int i=0;i<10;i++){
            System.out.println(random.nextInt(5));
        }
    }

    public static void main(String[] args) {
        test01();
    }
}
