public class PunchSound extends Thread{

    @Override
    public void run() {
        AudioPlayer player = new AudioPlayer();
        player.play("src/punch.wav");
    }
}
