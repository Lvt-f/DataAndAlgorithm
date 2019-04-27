import java.util.Random;
public class Main {
    public static void main(String[] args)
    {
        int opCount = 100000;

        ArrayStack<Integer>arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack,opCount);
        System.out.println("arrayStack time:" + time1 +"S");

        LinkedListStack<Integer>linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack,opCount);
        System.out.println("linkedListStack time:" + time2 +"S");
    }
    //测试使用stack运行opCount个push和pop操作所需要的时间，单位，秒
    private static double testStack(Stack<Integer> stack,int opCount)
    {
        Random random = new Random();
        long startTime = System.nanoTime();
        //...入队
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));//随机数入队
        }
        //出队
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
