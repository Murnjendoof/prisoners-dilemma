
/**
 * The prisoner's dilemma
 *
 * @author Solomon Emet
 * @version 9/5/2021
 */

//keyboard
import java.util.Scanner;

//random number generator
import java.util.Random;

public class theGame
{
    String command;
    
    public boolean noDontGo = true;
    
    public int rounds = 0;
    
    public int youScore = 0;
    
    public int theyScore = 0;
    
    public int numClamups = 0;
    
    public int numSnitches = 0;
    
    Scanner keyboard = new Scanner(System.in);
    
    /**
     * Constructor for objects of class theGame
     */
    public theGame()
    {
        Random random = new Random();
        
        System.out.println("You've been arrested for tax evasion.");
        System.out.println("Fortunately for you, the cops only have enough evidence to put you away for littering.");
        System.out.println("Even so, it's enough to put you away for two years.");
        System.out.println("The cops are interrogating you and your accomplice seperately.");
        System.out.println("If you both keep quiet, you'll both get the short sentence.");
        System.out.println("If you both snitch on each other, you'll both get a huge honkin' sentence.");
        System.out.println("But if you snitch, and your accomplice keeps quiet, the cops will let you go free while giving your buddy life.");
        System.out.println("And if you keep quiet, but your accomplice snitches, they'll go free and you'll get life.");
        System.out.println("This is the prisoner's dilemma.");
        System.out.println();
        while(noDontGo){
            System.out.println("How many rounds do you want to play?");
            System.out.println("(If you want to play a random number of rounds, type \"random\".)");
            System.out.println("(Or, if you want to quit, type \"quit\".)");
            command = keyboard.nextLine().toLowerCase();
            if(isNumeric(command) == true && !command.contains("-") && !command.contains(".")){
                rounds = Integer.parseInt(command);
                game();
            } else {
                switch(command){
                    case "random":
                    rounds = random.ints(1,(21)).findFirst().getAsInt();
                    game();
                    break;
                    
                    case "break out":
                    System.out.println("You bust out of prison. Unfortunately, once you're out, your old habit takes over and you find yourself being arrested for tax evasion, along with an accomplice.");
                    break;
                    
                    case "quit":
                    System.out.println("Good riddance.");
                    noDontGo = false;
                    break;
                    
                    default:
                    System.out.println("That is neither a whole number nor the word \"random\". Keep trying, I'm sure you'll get there eventually.");
                    break;
                }
            }
        }
    }

    /**
     * I used this code from java2blog.com
     *
     * @It returns true if the string is a number
     */
    public static boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }
    
    /**
     * This is the game
     *
     * @It's the entire game
     */
    public void game() {
        youScore = 0;
        
        theyScore = 0;
        
        System.out.println("Let's play!");
        System.out.println("If you both keep quiet, you'll both get one point. If you screw over your buddy, you'll get two points and they'll get negative five.");
        System.out.println("If your buddy screws you over, they'll get two points and you'll get negative five. If you screw each other over you both get negative three.");
        System.out.println("Also, the computer will learn from your actions in intentionally unspecified ways.");
        System.out.println("This game will be " + rounds + " rounds long. Whoever has the most points at the end will win.");
        for(int i = 0; i < rounds; i++){
            System.out.println("Do you want to snitch or keep quiet?");
            System.out.println("(Type \"snitch\" or \"s\" to snitch and \"clamup\" or \"c\" to keep quiet.)");
            command = keyboard.nextLine().toLowerCase();
            switch(command){
                case "snitch":
                
                case "s":
                System.out.println("You snitched, and your buddy...");
                if(numClamups > numSnitches){
                    System.out.println("Well, he kept his mouth shut. You jerk.");
                } else {
                    if(numClamups < numSnitches){
                        System.out.println("Well, he snitched.");
                    } else {
                        ;
                    }
                }
                break;
                
                case "clamup":
                
                case "c":
                System.out.println("You kept your mouth shut, and your buddy...");
                //PLACEHOLDER
                System.out.println("Well, for now, they snitched.");
                break;
                
                default:
                System.out.println("That's neither \"snitch\" nor \"s\" nor \"clamup\" nor \"c\". Are you dumb?");
                break;
            }
        }
        System.out.println("The cops are done interrogating you. In the end, they got enough evidence to put you away for " + youScore + " years, and your buddy for " + theyScore + " years.");
        if(youScore > theyScore){
            System.out.println("You win.");
        } else {
            if(youScore < theyScore){
                System.out.println("You lose.");
            } else {
                System.out.println("You tied. Somehow.");
            }
        }
        System.out.println();
    }
}
