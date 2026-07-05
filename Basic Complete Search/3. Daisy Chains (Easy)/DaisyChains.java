import java.io.*;
import java.util.*;

public class DaisyChains {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int n = Integer.parseInt(r.readLine());

        StringTokenizer st = new StringTokenizer(r.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        /*int total = n;
        for (int i = 0; i < n; i++){
            double sum = nums[i];
            for (int j = i + 1; j < n; j++){ //You can create a hashset for every loop to store what values have been seen. This will change this code from O(n^3) to O(n^2)
                //System.out.println("HELLO: i="+i+", j="+j);
                sum += nums[j];
      
                double avg = sum / (j-i+1);
                if (avg != (int) avg)continue;

                for (int k = i; k <= j; k++){
                    if (nums[k] == avg){
                        total += 1;
                        break;
                    }
                }
                
            }
        }*/


         int total = n;

        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            boolean[] seen = new boolean[1001];
            seen[nums[i]] = true;
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                seen[nums[j]] = true;

                int length = j - i + 1;

                if (sum % length == 0) {
                    int avg = sum / length;

                    if (seen[avg]) {
                        total++;
                    }
                }
            }
        }
      
        System.out.println(total);
    }
}
