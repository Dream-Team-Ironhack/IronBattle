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
                generateCombatants();
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
        Character clonPlayer1;
        Character clonPlayer2;
        int roundCount = 1;

        if(player1 instanceof Warrior){
            clonPlayer1 = ((Warrior) player1).clone();
        } else {
            clonPlayer1 = ((Wizard)player1).clone();
        }
        if(player2 instanceof Warrior){
            clonPlayer2 = ((Warrior) player2).clone();
        } else {
            clonPlayer2 = ((Wizard)player2).clone();
        }
        System.out.println(clonPlayer1.getHp());

        //the loop starts
        do{
            System.out.println( "Ronda número: " + roundCount);
            //we create fresh clones every time there's a tie

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

            if(player1.getHp() <= 0 && player2.getHp() <= 0){
                System.out.println("It's a tie!");

                //we return the original state of the players by cloning the clone itself
                if(player1 instanceof Warrior){
                    player1 = ((Warrior) clonPlayer1).clone();
                } else {
                    player1 = ((Wizard)clonPlayer1).clone();
                }
                if(player2 instanceof Warrior){
                    player2 = ((Warrior) clonPlayer2).clone();
                } else {
                    player2 = ((Wizard)clonPlayer2).clone();
                }
                System.out.println(clonPlayer1.getHp());

            }
            roundCount++;


        } while (player1.isAlive() && player2.isAlive());


        if(!player1.isAlive()){
            System.out.println( player1.getName() + " is dead. " + player2.getName() + " WON !!!");
        } else if(!player2.isAlive()){
            System.out.println( player2.getName() + " is dead. " + player1.getName() + " WON !!!");
        }
    }

    public static void generateCombatants(){
        Character player1 = null;
        Character player2 = null;

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome - let the game begin!");
        System.out.println("Player1, please Enter your name");
        String namePlayer1 = input.nextLine();
        System.out.println("Hello " + namePlayer1 +"!");
        int choice = 0;
        while(choice !=1 && choice !=2){
            System.out.println("Please choose a character. Enter 1 for Wizard or 2 for Warrior");
            try{
                choice = Integer.parseInt(input.nextLine());
                if(choice == 1){
                    player1 = new Wizard(namePlayer1);
                } else if(choice ==2){
                    player1 = new Warrior(namePlayer1);
                }else{
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch(Exception e){
                System.out.println("Invalid choice. Please again.");

            }
        }

        System.out.println("Player2, please Enter your name");
        String namePlayer2 = input.nextLine();
        System.out.println("Hello " + namePlayer2 +"!");
        int choice2 = 0;
        while(choice2 !=1 && choice2 !=2){
            System.out.println("Please choose a character. Enter 1 for Wizard or 2 for Warrior");
            try{
                choice2 = Integer.parseInt(input.nextLine());
                if(choice2 == 1){
                    player2 = new Wizard(namePlayer2);
                } else if(choice2 ==2){
                    player2 = new Warrior(namePlayer2);
                }else{
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch(Exception e){
                System.out.println("Invalid choice. Please again.");

            }
        }
        battle(player1, player2);
        input.close();
    }
}
