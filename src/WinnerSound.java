public class WinnerSound extends Thread{
    @Override
    public void run() {
        AudioPlayer player = new AudioPlayer();
        player.play("src/winner.wav");
    }
}
