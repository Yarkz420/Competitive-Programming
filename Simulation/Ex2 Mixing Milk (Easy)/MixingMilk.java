import java.util.*;
import java.io.*;
public class MixingMilk {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("mixmilk.out"));
        
        int[] capacities = new int[3]; //{10, 11, 12}
        int[] buckets = new int[3]; //{3, 4, 5}
        for (int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(r.readLine());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            capacities[i] = c;
            buckets[i] = m;
        }


        for (int i = 0; i < 100; i++){ //DONT USE I,  USE count instead
            int indexA = i % 3;
            int indexB = (i + 1) % 3;
            int a = buckets[indexA]; //pour from a -> b
            int b = buckets[indexB];
            int capB = capacities[indexB];

            int availableB = capB - b;
            /* Longer code: if (availableB >= a){
                buckets[indexB] += a;
                buckets[indexA] -= a;
            } else { //availableB < a
                buckets[indexB] += availableB;
                buckets[indexA] -= availableB;
            } */
            //Simpler code (below)
            int amount = Math.min(a, availableB);
            buckets[indexB] += amount;
            buckets[indexA] -= amount;
            System.out.println(Arrays.toString(buckets));
        }
        
        for (int num : buckets){
            pw.println(num);
        }
        pw.close();
    }
}
