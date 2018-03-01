package api.test;

public class Student {

    private String id;
    private String name;

    private static Student student = new Student();

    public static Student getInstance() {
        return student;
    }

    private Student() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Student getStudent() {
        return student;
    }

    public static void setStudent(Student student) {
        Student.student = student;
    }

    public static void main(String[] args) {
        Student student = Student.getInstance();
        student.setId("1");
        student.setName("1");
        System.out.println("Student1");
        System.out.println(student.getId());
        System.out.println(student.getName());
        Student student2 = Student.getInstance();
        System.out.println("Student2");
        System.out.println(student2.getId());
        System.out.println(student2.getName());
    }
}
