
/**
 * The prisoner's dilemma
 *
 * @author Solomon Emet
 * @version 11/8/2021
 */

//keyboard
import java.util.Scanner;

//random number generator
import java.util.Random;

public class theGame
{
    //for keyboard reading
    String command;
    
    //setting up variables
    public boolean noDontGo = true;
    
    public int rounds = 0;
    
    public int youScore = 0;
    
    public int theyScore = 0;
    
    public int numClamups = 0;
    
    public int numSnitches = 0;
    
    public int moves[];
    
    //for keyboard reading
    Scanner keyboard = new Scanner(System.in);
    
    //for random number generation
    Random random = new Random();
    
    /**
     * Constructor for objects of class theGame
     */
    public theGame()
    {
        //intro text
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
                //turns the command into an int and starts the game
                rounds = Integer.parseInt(command);
                game();
            } else {
                switch(command){
                    case "random":
                    //setting the number of rounds to a random number
                    rounds = random.ints(1,(21)).findFirst().getAsInt();
                    game();
                    break;
                    
                    case "break out":
                    //easter egg
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
        
        numClamups = 0;
    
        numSnitches = 0;
        
        int actions[] = new int[5];
        
        System.out.println("Let's play!");
        System.out.println("If you both keep quiet, you'll both get one point. If you screw over your buddy, you'll get two points and they'll get negative five.");
        System.out.println("If your buddy screws you over, they'll get two points and you'll get negative five. If you screw each other over you both get negative three.");
        System.out.println("Also, the computer will learn from your actions in intentionally unspecified ways.");
        System.out.println("The game will run for a number of rounds. Whoever has the most points at the end will win.");
        for(int i = 0; i < rounds; i++){
            System.out.println("Do you want to snitch or keep quiet?");
            System.out.println("(Type \"snitch\" or \"s\" to snitch and \"clamup\" or \"c\" to keep quiet.)");
            command = keyboard.nextLine().toLowerCase();
            switch(command){
                case "snitch":
                
                case "s":
                for(int x = 0; actions[x] != 0; x++){
                    if(actions[x] == 0){
                        //
                    }
                }
                break;
                
                case "clamup":
                
                case "c":
                actions[1] = 2;
                break;
                
                case "quit":
                
                case "q":
                System.out.println("You decide to use that phone call that they gave you. You call your lawyer, and he's able to make the cops stop interrogating you.");
                i = rounds;
                break;
                
                default:
                System.out.println("That's neither \"snitch\" nor \"s\" nor \"clamup\" nor \"c\". Are you dumb?");
                i--;
                break;
            }
        }
        System.out.println("The cops are done interrogating you. In the end, they got enough evidence to put you away for " + (0 - youScore) + " year(s), and your buddy for " + (0 - theyScore) + " year(s).");
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
