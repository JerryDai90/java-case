package fun.lsof.spring.aop.common;

public class BookShopService {


    public void deleteBook() {
        System.out.println(this.getClass() + ": deleteBook");
    }


    public void queryBook() {
        System.out.println(this.getClass() + ": queryBook");
    }



}
