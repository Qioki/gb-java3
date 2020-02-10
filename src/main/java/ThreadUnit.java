public class ThreadUnit implements Runnable {

    private Main main;
    public String msg;

    public ThreadUnit(Main main, String msg) {
        this.main = main;
        this.msg = msg;
    }
    @Override
    public void run() {
        
        for (int i = 0; i < 5; i++) {
            main.sendMsg(msg);
        }
    }

}