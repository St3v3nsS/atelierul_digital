
public class Main {

    public static <T extends Comparable> boolean isReversed(T[] list){
        IArrayIterator<T> socksIterator = new ArrayIterator<>(list);
        T first = null, second;
        if(socksIterator.hasNext()){
            first = socksIterator.next();
        }
        while(socksIterator.hasNext()){
            second = socksIterator.next();
            int big = first.compareTo(second);
            if(big < 0){
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable> boolean isSorted(T[] list){
        IArrayIterator<T> socksIterator = new ArrayIterator<>(list);
        T first = null, second;
        if(socksIterator.hasNext()){
            first = socksIterator.next();
        }
        while(socksIterator.hasNext()){
            second = socksIterator.next();
            int big = first.compareTo(second);
            if(big > 0){
                return false;
            }
            first = second;
        }
        return true;
    }

    public static <T extends Comparable> boolean binarySearch(T[] list, T value) throws ListNotSortedException{

        boolean asc = isSorted(list), desc = isReversed(list);
        //System.out.println(asc + " " + desc);
        if(asc){
            int left = 0, right = list.length;
            while(left < right) {
                int mij = (left + right) / 2;
                if (list[mij].equals(value)) {
                    return true;
                } else {
                    int big = value.compareTo(list[mij]);
                    if (big <= 0) {
                        right = mij;
                    } else {
                        left = mij + 1;
                    }
                }
            }
        }
        else if(desc){
            int left = 0, right = list.length;
            while(left < right) {
                int mij = (left + right) / 2;
                if (list[mij].equals(value)) {
                    return true;
                } else {
                    int big = value.compareTo(list[mij]);
                    if (big < 0) {
                        left = mij+1;
                    } else {
                        right = mij;
                    }
                }
            }
        }else if(!asc && !desc){
            throw new ListNotSortedException();
        }
        return false;
    }

    public static void main(String[] args) {
       /* Sock blueSock = new Sock(10, "blue");
        Sock redSock = new Sock(10, "red");
        Glove yellowGlove = new Glove(15, "yellow");
        Glove bigYellowGlove = new Glove(17, "yellow");

        Sock left = new Sock(10, "green");
        Sock right = new Sock(10, "green");

        //Pair<Sock> socksPair04 = new Pair<>(left, right);

        Pair socksPair01 = new Pair(blueSock, yellowGlove);
        //Pair<Sock> socksPair02 = new Pair<>(blueSock, yellowGlove);
        Pair<Sock> socksPair03 = new Pair<>(blueSock, redSock);
        Pair<Glove> glovesPair01 = new Pair<>(yellowGlove, bigYellowGlove);

       // System.out.println(socksPair04.getLeft() + " " + socksPair04.getRight());
        Sock[] socks = new Sock[10];
        Glove[] gloves = new Glove[10];
        for(int i=0;i<10;i++) {
            socks[i] = new Sock(i, "blue");
            gloves[i] = new Glove(i, "maroon");
        }

        IArrayIterator<Sock> socksIterator = new ArrayIterator<>(socks);
        while (socksIterator.hasNext()) {
            System.out.println(socksIterator.next());
        }
        IArrayIterator<Glove> glovesIterator = new ArrayIterator<>(gloves);
        while (glovesIterator.hasNext()) {
            System.out.println(glovesIterator.next());
        }
        */
        Integer[] list01 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] list02 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("\n" + i + ". ");
                System.out.println(binarySearch(list01, i) == true);
                System.out.println(binarySearch(list02, i) == true);

            }

        }
        catch (ListNotSortedException e){
            System.err.println(e);
        }

    }
}
