import java.util.*;
import java.io.*;

public class TeamTic {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("tttt.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("tttt.out"));
        int soloWins = 0;
        int teamWins = 0;

        char[][] board = new char[3][3];
        Set<String> pairSet = new HashSet<>(); // program to an interface, not an implementation. This way you can
                                               // change it later on if you need to. (Ex. TreeSet)
        boolean[] soloSeen = new boolean[26];
        for (int i = 0; i < 3; i++){
            String line = r.readLine();
            for (int j = 0; j < 3; j++){
                board[i][j] = line.charAt(j);
            }
        }
         char[][] lines = {
            board[0], board[1], board[2], //rows
            { board[0][0], board[1][0], board[2][0] },//column 1
            { board[0][1], board[1][1], board[2][1] },//column 2
            { board[0][2], board[1][2], board[2][2] },//column 3
            { board[0][0], board[1][1], board[2][2] },//diagonal 1
            { board[0][2], board[1][1], board[2][0] } //diagonal 2
        };

        
        for (char[] line : lines){
             char a = line[0];
            char b = line[1];
            char c = line[2];

            if (a == b && b == c) { // Solo wins for rows
                if (!soloSeen[a - (int) 'A']){
                    soloWins++;
                    soloSeen[a - (int) 'A'] = true;
                }

            } else if (!(isDistinct(a, b, c))) { // If all are NOT distinct = 2 must be same
                String pair = getSortedPair(a, b, c);
                if (!pairSet.contains(pair)){
                    teamWins++;
                    pairSet.add(pair);
                }
            
            }
        }
       
        pw.println(soloWins);
        pw.println(teamWins);
        pw.close();
    }

    public static String getSortedPair(char a, char b, char c) { // Precondition: Two chars must be the same
        if (a != b)
            return "" + Math.min(a, b) + Math.max(a, b);
        return "" + Math.min(a, c) + Math.max(a, c);
    }

    public static boolean isDistinct(char a, char b, char c) {
        return a != b && b != c && a != c;
    }
}
