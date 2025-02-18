package dsa.javaPractice.concepts;

public class Student {
    int id;
    int age;
    String name;
    Student(){}
    Student(int id,int age,String name){
        this.id = id;
        this.age = age;
        this.name=name;
    }

    @Override
    public String toString(){
        return "Student : "+id;
    }
    public static void main(String[] args) {
        Student st = new Student(101,22,"abc");
        System.out.println(st);
    }

}

