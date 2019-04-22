public class Student {

    private String name;
    private int score;

    public Student(String studentName,int studentScore){
        name =studentName;
        score = studentScore;
    }
    @Override
    public String toString(){
        return String.format("Student(name:%s ,score: %d)",name,score);
    }
    public static void main(String[] args){
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("Alice",1000));
        arr.addLast(new Student("Bob",300));
        arr.addLast(new Student("Charlie",30));
        System.out.println(arr);
    }

}
