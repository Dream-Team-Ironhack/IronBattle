import java.util.Random;

public class GameLogic {

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
