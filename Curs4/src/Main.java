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

        ArrayList<Integer> arr1 = new ArrayList<>();
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
}
