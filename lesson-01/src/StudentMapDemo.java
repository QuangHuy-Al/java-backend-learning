

public class StudentMapDemo {
    private static final StudentRepository repository = new InMemoryStudentRepository();
    public static void main(String[] args){

        addStudent(new Student(101,"An",8.5));
        addStudent(new Student(102,"Binh",7.0));
        addStudent(new Student(101,"cuong",9.0));
        findStudentById(101);
        updateStudentScore(101,9.5);
        findStudentById(101);
        deleteStudentById(102);
        findStudentById(102);
    }
    public static void addStudent(Student student){
        if (repository.save(student)){
            System.out.println("them thanh cong");
        }else {
            System.out.println("da co sinh vien nay");
        }
    }
    public static void findStudentById(int id){
        Student student=repository.findById(id);
        if(student==null){
            System.out.println("khong co sinh vien nay");
            return;
        }

        System.out.println(student);
    }
    public static void updateStudentScore(int id,double newScore){
        Student student=repository.findById(id);
        if (student==null) {
            System.out.println("khong tim thay id "+id);
            return;
        }

        student.setScore(newScore);
        System.out.println("sua diem thanh cong");
    }
    public static void deleteStudentById(int id){
        if(!repository.deleteById(id)){
            System.out.println("khong tim thay id "+id);
            return;
        }

        System.out.println("Xóa sinh viên thành công");
        System.out.println("so sinh vien con lai: "+repository.count());
    }
}
