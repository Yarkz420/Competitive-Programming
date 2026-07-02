
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DiamondCollector {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter pw = new PrintWriter("diamond.out");

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int prev = Integer.MIN_VALUE;
        int count = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(r.readLine());
        }
        Arrays.sort(arr);

        int answer = 1;
        for (int i = 0; i < arr.length; i++){
            int currentLength = 1;
            for (int j = i + 1; j  <arr.length; j++){
                if (Math.abs(arr[i] - arr[j]) <= k){
                    currentLength += 1;
                }
            }
            if (currentLength > answer){
                answer = currentLength;
            } else{
                break;
            }
        }
        
        answer = maxDiamonds(arr, k, n);
        pw.println(answer);

        pw.close();
    }

    public static int maxDiamonds(int[] nums, int k, int n){ //Given nums is already sorted
        int left = 0;
    int answer = 1;
    
    for (int right = 0; right < n; right++) {
        // shrink left side until window is valid
        while (nums[right] - nums[left] > k) {
            left++;
        }
        // window from left to right is now valid
        answer = Math.max(answer, right - left + 1);
    }
    return answer;
    }
}
