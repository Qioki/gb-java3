import java.util.concurrent.CountDownLatch;

public class FinishLine extends Stage {

    CountDownLatch waitingAllCars;

    public FinishLine(int howMuchCars) {

        waitingAllCars = new CountDownLatch(howMuchCars);

        this.description = "Финишировал";

        waiting();
    }

    public void waiting() {

        new Thread(() -> {
            try {
                waitingAllCars.await();

                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }).start();
    }

    @Override
    public void go(Car c) {

        System.out.println(c.getName() + ": " + description);

        waitingAllCars.countDown();
      
 
    }
} 