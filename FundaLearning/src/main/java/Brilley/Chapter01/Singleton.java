package Brilley.Chapter01;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * @author Brilley
 * @date 2022/3/3
 */
public class Singleton {
    private Singleton(){}

    public String name;

    private static class SingletonHolder{
        public static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.instance;
    }
}
