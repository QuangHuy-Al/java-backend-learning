import java.util.HashMap;
import java.util.Map;

public class InMemoryStudentRepository implements StudentRepository{
    private final Map<Integer,Student> studentsById=new HashMap<>();

    @Override
    public Student findById(int id){
        return studentsById.get(id);
    }
    @Override
    public int count(){
        return  studentsById.size();
    }

    @Override
    public boolean save(Student student){
        if(studentsById.containsKey(student.getId())){
            return false;
        }
        studentsById.put(student.getId(), student);
        return true;
    }

    @Override
    public boolean deleteById(int id){
        if(!studentsById.containsKey(id)){
            return false;
        }
        studentsById.remove(id);
        return true;
    }
}
