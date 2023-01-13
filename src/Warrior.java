public class Warrior extends Character implements Attacker{
    private int stamina;
    private int strength;
    private static int count = 0;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void setId() {
        super.setId();
        this.id = "WA_" + String.valueOf(count++);
    }
    @Override
    public void attack(Character character) {

    }

}
