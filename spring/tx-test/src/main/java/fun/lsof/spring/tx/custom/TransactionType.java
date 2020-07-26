package fun.lsof.spring.tx.custom;

public enum TransactionType {

    //不开启事务
    NONE,
    //遇到就开启事务，如果
    NEW,
    //一直开启新事务
    ALWAYS_NEW

}
