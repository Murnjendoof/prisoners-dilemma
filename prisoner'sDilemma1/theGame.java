
/**
 * The prisoner's dilemma
 *
 * @author Solomon Emet
 * @version 20/5/2021
 */

//keyboard
import java.util.Scanner;

public class theGame
{

    String command;
    
    public int rounds = 0;
    
    /**
     * Constructor for objects of class theGame
     */
    public theGame()
    {
        Scanner keyboard = new Scanner(System.in);
        
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
        while(true){
            System.out.println("How many rounds do you want to play?");
            System.out.println("(If you want to play a random number of rounds, type \"random\".)");
            command = keyboard.nextLine().toLowerCase();
            if(isNumeric(command) == true && !command.contains("-") && !command.contains(".")){
                rounds = command.;
                game();
            } else {
                switch(command){
                    case "random": System.out.println("PLACEHOLDER");
                    break;
                    
                    default: System.out.println("That is neither a whole number nor the word \"random\". Keep trying, I'm sure you'll get there eventually.");
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
        for(int i = 0; i < rounds; i++){
            System.out.println("Oops, there's no game yet. Come back later.");
        }
    }
}
