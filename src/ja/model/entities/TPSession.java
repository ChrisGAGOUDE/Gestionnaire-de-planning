package ja.model.entities;

public class TPSession extends Course {

    public TPSession( Module module ) {
        super( module );
    }

    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup( Group group ) {
        this.group = group;
        this.type = TYPE_COURSE_TP;
    }

    public TPSession( Module module, Group group ) {
        super( module );
        this.group = group;
        this.type = TYPE_COURSE_TP;
    }

    public TPSession() {
        this.type = TYPE_COURSE_TP;
    }

}
