import java.util.*;
import java.io.*;
public class SpeedingTicket {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("speeding.out"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] speedLimit = new int[100];
        int counter = 0;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(r.readLine());
            int segmentLength = Integer.parseInt(st.nextToken());
            int segmentSpeed = Integer.parseInt(st.nextToken());
            for (int j = 0; j < segmentLength; j++){
                speedLimit[counter] = segmentSpeed;
                //System.out.println("Hello: "+j);
                counter++;
            }
        }
        //System.out.println(Arrays.toString(speedLimit));
        int distanceTraveled = 0;
        int maxOverLimit = 0;
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(r.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for (int j = 0; j < length; j++){
                if (speed - speedLimit[distanceTraveled] > maxOverLimit){
                    maxOverLimit = speed - speedLimit[distanceTraveled];
                    //System.out.println(maxOverLimit);
                }
                distanceTraveled++;
            }
        }
        pw.println(maxOverLimit);
        pw.close();
    }
}
