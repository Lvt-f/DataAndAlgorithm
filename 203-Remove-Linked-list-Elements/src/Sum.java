public class Sum {
    /**
     * 递归基本原则
     * 注意递归函数的"宏观"语意
     * 递归函数就是一个函数，完成一个功能
     * 1。求解最基本的问题
     * 2。把原问题转化成最小的问题
     * */
    public static int sum(int[] arr){
        return sum(arr,0);
    }
    //计算arr[l...n]这个区间内所有数字的和
    private static int sum(int[] arr,int l){
        if (l == arr.length) {
            return 0;
        }
        return arr[l]+sum(arr,l+1);
    }
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(num));
    }
}
