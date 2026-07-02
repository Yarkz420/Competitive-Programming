import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MilkPails{
    public static void main(String[] args) throws IOException{
        //int b = System.in.read(); //Only reads the FIRST byte (character)
        //READING FROM TERINAL
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(r.readLine());
        System.out.println("Hello World");

        //READING FROM FILE
        BufferedReader r2 = new BufferedReader(new FileReader("pails.in"));
        PrintWriter pw2 = new PrintWriter(new FileWriter("pails.out"));
        
    }
}