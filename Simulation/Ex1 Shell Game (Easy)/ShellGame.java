
import java.util.*;
import java.io.*;
public class ShellGame {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("shell.in"));
        PrintWriter pw = new PrintWriter("shell.out");
        StringTokenizer st;
        int n = Integer.parseInt(r.readLine());
        int[] shells = {1, 2, 3};
        int[] correct = new int[3]; 

            for (int i = 0; i < n; i++){
                st = new StringTokenizer(r.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int g = Integer.parseInt(st.nextToken()) - 1;
                swap(shells, a, b);
                correct[shells[g]-1]++;
            }
            
        
        //System.out.println(Arrays.toString(correct));
        pw.println(findMax(correct));
        pw.close();
    }
    public static int findMax(int[] arr){
        int max= arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
