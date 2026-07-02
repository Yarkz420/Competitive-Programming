import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MilkPails{
    public static void main(String[] args) throws IOException{
        //int b = System.in.read(); //Only reads the FIRST byte (character)
        BufferedReader r = new BufferedReader(new FileReader("pails.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("pails.out"));
            
        StringTokenizer st = new StringTokenizer(r.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int maxDivY= m / y;
        
        int max = 0;
        for (int i = 0; i <= maxDivY; i++){
            int milk_left = (m - y * i) / x;
            int totalUsed = y * i + milk_left * x;
            if (totalUsed > max){
                max= totalUsed;
            }
        }
        pw.println(max);
        pw.close();
    }
}