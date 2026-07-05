import java.io.*;
import java.util.*;

public class CowGymnastics {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter pw = new PrintWriter("gymnastics.out");

        StringTokenizer st = new StringTokenizer(r.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        if (k == 1){
            pw.println(n * (n - 1) / 2);
            pw.close();
            return;
        }
        int[][] arr = new int[k][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(r.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        HashSet<String> set1 = new HashSet<>(); // All iterations of row 1 is stored
        HashSet<String> set2 = new HashSet<>(); // one set for prev
        for (int i = 0; i < k; i++) { // looping through 2d array
            for (int j = 0; j < n; j++) { // looping through array
                for (int t = j + 1; t < n; t++) {//looping through every possible pair of array
                    String combo = Arrays.toString(new int[] {arr[i][j], arr[i][t]});
                    System.out.print(combo + ",  ");
                    if (count == 0) {
                        set1.add(combo);
                        System.out.println("can you see me?");
                    } else {
                        if (set1.contains(combo)) {
                            System.out.println("adding to set2...");
                            set2.add(combo);
                        }
                    }
                    
                }
                System.out.println();
            }
            if (count == 0){
                //System.out.println("SIZE OF SET1 ON FIRST ITERATION: "+set1.size());
            }else {
                System.out.println(set2.size());
                if (i + 1 == k) break; //checks for last iteration
                set1.clear();
                set1 = new HashSet<>(set2);
                set2.clear();   
            }
            count++;
        }

        pw.println(set2.size());
        pw.close();
    }
}
