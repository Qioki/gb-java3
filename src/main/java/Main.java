import java.util.LinkedList;

public class Main {

    private static LinkedList<ThreadUnit> loopQueue = new LinkedList<ThreadUnit>();

    public static void main(String[] args) {

        Main main = new Main();

        ThreadUnit t1 = new ThreadUnit(main, "A");
        ThreadUnit t2 = new ThreadUnit(main, "B");
        ThreadUnit t3 = new ThreadUnit(main, "C");

        loopQueue.add(t1);
        loopQueue.add(t2);
        loopQueue.add(t3);

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
    public synchronized void sendMsg(String msg) {
        
        while(!loopQueue.peek().msg.equals(msg)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        loopQueue.add(loopQueue.pop());
        System.out.print(msg);

        notifyAll();
    }
}