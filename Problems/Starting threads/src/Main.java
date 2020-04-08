public class Main {

    public static void main(String[] args) {

        // create threads and start them using the class RunnableWorker
        Thread worker1 = new Thread(new RunnableWorker());
        worker1.setName("worker-1");
        worker1.start();
        Thread worker2 = new Thread(new RunnableWorker());
        worker2.setName("worker-2");
        worker2.start();
        Thread worker3 = new Thread(new RunnableWorker());
        worker3.setName("worker-3");
        worker3.start();

    }
}