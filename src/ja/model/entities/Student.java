package ja.model.entities;

public class Student extends Person {
    private Study study;

    public Student( String firstName, String lastName, Study study ) {
        super( firstName, lastName );
        this.study = study;
    }

    public Student( String firstName, String lastName ) {
        super( firstName, lastName );
    }

    public Student() {
        super();
    }

    public Study getStudy() {
        return study;
    }

    public void setStudy( Study study ) {
        this.study = study;
    }

}
