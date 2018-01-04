package ja.model.entities;

public class Course {
    public static final String  TYPE_COURSE_CM = "CM";
    public static final String  TYPE_COURSE_TP = "TP";
    protected int               idCourse;
    protected Module            module;

    protected Teacher           teacher;
    protected Study             study;
    protected String            type;
    protected AbstractComposite classroom;

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse( int idCourse ) {
        this.idCourse = idCourse;
    }

    public Module getModule() {
        return module;
    }

    public void setModule( Module module ) {
        this.module = module;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher( Teacher teacher ) {
        this.teacher = teacher;
    }

    public Study getStudy() {
        return study;
    }

    public void setStudy( Study study ) {
        this.study = study;
    }

    public AbstractComposite getClassroom() {
        return classroom;
    }

    public void setClassroom( AbstractComposite classroom ) {
        this.classroom = classroom;
    }

    public Course( Module module ) {
        this.module = module;
        this.type = TYPE_COURSE_CM;
    }

    public Course( Module module, Teacher teacher, Study study ) {
        this.module = module;
        this.teacher = teacher;
        this.study = study;
        this.type = TYPE_COURSE_CM;
    }

    public Course( Module module, Teacher teacher, Study study,
            AbstractComposite classroom ) {
        this.module = module;
        this.teacher = teacher;
        this.study = study;
        this.classroom = classroom;
        this.type = TYPE_COURSE_CM;
    }

    public Course() {
        this.type = TYPE_COURSE_CM;
    }

}
