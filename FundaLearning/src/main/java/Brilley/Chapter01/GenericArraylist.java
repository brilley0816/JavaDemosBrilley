package Brilley.Chapter01;

import java.util.Arrays;

/**
 * @author Brilley
 * @date 2022/3/12
 */
public class GenericArraylist<E> {
    private Object[] elementData;
    private int size=0;
    public GenericArraylist(int initialCapacity){
        this.elementData=new Object[initialCapacity];
    }
    public boolean add(E ele){
        elementData[size++]=ele;
        return true;
    }
    public E get(int i)
    {
        return (E) elementData[i];
    }
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(elementData, size, a.getClass());
    }
}
