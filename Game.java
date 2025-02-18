import java.util.ArrayList;
import java.util.Scanner;
import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.Timeline;


public class Game extends VBox{

    public Game(){
        

        Timeline holdFor = new Timeline();
        KeyFrame HFAlarm = new KeyFrame(Duration.millis(1000), event -> promptUser());
        holdFor.getKeyFrames().add(HFAlarm);

        Timeline userTime = new Timeline();
        KeyFrame UTAlarm = new KeyFrame(Duration.millis(1000), event -> collectUserAnswer());
        userTime.getKeyFrames().add(UTAlarm);
        

        setAlignment(Pos.CENTER);


        Label pattern = new Label();

        TextField answer = new TextField();

        getChildren().addAll(pattern, answer);
        

        
        // setting up scanner
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter mode: 1, 2, or 3: ");
 
        //setting up variables
        int mode = sc.nextInt();
        String garbString = sc.nextLine();
        int range = 26;
       
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
             
            }
            else{
                
            }
            randNum = (int)(Math.random() *range);
            // switch based on which mode was picked
            switch(mode){
                case 1:
                    correct = true;
                    achar.add((char) (randNum + 97));

                    pattern.setText(achar.toString());

                    holdFor.play();
                    System.out.print(" ");
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

                    userTime.play();
                    System.out.print(" ");


                    break;
                case 2:
                    correct = true;
                    achar.add((char) (randNum + 48));
                    for(int i = 0; i < achar.size()  ; i++){
                        System.out.print(achar.get(i));
                    }
                    holdFor.play();
                    System.out.print(" ");
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

                    
                    break;
                case 3:
                    System.out.println(" + " + randNum);
                    sum += randNum;
                    holdFor.play();
                    System.out.print(" ");
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
                    System.out.print(" ");
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
            userTime.play();
            System.out.print(" ");
            userTime.play();
        
        }
        if(points >= 100){
            System.out.print(" ");
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
    void promptUser(){

    }
    void collectUserAnswer(){

    }
}
