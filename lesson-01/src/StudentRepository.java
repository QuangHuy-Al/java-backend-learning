public interface StudentRepository {
    boolean save (Student student);
    Student findById(int id);
    boolean deleteById(int id);
    int count();
}
