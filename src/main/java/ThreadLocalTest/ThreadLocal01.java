package ThreadLocalTest;

public class ThreadLocal01 {
    static ThreadLocal<String> threadLocalA = new ThreadLocal();

    static void print(String threadName){
        System.out.println(threadName+":"+threadLocalA.get());
    }

    public static void main(String[] args) {
        new Thread(()->{
            threadLocalA.set("variableA");
            print(Thread.currentThread().getName());
            threadLocalA.remove();
            print(Thread.currentThread().getName());
        }).start();

        new Thread(()->{
            threadLocalA.set("variableB");
            print(Thread.currentThread().getName());
            threadLocalA.remove();
            print(Thread.currentThread().getName());
        }).start();


    }
}
