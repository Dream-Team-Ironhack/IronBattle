import java.util.Random;

public class Warrior extends Character implements Attacker{
    private int stamina;
    private int strength;
    private static int count = 0;

    public Warrior(String name) {
        super(name);
        setStamina();
        setStrength();
        setHp();
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina() {

        this.stamina = new Random().nextInt(10, 51) ;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength() {

        this.strength = new Random().nextInt(1, 11) ;
    }

    @Override
    public void setId() {
        super.setId();
        this.id = "WA_" + String.valueOf(count++);
    }

    public void setHp() {
        int rand = new Random().nextInt(100, 201) ;
        super.setHp(rand);


    }
    @Override
    public void attack(Character character) {

        int damage = 0;
        int health = character.getHp();
        int randomAttack = (int) (Math.random() * 2 + 1); // returns either 1 = weakAttack or 2=heavy Attack


        // basic logic for warrior attack
        if (randomAttack == 1 || this.stamina < 5) {
            //weakAttack
           character.setHp(health-strength/2);
           stamina++;
            //System.out.println( this.getName() +" has done a weak attack to "+ character.getName() +"and his remaining HP are "+ character.getHp());
        } else if (randomAttack == 2 && this.stamina>=5){
                //heavyAttack();
                character.setHp(health-strength);
                stamina=-5;
            //System.out.println(this.getName() +" has made a heavy attack to " + character.getName() +" and his remaining HP are " + character.getHp());
            }

        if(character.getHp() <= 0){
            character.setAlive(false);
        }
        }


    }




