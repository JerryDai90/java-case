package fun.lsof.javacore.proxy.dynamic;

public class Bus implements ICar {

    @Override
    public void start() {
        System.out.println("Bus, start...");
    }

    @Override
    public void run() {
        System.out.println("Bus, run...");
    }

    @Override
    public void stop() {
        System.out.println("Bus, stop...");
    }
}
