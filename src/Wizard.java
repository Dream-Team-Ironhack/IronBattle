import java.util.Random;

public class Wizard extends Character implements Attacker {
    private int mana;
    private static int count = 0;
    private int intelligence;




    public Wizard(String name, int mana, int intelligence) {
        super(name);
        this.mana = mana;
        this.intelligence = intelligence;
        setHp();
    }



    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void setId() {
        super.setId();
        this.id = "WI_" + String.valueOf(count++);
    }


    public void setHp() {
        Random rand = new Random();
        int randomInt = rand.nextInt(51) + 50;
        super.setHp(randomInt);


    }

    @Override
    public void attack(Character character) {

    }
}
