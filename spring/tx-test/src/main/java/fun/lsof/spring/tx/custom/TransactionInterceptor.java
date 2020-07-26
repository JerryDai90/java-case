package fun.lsof.spring.tx.custom;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.AopUtils;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;

public class TransactionInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Class<?> targetClass = (invocation.getThis() != null ? AopUtils.getTargetClass(invocation.getThis()) : null);

        DataSource bean = CustomAppTest.context.getBean(DataSource.class);


//        DataSourceManager.


//        DataSourceUtils.getConnection();

        Transaction[] annotationsByType = targetClass.getAnnotationsByType(Transaction.class);

        if (null != annotationsByType) {
            DataSourceManager.setConnect(bean, targetClass.getName());
        }



//        System.out.println("00000");

        Object proceed = invocation.proceed();


//        System.out.println("11111111");
        return proceed;
    }
}
