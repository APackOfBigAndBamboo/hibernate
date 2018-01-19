package DoMain.Many2Many;

import java.util.Set;

public class Teacher {
    private int id;
    private String name;
    private Set<Student>student;

    public Set<Student> getStudent() {
        return student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
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

    public Set<Student> getStudents() {
        return student;
    }

    public void setStudents(Set<Student> student) {
        this.student = student;
    }
}
