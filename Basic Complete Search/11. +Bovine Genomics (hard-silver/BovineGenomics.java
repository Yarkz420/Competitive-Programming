
import java.io.*;
import java.util.*;

public class BovineGenomics {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter pw = new PrintWriter("cownomics.out");

        StringTokenizer st = new StringTokenizer(r.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //System.out.println("n: " + n + ", " + m);
        char[][] charArr = new char[m][n * 2]; // Reversing columns and rows. first three data per row is spotty and
                                               // last three per row is plain.
        for (int i = 0; i < n * 2; i++) { //
            String newLine = r.readLine();
            for (int j = 0; j < m; j++) {
                charArr[j][i] = newLine.charAt(j);
            }
        }

        for (char[] chars : charArr) {
            //System.out.println(Arrays.toString(chars));
        }
        System.out.println();

        int count = 0;
        for (int i = 0; i < m; i++) { // looping through rows
            char[] pos1 = charArr[i];
            for (int j = i + 1; j < m; j++) { // looping through 2nd row
                char[] pos2 = charArr[j];
                for (int k = j + 1; k < m; k++) { // looping through 3rd row
                    char[] pos3 = charArr[k];
                    //System.out.println("FOR COLUMN "+i+", "+j+", "+k);
                    count += loopRow(pos1, pos2, pos3, n);
                }
            }
        }

        pw.println(count);
        pw.close();
    }

    /* HashSet version
    public static int loopRow(char[] pos1, char[] pos2, char[] pos3, int n, int m) {
        // boolean[] seenArr = new boolean[n * m];
        HashSet set = new HashSet<>();
        char[][] charArr = { pos1, pos2, pos3 }; // Always size 3
        for (int i = 0; i < n; i++) { // i = column
            char[] spotty = new char[charArr.length];
            for (int j = 0; j < charArr.length; j++) { // 3 is
                spotty[j] = charArr[j][i]; // storing all spotty cows in spotty[] char array
            }
            String spottyGenome = new String(spotty);
            set.add(spottyGenome);
        }
        
        // Same loop repeated for plain cows;
        for (int i = n; i < n * 2; i++) {
            char[] plain = new char[charArr.length];
            for (int j = 0; j < charArr.length; j++) {
                plain[j] = charArr[j][i]; // storing all plain cows in plain[] char array
            }

            //System.out.println("THIS IS THE PLAIN ARRAY: "+Arrays.toString(plain));

            String plainGenome = new String(plain);
            if (set.contains(plainGenome)) {
                //System.out.println();
                return 0;
            }

        }
        //System.out.println();
        return 1;
    }*/

    public static int loopRow(char[] pos1, char[] pos2, char[] pos3, int n) {
        // boolean[] seenArr = new boolean[n * m];

        char[][] charArr = { pos1, pos2, pos3 }; // Always size 3
        boolean[] set = new boolean[64];
        for (int i = 0; i < n; i++) { // i = column
            char[] spotty = new char[charArr.length];
            for (int j = 0; j < charArr.length; j++) { // 3 is
                spotty[j] = charArr[j][i]; // storing all spotty cows in spotty[] char array
            }
            set[convertBase4(spotty)] = true;
        }
        
        // Same loop repeated for plain cows;
        for (int i = n; i < n * 2; i++) {
            char[] plain = new char[charArr.length];
            for (int j = 0; j < charArr.length; j++) {
                plain[j] = charArr[j][i]; // storing all plain cows in plain[] char array
            }

            //System.out.println("THIS IS THE PLAIN ARRAY: "+Arrays.toString(plain));
            if (set[convertBase4(plain)]) {
                //System.out.println();
                return 0;
            }

        }
        //System.out.println();
        return 1;
    }
    
    public static int convertBase4(char[] arr){
        int sum = 0;
        int[] weights = {16, 4, 1};

        for (int i = 0; i < arr.length; i++){ //A=3, C=2, G=1, T=0   arr.length is always 3
            if (arr[i] == 'A'){
                sum += 3 * weights[i];
            } else if (arr[i] == 'C'){
                sum += 2 * weights[i];
            } else if (arr[i] == 'G'){
                sum += 1 * weights[i];
            } else 
                sum += 0 * weights[i];
            
        }
        return sum;
    }
}
