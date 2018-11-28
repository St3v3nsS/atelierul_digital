package base;

import java.io.*;
import java.security.KeyStore;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void copy() throws IOException {
        Instant start = Instant.now();

        FileReader inputStream = null;
        FileWriter outputStream = null;
        try {
            inputStream = new FileReader("in.txt");
            outputStream = new FileWriter("out.txt");

            int c;
            while((c = inputStream.read()) != -1){
                outputStream.write(c);
            }
        }
        catch (FileNotFoundException ex){
            System.err.println("No file found!");
        }
        catch (IOException ex){
            System.err.println("File corrupted!\n");
        }
        finally {
            if(inputStream != null){
                inputStream.close();
            }
            if(outputStream != null){
                outputStream.close();
            }

        }


        Instant end = Instant.now();
        Duration duration = Duration.between(start,end);
        System.out.println(duration);
    }

    public static void copyWithBuffer() throws IOException {
        Instant start = Instant.now();

        BufferedReader inputStream = null;
        BufferedWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("in.txt"));
            outputStream = new BufferedWriter(new FileWriter("out1.txt"));

            int c;
            while((c = inputStream.read()) != -1){
                outputStream.write(c);
            }
        }
        finally {
            if(inputStream != null){
                inputStream.close();
            }
            if(outputStream != null){
                outputStream.close();
            }
        }

        Instant end = Instant.now();
        Duration duration = Duration.between(start,end);
        System.out.println(duration);
    }

    public static void readPoem() throws IOException{

        Scanner scanner = null;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader("poem.txt")));
            HashMap<String, Integer> hashMap = new HashMap<>();
            final String newline = System.getProperty("line.separator");

            final String regex = "[\\s@&.?$+\\-!'\\n,]+";
            scanner.useDelimiter(regex);

            while(scanner.hasNext()){

                String input = scanner.next();
                Integer integer = hashMap.get(input);
                if(integer == null){
                    hashMap.put(input, 1);
                }
                else{
                    Integer newVal = integer  +1;
                    hashMap.put(input, newVal);
                }

            }

            List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());
            list.sort(Map.Entry.comparingByValue());

            Map<String, Integer> result = new LinkedHashMap<>();

            for(Map.Entry<String, Integer> entry : list){
                result.put(entry.getKey(), entry.getValue());

            }

            List<String> allkeys = new ArrayList<String>(result.keySet());
            Collections.reverse(allkeys);

            int count = 0;
            System.out.println("\nHere are the top 10 most used words: \n");
            for( String str : allkeys ){
                if(count == 10){
                    break;
                }
                System.out.println((count +1) + ". " + str + " " + result.get(str));
                count++;
            }

        }
        finally {
           if(scanner != null){
               scanner.close();
           }
        }

    }

    public static void main(String[] args) {
	// write your code here
       /* try ( MyClosableResource resource = new MyClosableResource();){
            throw new Exception02("Error when doing work");
        }
        catch (Exception ex){
            System.err.println("Exception encountered: " +ex.toString());
            final Throwable[] suppresedExceptions = ex.getSuppressed();
            final int numSuppressed = suppresedExceptions.length;
            if(numSuppressed > 0){
                System.err.println("found" + numSuppressed + "suppresed ex: ");
                for(final Throwable exception: suppresedExceptions){
                    System.err.println("suppressed: " +exception.toString());
                }
            }
        }

        try{
            copy();
        }
        catch (IOException e){
            System.err.println("Err closing the files!");
        }


        try
        {
            copyWithBuffer();
        }
        catch (IOException e){
            System.err.println("Err closing the files");
        }
        */

        try
        {
            readPoem();
        }
        catch (IOException e){
            System.err.println("error");
        }

    }
}
