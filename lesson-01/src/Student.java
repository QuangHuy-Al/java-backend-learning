class Student{
    private int id;
    private String name;
    private double score;

    public Student(int  id,String name, double score){
        this.id=id;
        this.name=name;
        this.score=score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        if (!(other instanceof Student)){return false;}
        return this.id == ((Student) other).id;

    }

    @Override
    public int hashCode(){
        return Integer.hashCode(id);
    }
}