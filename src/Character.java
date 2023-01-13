public abstract class Character {
    //counter for ids
    public String id;
    private String name;
    private int hp;
    private boolean isAlive = true;

    public Character(String name, int hp) {
        setId();
        this.name = name;
        this.hp = hp;
    }

    public Character(String name) {
        setId();
        this.name = name;

    }

    public String getId() {
        return id;
    }

    public void setId() {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
