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

    }

}
