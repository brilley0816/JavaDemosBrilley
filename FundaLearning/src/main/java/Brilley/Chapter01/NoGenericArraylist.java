package Brilley.Chapter01;

/**
 * @author Brilley
 * @date 2022/3/12
 */
public class NoGenericArraylist {
    private Object[] objs;
    private int i=0;

    public NoGenericArraylist(int initialCapacity){
        this.objs=new Object[initialCapacity];

    }

    public void add(Object obj)
    {
        objs[i++]=obj;
    }
    public Object get(int i)
    {
        return objs[i];
    }
}
