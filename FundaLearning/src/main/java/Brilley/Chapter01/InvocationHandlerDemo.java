package Brilley.Chapter01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Brilley
 * @date 2022/3/12
 */
public class InvocationHandlerDemo implements InvocationHandler {
    private Object subject;

    public InvocationHandlerDemo(Object subject){
        this.subject=subject;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args) throws Throwable{
        System.out.println("Call Method: "+method);
        Object obj=method.invoke(subject,args);
        return obj;
    }
}
