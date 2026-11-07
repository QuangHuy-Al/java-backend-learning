import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentManager {
    private static final List<Student> studentList=new ArrayList<>();
    private static Scanner sc=new Scanner(System.in);

    public static void main(String[] args){
        studentList.add(new Student(101, "Nguyen Van An", 8.5));
        studentList.add(new Student(102, "Tran Thi Binh", 7.2));
        studentList.add(new Student(103, "Le Van Cuong", 9.0));
        studentList.add(new Student(104, "Pham My Duyen", 6.8));


        int choice=-1;
        while (true){
            printMenu();
            choice=readInt("nhap lua chon cua ban: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    findStudentById();
                    break;
                case 4:
                    calculateAverageScore();
                    break;
                case 5:
                    displayHighScoringStudents();
                    break;
                case 6:
                    sortStudentsByScoreDescending();
                    break;
                case 7:
                    updateScore();
                    break;
                case 8:
                    deleteStudentById();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình. Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
            System.out.println();


        }
    }

    private static void printMenu() {
        System.out.println("================= MENU QUẢN LÝ SINH VIÊN =================");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. In toàn bộ danh sách sinh viên");
        System.out.println("3. Tìm sinh viên theo ID");
        System.out.println("4. Tính điểm trung bình của cả lớp");
        System.out.println("5. In danh sách sinh viên có điểm từ 8.0 trở lên");
        System.out.println("6. Sắp xếp danh sách giảm dần theo điểm");
        System.out.println("7. Cập nhật điểm sinh viên");
        System.out.println("8. Xóa sinh viên theo id");
        System.out.println("0. Thoát");
        System.out.println("==========================================================");
    }

    private static void addStudent(){
        System.out.println("--- THEM SINH VIEN MOI---");
        int id;
        while (true){

                id=readInt("nhap id sinh vien: ");
                if(getStudentById(id) != null){
                    System.out.println("id nay da ton tai");
                    continue;
                }
                break;

        }

        System.out.print("nhap ho va ten: ");
        String name=sc.nextLine();

        double score;

        score=readScore("nhap so diem sinh vien (0.0 - 10.0): ");

        Student student=new Student(id,name,score);
        studentList.add(student);
        System.out.println("them sing vien thanh cong");
    }

    private static void displayAllStudents(){
        System.out.println("--- TOAN BO DANH SACH SINH VIEN ---");
        if(studentList.isEmpty()){
            System.out.println("danh sach hien tai dang trong");
        }else {
            for (Student student: studentList){
                System.out.println(student);
            }
        }
    }

    private static Student getStudentById(int id){
        for(Student student : studentList){
            if (student.getId()==id){
                return student;
            }
        }
        return null;
    }

    private static void findStudentById(){
        System.out.println("--- tim kiem sinh vien theo id ---");
        if (studentList.isEmpty()){
            return;
        }

        int searchId;

                searchId = readInt("nhap id sinh vien can tim: ");
                Student student=getStudentById(searchId);
                if(student != null) {
                    System.out.println(student);
                }else{
                    System.out.println("khong tim thay sinh vien co id: "+searchId);
                }



    }

    private static void calculateAverageScore(){
        System.out.println("--- tinh diem trung binh ---");
        if (studentList.isEmpty()){
            System.out.println("danh sach trong, khong the tinh diem trung binh");
            return;
        }
        double sumScore=0.0;
        for(Student student: studentList){
            sumScore+=student.getScore();
        }
        double avgScore=sumScore/studentList.size();
        System.out.println("so luong sinh vien "+studentList.size());
        System.out.println("diem trung binh: "+avgScore);
    }

    private static void displayHighScoringStudents(){
        System.out.println("--- danh sach sinh vien co diem >=8.0 ---");
        if(studentList.isEmpty()){
            System.out.println("danh sach sinh vien dang trong");
            return;
        }
        int count=0;
        for(Student student: studentList){
            if(student.getScore()>=8.0){
                System.out.println(student);
                count++;
            }
        }
        if(count>0){
            System.out.println("so luong sinh vien "+count);
        }else{
            System.out.println("khong co sinh vien nao dap ung du dieu kien");
        }
    }

    private static void sortStudentsByScoreDescending(){
        System.out.println("--- sap xep danh sach giam dan theo diem ---");
        if(studentList.isEmpty()){
            System.out.println("danh sach hien tai dang trong");
            return;
        }

        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getScore(), s1.getScore());
            }
        });

        System.out.println("da sap xep xong danh sach, danh sach sau khi sap xep:");
        for(Student student:studentList){
            System.out.println(student);
        }
    }

    private static void updateScore(){
        System.out.println("--- cap nhat diem sinh vien ---");

        int id;
        Student student=null;

                id = readInt("nhap id sinh vien: ");
                student = getStudentById(id);
                if(student==null){
                    System.out.println("khong tim thay sinh vien nay");
                  return;
                }



        double newScore;

                newScore=readScore("nhap so diem moi (0.0 - 10.0): ");

                student.setScore(newScore);
                System.out.println("cap nhat diem sinh vien thanh cong");
                System.out.println(student);



    }

    private static int readInt(String prompt){
        int a;
        while(true){
            System.out.print(prompt);
            try {
                a = Integer.parseInt(sc.nextLine());
                return a;
            }catch (NumberFormatException e){
                System.out.println("vui long nhap so nguyen");
            }
        }
    }

    private static double readScore(String prompt){
        double a;
        while(true){
            System.out.print(prompt);
            try {
                a = Double.parseDouble(sc.nextLine());
                if (a<0||a>10){
                    System.out.println("vui long nhap (0.0 - 10.0)");
                    continue;
                }
                return a;
            }catch (NumberFormatException e){
                System.out.println("vui long nhap so thuc");
            }
        }
    }

    private static void deleteStudentById(){
        System.out.println("--- xoa sinh vien theo id ---");
        int id=readInt("nhap id sinh vien can xoa: ");
        Student student=getStudentById(id);
        if(student == null){
            System.out.println("khong tim thay sinh vien co id: "+id);
            return;
        }
        System.out.println(student);
        studentList.remove(student);
        System.out.println("xoa sinh vien thanh cong!");
    }

}
