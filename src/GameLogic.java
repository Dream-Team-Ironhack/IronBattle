import java.util.Random;
import java.util.Scanner;

public class GameLogic {

    static Scanner scanner = new Scanner(System.in);
    public static int readInt(String prompt, int userChoices){
        int input;
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch(Exception e) {
                input = -1;
                System.out.println("Please enter a valid option!");
            }
        } while (input < 1 || input > userChoices);

        return input;
    }
    public static void printMenu() {
        System.out.println("Choose an action: ");
        System.out.println("(1) Let's Battle!");
        System.out.println("(2) Extras");
        System.out.println("(3) Exit Game");
        int input = readInt("Introduzca una opción", 3);
        if(input == 1){
            System.out.println("(1) Random combatants");
            System.out.println("(2) Generate your combatants");
            System.out.println("(2) Import your combatants from a file");
            int input1 = readInt("-> ", 3);
            if(input1 == 1){
                System.out.println("(1) Quick 1 vs 1");
                System.out.println("(2) Tournament");
                int input1_1 = readInt("-> ", 2);
                if(input1_1==1){

                    System.out.println("A quick random battle");
                } else if (input1_1 == 2){
                    System.out.println("More options, like how many combatants");
                }
            } else if(input1 == 2){
                //generateCombatant();
                System.out.println("User can generate the combatants here and let them fight");
            } else {
                System.out.println("Import combatants from a file");
            }
        } else if (input == 2) {
            System.out.println("Extras, like a history of battles");
        } else {
            System.out.println("The came closes");
        }
    }

    public static void battle(Character player1, Character player2){
        Character clonPlayer1 = player1;
        Character clonPlayer2 = player2;

        do{

            // we can not directly call attack method of character
            if(player1 instanceof Warrior){
                ((Warrior) player1).attack(player2);
            } else if(player1 instanceof Wizard){
                ((Wizard) player1).attack(player2);
            }

            if(player2 instanceof Warrior){
                ((Warrior) player2).attack(player1);
            } else if(player2 instanceof Wizard){
                ((Wizard) player2).attack(player1);
            }

            if(player1.getHp() == player2.getHp() && player1.getHp() <= 0){

                player1 = clonPlayer1;
                player2 = clonPlayer2;
               /* int rand1 = new Random().nextInt(100, 201) ;
                int rand2 = new Random().nextInt(50, 101) ;

                if(player1 instanceof Warrior){
                    player1.setHp(rand1);
                } else if(player1 instanceof Wizard){
                    player1.setHp(rand2);
                }

                if(player2 instanceof Warrior){
                    player2.setHp(rand1);
                } else if(player2 instanceof Wizard){
                    player2.setHp(rand2);
                }*/

            }

        } while (/*player1.getHp() > 0 || player2.getHp() > 0*/ player1.isAlive() && player2.isAlive());


        if(!player1.isAlive()){
            System.out.println( player1.getName() + " is dead. " + player2.getName() + " WON !!!");
        } else if(!player2.isAlive()){
            System.out.println( player2.getName() + " is dead. " + player1.getName() + " WON !!!");
        }
    }
}
