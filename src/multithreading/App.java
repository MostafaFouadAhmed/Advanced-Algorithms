package multithreading;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Runner1 runner1 = new Runner1(false);

        runner1.start();

        runner1.join(5000);

        runner1.shutDown(true);


    }
}
