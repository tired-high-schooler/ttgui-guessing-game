//imports
import java.util.Scanner;
import java.util.ArrayList;

//main class
class Main{
    public static void main(String[] args) throws InterruptedException{

        // setting up scanner
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter mode: 1, 2, or 3: ");
 
        //setting up variables
        int mode = sc.nextInt();
        String garbString = sc.nextLine();
        int range = 26;
        int timeMod;
        int randNum;
        int points = 0;
        //responce in the form of a string or char
        String responceC;
        //responce in the form of integer
        int responceI;
        boolean running;
        boolean correct;
        //digits or characters
        String guessingUnits;
        int roundPoints = 0;
        int sum = 0;

        // setting up array list for storage of accumulating characters
        ArrayList<Character> achar = new ArrayList<Character>();
        
        //asking user for mode and confirming that they picked a valid mode
        if(mode >= 1 && mode <= 3){
            running = true;
        }
        else{
            running = false;
            System.exit(0);
        }
        // setting up variables based on mode
        switch(mode){
            case 1:
                range = 26;
                guessingUnits = "character";
                break;
            case 2:
                range = 10;
                guessingUnits = "digit";
                break;
            case 3:
                range = 100;
                guessingUnits = "digit";
                System.out.print(0);
                break;
            default:
                guessingUnits = "error";
                System.exit(0);
                break;
        }
    
        // main loop
        while(running && points < 100 && points > -20){
            // reseting variables after loop
            roundPoints = 0;
            correct = false;
            if(points >= 50){
                timeMod = (int)(Math.random() * 900) + 100;
            }
            else{
                timeMod = 1000;
            }
            randNum = (int)(Math.random() *range);
            // switch based on which mode was picked
            switch(mode){
                case 1:
                    correct = true;
                    achar.add((char) (randNum + 97));
                    for(int i = 0; i < achar.size()  ; i++){
                        System.out.print(achar.get(i));
                    }
                    Thread.sleep(timeMod);
                    System.out.print("\033[2J\033[H");
                    System.out.println("repeat: ");
                    responceC = sc.nextLine();
                   
                    if (responceC.length() != achar.size()){
                        correct = false;
                    }
                    else{
                        for(int i = 0; i + 1 <= achar.size(); i++){
                            if(achar.get(i) != responceC.charAt(i)){
                                correct = false;
                            }
                        }
                    }
                    if(correct){
                        roundPoints += 10;
                    }
                    else{
                        roundPoints -= 5;
                    }

                    Thread.sleep(1000);
                    System.out.print("\033[2J\033[H");


                    break;
                case 2:
                    correct = true;
                    achar.add((char) (randNum + 48));
                    for(int i = 0; i < achar.size()  ; i++){
                        System.out.print(achar.get(i));
                    }
                    Thread.sleep(timeMod);
                    System.out.print("\033[2J\033[H");
                    System.out.println("repeat: ");
                    responceC = sc.nextLine();
                
                    if (responceC.length() != achar.size()){
                        correct = false;
                    }
                    else{
                        for(int i = 0; i + 1 <= achar.size(); i++){
                            if(achar.get(i) != responceC.charAt(i)){
                                correct = false;
                            }
                        }
                    }
                    if(correct){
                        roundPoints += 5;
                    }
                    else{
                        roundPoints -= 5;
                    }

                    Thread.sleep(1000);
                    System.out.print("\033[2J\033[H");
                    break;
                case 3:
                    System.out.println(" + " + randNum);
                    sum += randNum;
                    Thread.sleep(timeMod);
                    System.out.print("\033[2J\033[H");
                    System.out.println("answer: ");
                    responceI = sc.nextInt();
                    if(responceI == sum){
                        correct = true;
                    }
                    if(correct){
                        roundPoints += 15;
                    }
                    else{
                        roundPoints -= 5;
                    }
                    System.out.print("\033[2J\033[H");
                    break;

                default:
                        System.exit(0);
                        break;
                
            }
            points += roundPoints;
            if(correct){
                System.out.println("Correct!");
            }
            else{
                System.out.println("failed");
            }
            System.out.println("you got: " + roundPoints);
            System.out.println("total points: " + points);
            Thread.sleep(1000);
            System.out.print("\033[2J\033[H");

            Thread.sleep(1000);
        }
        if(points >= 100){
            System.out.print("\033[2J\033[H");
            System.out.println("Victory");
            // nested loop to check if mode was a compatible one with the statement
            if(mode != 3){
                System.out.println("you just remembered a " + achar.size() + " " + guessingUnits + " sequnce!");
            }
            
        }
        else{
            System.out.println("Game Over.");
        }
    }
}


