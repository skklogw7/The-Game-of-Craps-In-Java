////////////////////////////////////////////////////////////////////////////////////////////////////
// Name: Kurt Schuepfer
// Date: 11/01/15

/** This program plays the game of craps */
////////////////////////////////////////////////////////////////////////////////////////////////////


import java.util.Scanner;

public class CrapsJava{
   
   //Asks user to enter a number of craps games to play. Prints the results and summary stats.
   public static void main (String[] args) {
      
      System.out.print("How many rounds of craps do you want to play?");
      Scanner keyboard = new Scanner (System.in);
      int numRounds = keyboard.nextInt();
      
      while (numRounds < 1) {
         System.out.print("Enter a positive number please: ");
         numRounds = keyboard.nextInt();
      }
      
      int winCount = 0;
      for (int i = 1; i <= numRounds; i++) {
         System.out.print("Round #" + i + ": ");
         if (craps() == true) {
            System.out.println(" (win)");
            winCount++;
         }
         else {
            System.out.println(" (lose)");
         }
      }
      
      double winPercentage = (double) winCount/(double)numRounds*100;
      
      System.out.println("------------------------------");
      System.out.printf("Wins: " + winCount + " out of " + numRounds + " (");
      System.out.printf("%.1f", winPercentage);
      System.out.println("%)");
      
   }
   
   //Method rolls two dice and returns their sum
   public static int rollDice(){
      int roll1 = (int) (Math.random() * 6) + 1;
      int roll2 = (int) (Math.random() * 6) + 1;
      int sum = roll1 + roll2;
      
      return sum;
      
   }
   
   //Method plays a game of craps and prints the results
   public static boolean craps(){
      boolean result = false;
      int firstRoll = rollDice();
      int nextRoll = 0;
      int rollCount = 1;
      
      
      if (firstRoll == 7 || firstRoll == 11) {
         System.out.print(firstRoll);
         result = true;
      } 
      
      else if (firstRoll == 2 || firstRoll == 3 || firstRoll == 12) {
         System.out.print(firstRoll);
         result = false;
      }     
      
      else {
         System.out.print(firstRoll);
         while ((firstRoll != nextRoll) && (nextRoll != 7)) {
            nextRoll = rollDice();
            rollCount++;
            System.out.print(" " + nextRoll);
            
            if (nextRoll == 7) {
               result = false;
            }
            
            if (nextRoll == firstRoll) {
               result = true;
            }
         }
         
      }
         
      return result;
   }
   
   
}
