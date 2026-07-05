import java.util.*;
import java.io.*;
//NOTES: ARRAYS DO NOT OVERRIDE .equals() SO BEHAVES SAME AS this == obj default code. SO USE Arrays.equals() which is O(n) linear time.
//WAS EXTREMELY CLOSE TO SOLUTION BUT USED AI TO REWRITE MY CODE EASIER WITH NO EDGE CASES. THIS IS THE CODE THAT CAME FROM AI INFLUENCE (self-coded in my own way though)
        /*
        boolean[] newWinners = new boolean[3]; //All false
            leadOutput = findLeadOutput(cowOutputs);
            for (int j = 0; j < 3; j++){
                if (cowOutputs[j] == leadOutput){
                    newWinners[j] = true;

                }
            }
            if (!Arrays.equals(currentWinners, newWinners)) totalUpdates++; //important basic logic  
                currentWinners = newWinners;
         */
/*MAKE SURE FOR SIMULATION QUESTIONS YOU ACT IF YOU WERE THE PERSON (Ex. Comparing old winners to new winners to see if display has to be changed)
 Just like the "Important basic logic" comment line. 
*/     
public class MilkMeasurement {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("measurement.out"));
        StringTokenizer st;
        int n = Integer.parseInt(r.readLine());

        int totalUpdates = 0; // Winner = highest output (not cumulative)

        int maxDays = 1; // days >= 1
        int[] arrMild = new int[100]; // arr[day] = change on day
        int[] arrElsie = new int[100];
        int[] arrBessie = new int[100];
        int[][] cows = { arrMild, arrElsie, arrBessie }; // Can update later in the code since it holds references
                                                         // (memory pointers) of the int[] arary objects rather than
                                                         // making a copy
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(r.readLine());
            int day = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int change = Integer.parseInt(st.nextToken());
            if (day > maxDays) {
                maxDays = day;
            }
            if (name.equals("Mildred")) {
                arrMild[day-1] = change;
            } else if (name.equals("Bessie")) {
                arrBessie[day-1] = change;
            } else if (name.equals("Elsie")) {
                arrElsie[day-1] = change;
            }
        }
        for (int[] cow : cows) {
            updateToOutputs(cow);
        }

        //DEBUGGING PRINTS
        System.out.print("MILDRED: [");
        for (int i = 0; i < maxDays; i++){
            System.out.print(arrMild[i]+", ");
        }
        System.out.println("]");
         
        System.out.print("Elsie: [");
        for (int i = 0; i < maxDays; i++){
            System.out.print(arrElsie[i]+", ");
        }
        System.out.println("]");
        
        System.out.println("MAX DAYS: "+maxDays);
        System.out.print("BESSIE: [");
        for (int i = 0; i < maxDays; i++){
            System.out.print(arrBessie[i]+", ");
        }
        System.out.println("]");
        
        
        System.out.println();

        //MUST BE ALL TRUE IN THE BEGINNING BECAUSE FIRST DAY OF DISPLAYING DOES NOT COUNT AS AN "ADJUSTMENT TO HIS MOTIVATIONAL DISPLAY"
        boolean[] currentWinners = {true, true, true}; // 0 = Mildred, 1 = Elsie, 2 = Bessie
        System.out.println("STARTING WINNERS: "+Arrays.toString(currentWinners));
        int leadOutput = 7;
        int soloLeadIndex = 0;
        for (int i = 0; i < maxDays; i++) {
            int MildredOut = arrMild[i];
            int ElsieOut = arrElsie[i];
            int BessieOut = arrBessie[i];
            int[] cowOutputs = {MildredOut, ElsieOut, BessieOut};

            //calculateUpdates() Logic

            boolean[] newWinners = new boolean[3]; //All false
            leadOutput = findLeadOutput(cowOutputs);
            for (int j = 0; j < 3; j++){
                if (cowOutputs[j] == leadOutput){
                    newWinners[j] = true;

                }
            }
            if (!Arrays.equals(currentWinners, newWinners)) totalUpdates++;
           currentWinners = newWinners;
        }
        pw.println(totalUpdates);
        pw.close();
    }
    public static int findLeadOutput(int[] cowOutputs){
        return Math.max(cowOutputs[0], Math.max(cowOutputs[1], cowOutputs[2]));
        }
    public static int numWinners(boolean[] currentWinners){
        int count = 0;
        for (boolean value : currentWinners){
            if (value) count++;
        }
        return count;
    }
    public static void updateWinners(boolean[] currentWinners, int newWinnerIndex){
        for (int i = 0; i < currentWinners.length; i++){
            if (i == newWinnerIndex){
                currentWinners[i] = true;
            } else{
                currentWinners[i] = false;
            }
        }
    }

    public static void updateToOutputs(int[] cowChanges) {
        int output = 7;
        for (int i = 0; i < cowChanges.length; i++) {
            output += cowChanges[i];
            cowChanges[i] = output;
        }
    }
}
