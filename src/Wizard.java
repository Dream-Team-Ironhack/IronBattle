import java.util.Random;

public class Wizard extends Character implements Attacker {
    private int mana;
    private static int count = 0;
    private int intelligence;




    public Wizard(String name) {
        super(name);
        setMana();
        setIntelligence();
        setHp();
    }

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }


    public int getMana() {
        return mana;
    }

    public void setMana() {
        int rand = new Random().nextInt(10, 51) ;
        this.mana = rand;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence() {
        int rand = new Random().nextInt(1, 51) ;
        this.intelligence = rand;
    }

    @Override
    public void setId() {
        super.setId();
        this.id = "WI_" + String.valueOf(count++);
    }


    public void setHp() {
        int rand = new Random().nextInt(50, 101) ;
        super.setHp(rand);


    }


    @Override
    public void attack(Character character) {

        int damage = 0;
        int health = character.getHp();
        int randomAttack = (int) (Math.random() * 2 + 1); // returns either 1 = weakAttack or 2=heavy Attack


        // basic logic for warrior attack
        if (randomAttack == 1 || this.mana < 5) {
            //staffHit
            character.setHp(health-2);
            mana++;
            System.out.println( this.getName() +" has done Staff Hit to "+ character.getName() + ", dealing 2 points of damage, and his remaining HP are "+ character.getHp());        } else if (randomAttack == 2 && this.mana>=5){
            //Fireball();
            character.setHp(health-intelligence);
            mana=-5;
            System.out.println(this.getName() +" has made a Fireball to " + character.getName() + ", dealing " + (intelligence) + " points of damage, and his remaining HP are " + character.getHp());        }

        if(character.getHp() <= 0){
            character.setAlive(false);
        }
    }

    @Override
    public Wizard clone() {
        Wizard clone2 = new Wizard(getName(), getHp(), getMana(), getIntelligence());
        return clone2;
    }
}
