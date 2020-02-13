import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StartLine extends Stage {

    CountDownLatch waitingAllCars;
    Future<Boolean> waitingSignal;

    public StartLine(int howMuchCars) {

        waitingAllCars = new CountDownLatch(howMuchCars); 

        this.description = "Занял позицию. Ожидание сигнала";

        waiting();
    }

    public void waiting() {

        Callable<Boolean> callable = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                try {
                    waitingAllCars.await();
    
                    System.out.println("Все участники заняли позиции\nНа старт");
                    Thread.sleep(1000);
                    System.out.println("Внимание");
                    Thread.sleep(1000);
                    System.out.println("Марш!");
                    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                   
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return true;
            }
        }; 
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        waitingSignal = executorService.submit(callable);
        executorService.shutdown();
    }

    @Override
    public void go(Car c) {

        System.out.println(c.getName() + ": " + description);

        waitingAllCars.countDown();
        
        try {
            waitingSignal.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
 
    }
} 