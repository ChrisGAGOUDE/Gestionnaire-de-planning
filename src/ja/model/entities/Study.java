package ja.model.entities;

import java.util.HashSet;
import java.util.Set;

public class Study {

    private int          idStudy;
    private String       name;
    private Set<Student> students;

    public Study() {
        this.students = new HashSet<Student>();
    }

    public Study( String name ) {
        this.name = name;
        this.students = new HashSet<Student>();
    }

    public int getIdStudy() {
        return idStudy;
    }

    public void setIdStudy( int idStudy ) {
        this.idStudy = idStudy;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents( Set<Student> students ) {
        this.students = students;
    }

    public void addStudent( Student student ) {
        this.students.add( student );
    }

    public void removeStudent( Student student ) {
        this.students.remove( student );
    }
}
