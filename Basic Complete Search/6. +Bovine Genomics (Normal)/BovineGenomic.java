import java.util.*;

import javax.print.event.PrintEvent;

import java.io.*;

public class BovineGenomic{
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter pw = new PrintWriter("cownomics.out");

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        System.out.println(n + " "+m);
        
        char[][] charArr = new char[n * 2][m];
        for (int i = 0 ; i < n * 2; i++){
            String newLine = r.readLine();
            for (int j = 0; j < m; j++){
                charArr[i][j] = newLine.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++){
            HashSet<Character> set = new HashSet<>(); //boolean[] with size 4 is slightly more faster than using hashset since dataset is very
            boolean unique = true;
            for (int j = 0; j < n * 2; j++){
                if (j < n){ //Cows withjout spots
                    set.add(charArr[j][i]);
                } else{ //Cows with spots
                    if (set.contains(charArr[j][i])){
                        unique = false; //Overlap has occured
                        break;
                    }
                }
                System.out.println("i: "+i+", j: "+j);
            }
            set.clear();
            if (unique){ //This means there was no overlap between n cows WITH spots vs. n cows with NO spots
                count++;
            }
        }
        System.out.println("COUNT: "+count);
        pw.println(count);
        pw.close();
        
    }
    
}
