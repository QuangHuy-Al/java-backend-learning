
import java.util.HashSet;

import java.util.Set;

public class StudentEqualityDemo {
    private static final Set<Student> students=new HashSet<>();
  public static void main(String[] args){
      boolean addedFirst=students.add( new Student(101, "An", 8.5));
      boolean addedDuplicate=students.add(new Student(101, "Bình", 7.0));
      boolean addedSecond=students.add(new Student(102, "Cường", 9.0));

      System.out.println(addedFirst);
      System.out.println(addedDuplicate);
      System.out.println(addedSecond);

      System.out.println(students.size());
      System.out.println(students.contains(new Student(101, "Không quan trọng", 0.0)));
  }
}
