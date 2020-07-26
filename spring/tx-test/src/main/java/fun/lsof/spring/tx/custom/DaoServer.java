package fun.lsof.spring.tx.custom;

import fun.lsof.spring.tx.test.AbsRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
@Transaction(TransactionType.NEW)
public class DaoServer extends AbsRoot2{

//    @Transaction(TransactionType.NEW)
    public void insert(){
//        super.insert(1);
//        super.insert(1);
        super.insert(1);
        System.out.println("call...really");
    }



}
