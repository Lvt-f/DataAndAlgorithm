import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int opCount = 100000;

        ArrayQueue<Integer>arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue time:" + time1 + "s");

        LookQueue<Integer>LookQueue = new LookQueue<>();
        double time2 = testQueue(LookQueue,opCount);
        System.out.println("LookQueue time:" + time2 + "s");

        LinkedListQueue<Integer>linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue,opCount);
        System.out.println("LinkedListQueue time:" + time3 + "s");

    }
    //测试使用q运行opCount个enqueue和dequeue操作的时间，单位：秒
    private static double testQueue(Queue<Integer> q,int opCount)
    {
        Random random = new Random();
        long startTime = System.nanoTime();
        //...入队
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));//随机数入队
        }
        //出队
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}

