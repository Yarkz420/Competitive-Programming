import java.io.*;
import java.util.*;
public class BlockGame {
    final static int aValue = (int) 'a';
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("blocks.out"));
        StringTokenizer st;

        int n = Integer.parseInt(r.readLine());
  
        int[] word1chars = new int[26]; // reused each iteration; methods must modify in-place (void) for this to actually avoid allocations, so makes no diff in this case
        int[] word2chars = new int[26]; // reused each iteration; methods must modify in-place (void) for this to actually avoid allocations, so makes no diff in this case
        int[] answer = new int[26];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(r.readLine());
            String word1 = st.nextToken();
            String word2 = st.nextToken();
        
            word1chars = convertLetters(word1);
            word2chars = convertLetters(word2);
            //System.out.println("WORDS: "+str2d[i][0] + ", "+str2d[i][1]);
            //System.out.println("MERGED: \n"+Arrays.toString(mergeSides(word1chars, word2chars)));
            int[] mergedBlock = mergeSides(word1chars, word2chars);
            answer = mergeBlocks(answer, mergedBlock);

            
        }
        for (int num : answer){
            pw.println(num);
        }
        pw.close();
        
        
    }
    public static int[] convertLetters(String word){
        int[] result = new int[26];
        for (int i = 0; i < word.length(); i++){
            result[word.charAt(i)-aValue] += 1; 
        }
        return result;
    }
    public static int[] mergeSides(int[] arr1, int[] arr2){
        int[] result = new int[26];
        for (int i = 0; i < arr1.length; i++){
            result[i] = Math.max(arr1[i], arr2[i]);
        }
        return result;
    }
    public static int[] mergeBlocks(int[] arr1, int[] arr2){
        int[] result = new int[26];
        for (int i = 0; i < arr1.length; i++){ //always 26
            result[i] = arr1[i] + arr2[i];
        }
        return result;
    }
}
