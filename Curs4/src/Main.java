import java.lang.reflect.Constructor;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        /*int elements = 100_000;
        int searched = 90_000;

        List myList = new ArrayList();
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.add("four");

        List chkList = Collections.checkedList(myList, String.class);
        System.out.println("Checked content: " + chkList);


        myList.add(10);
        chkList.add(10);

        Map <IPerson, Integer> map01 = new HashMap<>();
        logAdding(map01, PersonWithEqualsAndHash.class, elements);
        logSearching(map01, new PersonWithEqualsAndHash("p" + searched, searched));

        Map <IPerson, Integer> map02 = new HashMap<>();
        logAdding(map02, Person.class, elements);
        logSearching(map02, new Person("p" + searched, searched));

       int[] arr = new int[6];
       for(int i = 0; i < 6; i++){
           arr[i] = 6 - i;
       }

        determineLeaders(arr, 6); */
        //PascalSum(size);
        //int size = 10;
        //BellsTriangle(size);

      /*  ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(1) ;
        arr1.add(5);
        arr1.add(6);
        arr2.add(2);
        arr2.add(3);
        arr2.add(4);

        ArrayList<Integer> arr3 = new ArrayList<>();
        try{
            arr3 = Interclasare(arr1, arr2);
        }catch (Exception e){
            System.err.println(e);
        }
        System.out.println(arr3);
    */
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(6);
        arr1.add(7);
        arr1.add(1) ;
        arr1.add(5);

        /*
        ArrayList<ArrayList<Integer>> arr2 = new ArrayList<>();
        arr2.add(arr1);
        arr2.add(arr1);
        arr2.add(arr1);
        arr2.add(arr1);

        System.out.println(arr2.get(0));
        System.out.println(arr2.get(1));
        System.out.println(arr2.get(2));
        System.out.println(arr2.get(3));

        spiralTraverse(arr2);
        */

        LinkedList<Integer> arr = new LinkedList<>();
        arr.add(9); arr.add(5); arr.add(7); arr.add(1);
        checkSort(arr1);
        checkSort(arr);

        List<String> list = new LinkedList<>()
        list.add("Geeks");
        list.add("for");
        list.add("geeks");
        list.add("GeeksforGeeks");

        Iterator<Integer>
    }

    public static <T extends  IPerson> void logAdding(Map set, Class clasz, int size)throws  Exception{
        Instant startAdd = Instant.now();
        for(int i = 0; i < size; i++){
            Constructor c = clasz.getConstructor(String.class, int.class);
            set.put((IPerson)c.newInstance("p" + i, i), i);
        }

        Instant stopAdd = Instant.now();
        System.out.println("Time to logAdd: " + Duration.between(startAdd, stopAdd));
    }

    public static void logSearching(Map set, IPerson p){
        Instant startSearch = Instant.now();
        System.out.println("Searched value is: " + set.get(p));
        Instant stopSearch = Instant.now();
        System.out.println("Time to logSearch: " + Duration.between(startSearch, stopSearch));

    }

    public static void determineLeaders(int[] list, int n){
        for(int i = 0; i < n; i++){
            Integer maxx = list[i];
            for(int j = i; j < n; j++){
                if(list[j] > maxx){
                    maxx = list[j];
                    break;
                }
            }

            if(maxx.equals(list[i])){
                System.out.println(list[i] + " ");
            }
        }
    }

    public static void PascalSum(int size){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList< ArrayList<Integer> > mat = new ArrayList<>();
        list.add(1);
        mat.add(list);

        for(int i = 1; i < 10; i++){
            ArrayList<Integer> list2 = new ArrayList<>();
            list2.add(1);

            for(int j = 0; j < list.size() - 1; j++){
                list2.add(list.get(j) + list.get(j+1));
            }
            list2.add(1);
            mat.add(list2);
            list = list2;
        }

        for(int i = 0; i < 10; i++){

            for(int j = 0; j < mat.get(i).size(); j++){
                System.out.print(mat.get(i).get(j) + " ");
            }
            System.out.print("\n");
        }
    }

    public static void BellsTriangle(int size){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList< ArrayList<Integer> > mat = new ArrayList<>();
        list.add(1);
        mat.add(list);

        for(int i = 1; i < size; i++){
            ArrayList<Integer> list2 = new ArrayList<>();
            list2.add(list.get(list.size()-1));

            for(int j = 0; j < list.size(); j++){
                list2.add(list.get(j) + list2.get(j));
            }

            mat.add(list2);
            list = list2;
        }

        for(int i = 0; i < 10; i++){

            for(int j = 0; j < mat.get(i).size(); j++){
                System.out.print(mat.get(i).get(j) + " ");
            }
            System.out.print("\n");
        }
    }

    public static ArrayList<Integer> Interclasare(ArrayList<Integer> arr1, ArrayList<Integer> arr2) throws Exception{

        int i = 0;
        int j = 0;

        ArrayList<Integer> merged = new ArrayList<>();
        int k = 0;
        while(i < arr1.size() & j < arr2.size()){
            Integer val = arr1.get(i);
            Integer val2 = arr2.get(j);
            if(val < val2){
                merged.add(val);
                i++;
            }
            else {
                merged.add(val2);
                j++;
            }
        }
        while(i < arr1.size()){
            merged.add(arr1.get(i));
            i++;
        }

        while(j < arr2.size()){
            merged.add(arr2.get(j));
            j++;
        }

        return merged;
    }

    public static void leftRight(ArrayList<Integer> l, int left, int right){
        for(int i = left; i <= right; i++){
            System.out.print(l.get(i) + " ");
        }
    }

    public static void upDown(ArrayList<ArrayList<Integer>> list, int left, int right, int up, int down){
        for(int i = up; i <= down; i++){
            System.out.print(list.get(i).get(right)+ " ");
        }
    }

    public static void rightLeft(ArrayList<Integer> l, int left, int right){
        for(int i = right; i >= left; i--){
            System.out.print(l.get(i) + " ");
        }
    }

    public static void downUp(ArrayList<ArrayList<Integer>> list, int left, int right, int up, int down){
        for(int i = down; i > up; i--){
            System.out.print(list.get(i).get(left) + " ");
        }
    }

    public static void spiralTraverse(ArrayList<ArrayList<Integer>> list){
        int i = 0, size = list.size(), j = size;
        while(i <= j){
            leftRight(list.get(i), i, j-1);
            //System.out.println("Done LR");
            i++;
            if(i <= j){
                upDown(list, i, j-1, i, j-1);
               // System.out.println("DONE UD");
                j--;
                if(i <= j){
                    rightLeft(list.get(j), i-1, j-1);
                    //System.out.println("DONE RL");
                    downUp(list, i-1, j,i, j);
                    //System.out.println("DONE DU");
                }

            }
        }


    }

    public static void bubbleArray(List<Integer> list){

        for(int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){

                if(list.get(i) > list.get(j)){
                    swap(list, i, j);
                }
            }
        }
    }

    public static void swap(List<Integer> list, int left, int right){
        Integer aux = list.get(left);
        list.set(left, list.get(right));
        list.set(right, aux);

    }

    public static int partition(List<Integer> list, int left, int right){
        int iR = right;
        int loc = left - 1;
        for(int i = left; i < right; i++){
            if(list.get(i) < list.get(iR)){
                loc++;
                swap(list, i, loc);
            }
        }
        swap(list, loc + 1, iR);
        return loc;
    }
    public static void quickSort(List<Integer> list, int left, int right){
        if(left >= 0 && left < right){
            Random rand = new Random();
            int pivot = left + rand.nextInt(right - left + 1);
            swap(list, pivot, right);
            pivot = partition(list, left, right);
           // System.out.print(pivot+ " ");
            quickSort(list, left, pivot - 1);
            quickSort(list, pivot, right);
        }
    }

    public static void checkSort(List<Integer> list){

        Instant start = Instant.now();
        //bubbleArray(list);
        quickSort(list, 0, list.size() - 1);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }
        Instant stop = Instant.now();
        Duration duration = Duration.between(start, stop);
        System.out.println(duration);

    }
}
