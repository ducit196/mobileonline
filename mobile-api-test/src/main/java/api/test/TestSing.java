package api.test;

public class TestSing implements TestInterface {
    public static void main(String[] args) {
        Student student1 = Student.getInstance();
        Student student2 = Student.getInstance();
        student1.setId("11");
        student1.setName("22");

        student2.setName("dddddddddddddddd");
        System.out.println(student1.getId());
        System.out.println(student1.getName());

        System.out.println(student2.getId());
        System.out.println(student2.getName());
    }

    public void add() {

    }
}
