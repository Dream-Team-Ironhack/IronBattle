import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.Files.*;

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
    public static void printMenu() throws IOException, InterruptedException {

        System.out.println("Welcome to...");
        System.out.println("▄▄▄█████▓ ██░ ██ ▓█████     ▄████▄   ██▓     ▒█████   ███▄    █ ▓█████     █     █░ ▄▄▄       ██▀███    ██████ \n" +
                "▓  ██▒ ▓▒▓██░ ██▒▓█   ▀    ▒██▀ ▀█  ▓██▒    ▒██▒  ██▒ ██ ▀█   █ ▓█   ▀    ▓█░ █ ░█░▒████▄    ▓██ ▒ ██▒▒██    ▒ \n" +
                "▒ ▓██░ ▒░▒██▀▀██░▒███      ▒▓█    ▄ ▒██░    ▒██░  ██▒▓██  ▀█ ██▒▒███      ▒█░ █ ░█ ▒██  ▀█▄  ▓██ ░▄█ ▒░ ▓██▄   \n" +
                "░ ▓██▓ ░ ░▓█ ░██ ▒▓█  ▄    ▒▓▓▄ ▄██▒▒██░    ▒██   ██░▓██▒  ▐▌██▒▒▓█  ▄    ░█░ █ ░█ ░██▄▄▄▄██ ▒██▀▀█▄    ▒   ██▒\n" +
                "  ▒██▒ ░ ░▓█▒░██▓░▒████▒   ▒ ▓███▀ ░░██████▒░ ████▓▒░▒██░   ▓██░░▒████▒   ░░██▒██▓  ▓█   ▓██▒░██▓ ▒██▒▒██████▒▒\n" +
                "  ▒ ░░    ▒ ░░▒░▒░░ ▒░ ░   ░ ░▒ ▒  ░░ ▒░▓  ░░ ▒░▒░▒░ ░ ▒░   ▒ ▒ ░░ ▒░ ░   ░ ▓░▒ ▒   ▒▒   ▓▒█░░ ▒▓ ░▒▓░▒ ▒▓▒ ▒ ░\n" +
                "    ░     ▒ ░▒░ ░ ░ ░  ░     ░  ▒   ░ ░ ▒  ░  ░ ▒ ▒░ ░ ░░   ░ ▒░ ░ ░  ░     ▒ ░ ░    ▒   ▒▒ ░  ░▒ ░ ▒░░ ░▒  ░ ░\n" +
                "  ░       ░  ░░ ░   ░      ░          ░ ░   ░ ░ ░ ▒     ░   ░ ░    ░        ░   ░    ░   ▒     ░░   ░ ░  ░  ░  \n" +
                "          ░  ░  ░   ░  ░   ░ ░          ░  ░    ░ ░           ░    ░  ░       ░          ░  ░   ░           ░  \n" +
                "                           ░                                                                                   ");
        System.out.println("IRON BATTLE - THE CLONE WARS");
        printSeparator(30);
        System.out.println("What do you want to do today? ");
        System.out.println("(1) Let's Battle!");
        System.out.println("(2) Exit Game");
        int input = readInt("Select an option", 2);
        if(input == 1){
            System.out.println("(1) Name your combatants and let them fight!");
            System.out.println("(2) Battle with two combatants selected randomly from a csv file");
            int input1 = readInt("Select an option", 2);
            if(input1 == 1){
                generateCombatants();
                System.out.println("Thanks for playing, see you soon!");
            } else if(input1 == 2){
                readCombatantsFromFile();

                System.out.println("Thanks for playing, see you soon!");
            }
        } else {
            System.out.println("See you soon!");

        }
    }

    public static void battle(Character player1, Character player2) throws InterruptedException {
        Character clonPlayer1;
        Character clonPlayer2;
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
        int roundCount = 1;
        printSeparator(30);
        System.out.println("GET READY");
        System.out.println(player1.getName() + " VERSUS " + player2.getName());
        Thread.sleep(1000);
        System.out.println("BATTLE STARTS IN");
        System.out.println("3");
        Thread.sleep(1000);
        System.out.println("2");
        Thread.sleep(1000);
        System.out.println("1");
        Thread.sleep(1000);
        //the loop starts
        do{
            System.out.println();
            System.out.println( "Round number " + roundCount);
            roundCount++;
            printSeparator(20);
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

            }
            System.out.println("Remaining HP - ");
            System.out.println("        " + player1.getName() + "       " + player2.getName() + "          ");
            System.out.println("         " + player1.getHp() + "              " + player2.getHp() + "           ");
            Thread.sleep(1000);
        } while (player1.isAlive() && player2.isAlive());


        if(!player1.isAlive()){
            System.out.println();
            printSeparator(30);
            System.out.println( player1.getName() + " is dead.");
            System.out.println(player2.getName() + " IS THE ABSOLUTE...");
            System.out.println(" █████   ███   █████ █████ ██████   █████ ██████   █████ ██████████ ███████████  \n" +
                    "░░███   ░███  ░░███ ░░███ ░░██████ ░░███ ░░██████ ░░███ ░░███░░░░░█░░███░░░░░███ \n" +
                    " ░███   ░███   ░███  ░███  ░███░███ ░███  ░███░███ ░███  ░███  █ ░  ░███    ░███ \n" +
                    " ░███   ░███   ░███  ░███  ░███░░███░███  ░███░░███░███  ░██████    ░██████████  \n" +
                    " ░░███  █████  ███   ░███  ░███ ░░██████  ░███ ░░██████  ░███░░█    ░███░░░░░███ \n" +
                    "  ░░░█████░█████░    ░███  ░███  ░░█████  ░███  ░░█████  ░███ ░   █ ░███    ░███ \n" +
                    "    ░░███ ░░███      █████ █████  ░░█████ █████  ░░█████ ██████████ █████   █████\n" +
                    "     ░░░   ░░░      ░░░░░ ░░░░░    ░░░░░ ░░░░░    ░░░░░ ░░░░░░░░░░ ░░░░░   ░░░░░ \n" +
                    "                                                                                 \n" +
                    "                                                                                 \n" +
                    "                                                                                 ");
            printSeparator(30);
            System.out.println();
        } else if(!player2.isAlive()){
            System.out.println();
            printSeparator(30);
            System.out.println( player2.getName() + " is dead.");
            System.out.println(player1.getName() + " IS THE ABSOLUTE...");
            System.out.println(" █████   ███   █████ █████ ██████   █████ ██████   █████ ██████████ ███████████  \n" +
                    "░░███   ░███  ░░███ ░░███ ░░██████ ░░███ ░░██████ ░░███ ░░███░░░░░█░░███░░░░░███ \n" +
                    " ░███   ░███   ░███  ░███  ░███░███ ░███  ░███░███ ░███  ░███  █ ░  ░███    ░███ \n" +
                    " ░███   ░███   ░███  ░███  ░███░░███░███  ░███░░███░███  ░██████    ░██████████  \n" +
                    " ░░███  █████  ███   ░███  ░███ ░░██████  ░███ ░░██████  ░███░░█    ░███░░░░░███ \n" +
                    "  ░░░█████░█████░    ░███  ░███  ░░█████  ░███  ░░█████  ░███ ░   █ ░███    ░███ \n" +
                    "    ░░███ ░░███      █████ █████  ░░█████ █████  ░░█████ ██████████ █████   █████\n" +
                    "     ░░░   ░░░      ░░░░░ ░░░░░    ░░░░░ ░░░░░    ░░░░░ ░░░░░░░░░░ ░░░░░   ░░░░░ \n" +
                    "                                                                                 \n" +
                    "                                                                                 \n" +
                    "                                                                                 ");
            printSeparator(30);
            System.out.println();
        }
    }

    public static void generateCombatants() throws InterruptedException {
        Character player1 = null;
        Character player2 = null;

        Scanner input = new Scanner(System.in);
        System.out.println("Get ready for the next battle!");
        System.out.println("Player1, please Enter your name");
        String namePlayer1 = input.nextLine();
        System.out.println("Hello " + namePlayer1 +"!");
        int choice = 0;
        while(choice !=1 && choice !=2){
            System.out.println("Please choose a character. Enter 1 for Wizard or 2 for Warrior");
            System.out.println("(1) Wizard\n(2) Warrior");
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
            System.out.println("(1) Wizard\n(2) Warrior");
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

    public static void readCombatantsFromFile() throws IOException, InterruptedException {

        File file = new File("characters.csv");
        Scanner read = new Scanner(file);
        //read first combatant randomly from file
        String player1 = readAllLines(Paths.get("characters.csv")).get(new Random().nextInt(1, 301));
        //read second combatant randomly from file
        String player2= readAllLines(Paths.get("characters.csv")).get(new Random().nextInt(1, 301));



        while (player1.equals(player2)) {
            player2= readAllLines(Paths.get("characters.csv")).get(new Random().nextInt(1, 301));
        }



        String[] player1array = player1.split(";");
        Character char1;
        if (player1array[1] == "Warrior") {
            char1 = new Warrior(player1array[0], Integer.parseInt(player1array[2]), Integer.parseInt(player1array[5]),Integer.parseInt(player1array[4]));

        } else {
            char1 = new Wizard(player1array[0], Integer.parseInt(player1array[2]), Integer.parseInt(player1array[5]),Integer.parseInt(player1array[4]));
        }


        Character char2;
        String[] player2array = player2.split(";");
        if (player2array[1] == "Warrior") {
            char2 = new Warrior(player2array[0], Integer.parseInt(player2array[2]), Integer.parseInt(player2array[5]),Integer.parseInt(player2array[4]));
        } else {
            char2 = new Wizard(player2array[0], Integer.parseInt(player2array[2]), Integer.parseInt(player2array[5]),Integer.parseInt(player2array[4]));
        }



        battle(char1,char2);

//        List<Character> listOfChars= new ArrayList<>();
//        listOfChars.add(char1);
//        listOfChars.add(char2);
//
//        System.out.println(listOfChars.get(0).getName());
//        System.out.println(listOfChars.get(1).getName());

        //       return listOfChars;
    }

    public static void printSeparator(int n){
        for (int i = 0; i < n; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
