import java.lang.reflect.Field;

public class Pair<T> {

    private T left;
    private T right;

    public Pair(T first, T second){

        try {
            left = first;
            right = second;
            if(match()){
               // System.out.println("Gud");
            }
        }catch (Exception e){
            System.err.println(e);
        }

    }

    private boolean match() throws Exception {
        if(left.getClass().equals(right.getClass())){
            Field sizeL, sizeR, colorL, colorR;
            sizeL = left.getClass().getDeclaredField("size");
            sizeR = right.getClass().getDeclaredField("size");
            colorL = left.getClass().getDeclaredField("color");
            colorR = right.getClass().getDeclaredField("color");

            sizeL.setAccessible(true);
            sizeR.setAccessible(true);
            colorL.setAccessible(true);
            colorR.setAccessible(true);

            Object sL = sizeL.get(left);
            Object sR = sizeR.get(right);
            Object cL = colorL.get(left);
            Object cR = colorR.get(right);

            if(!sL.equals(sR)){
                throw  new Exception("Sizes do not match");
            }
            if(!cL.equals(cR)){
                throw new Exception("Colors do not match");
            }
            return true;
        }
        return false;

    }

    public T getLeft() {
        return left;
    }

    public T getRight() {
        return right;
    }
}
