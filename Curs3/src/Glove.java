public class Glove implements ClothingItem {

    private int size;
    private String color;

    public Glove(int val, String s){
        size = val;
        color = s;
    }

    public int getSize(){
        return size;
    }

    public String getColor(){
        return color;
    }

    @Override
    public String toString() {
        String s;
        s = "Glove with size " + size + " and color " + color;
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
