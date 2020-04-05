package fun.lsof.spring.aop.dynamicproxy.jdk;

public class Chrome implements IBrowser {

    @Override
    public void visitInternet() {
        System.out.println("visitInternet");
    }

    @Override
    public void saveFile() {
        System.out.println("saveFile");
    }
}
