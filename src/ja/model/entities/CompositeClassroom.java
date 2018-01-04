package ja.model.entities;

import java.util.Set;

public class CompositeClassroom extends AbstractComposite {
    private Set<CompositeClassroom> classrooms;

    public Set<CompositeClassroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms( Set<CompositeClassroom> classrooms ) {
        this.classrooms = classrooms;
    }

    public void addClassroom( CompositeClassroom classroom ) {
        this.classrooms.add( classroom );
    }

    public void removeClassroom( CompositeClassroom classroom ) {
        this.classrooms.remove( classroom );
    }

}
