import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class Main {


    public static void main(String[] args) {

        Warrior warrior = new Warrior("JaumeWarrior");

        Warrior newWarrior = new Warrior("Jaume2");

        Warrior newNewWarrior = new Warrior("Jaume2");

        Wizard wizard = new Wizard("Pikachu");

        Wizard wizard2 = new Wizard("Charmander");

//        warrior.setHp(5);
//        newWarrior.setHp(5);
//        wizard.setHp(5);
//        wizard2.setHp(5);
//        GameLogic.battle(warrior,newWarrior);

        //GameLogic.battle(wizard, wizard2);

        try {
            GameLogic.printMenu();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        /* Instructions


Bonus

    Import characters using a CSV file.
    Simulate the whole battle with one command by creating random characters with random stats and making them duel.

Important Notes

    Everyone in the squad should contribute equally to the project in time and lines of code written.
    All code must be reviewed before it is merged into the master branch.
    All squad members must participate in code review.
    Every repository should have a README.md file with clear instructions, demo files, or any documentation needed so other teams don’t have problems with the review.
    This is intended to be a challenging assignment. You will have to rely heavily on your teammates and independent research. Learning independently is a hallmark of a good developer and our job is to turn you into good developers. This process may be frustrating but you will learn a ton!

 */

    }
}