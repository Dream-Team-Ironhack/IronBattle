public class ThreeTwoOne extends Thread{

    @Override
    public void run() {
        AudioPlayer player = new AudioPlayer();
        player.play("src/three.wav");
    }
}
