package fun.lsof.javacore.proxy.dynamic.aop;

public class ProxyFactoryTestForConcurrent {

    public static void main(String[] args) throws Exception {

        int i = 0;
        while (i <= 100) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ProxyFactoryTest.test();
                }
            }).start();
            i++;
        }
    }
}
