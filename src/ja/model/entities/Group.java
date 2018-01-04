package ja.model.entities;

import java.util.HashSet;
import java.util.Set;

public class Group {
    private int          idGroup;
    private Study        study;
    private Set<Student> students;

    public Group( int idGroup, Study study ) {
        this.idGroup = idGroup;
        this.study = study;
        this.students = new HashSet<Student>();
    }

    public Group() {

    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup( int idGroup ) {
        this.idGroup = idGroup;
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

    public Study getStudy() {
        return study;
    }

    public void setStudy( Study study ) {
        this.study = study;
    }

}
