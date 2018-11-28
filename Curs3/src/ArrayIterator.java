import java.util.*;

public class ArrayIterator<E> implements IArrayIterator{

    private E[] arr;
    private int count;

    public ArrayIterator(E[] arrT){
        arr = arrT;
        count = 0;
    }

    @Override
    public boolean hasNext() {
        return count < arr.length;
    }

    @Override
    public E next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }

        return arr[count++];
    }

}
