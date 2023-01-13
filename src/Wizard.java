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

    }
}
