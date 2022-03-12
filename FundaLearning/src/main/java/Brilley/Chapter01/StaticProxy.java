package Brilley.Chapter01;

/**
 * @author Brilley
 * @date 2022/3/12
 */
public class StaticProxy implements Subject{
    private RealSubject real;
    @Override
    public void hello(String str){
        if(null==real)
        {
            real=new RealSubject();
        }
        real.hello(str);
    }

    @Override
    public String bye(){
        if(null==real)
        {
            real=new RealSubject();
        }
        return real.bye();
    }
}
