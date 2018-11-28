public class ListNotSortedException extends Exception {

    private String exp;

    public ListNotSortedException(){
        exp = "List is not sorted";
    }

    @Override
    public String getMessage() {
        return exp;
    }
}
