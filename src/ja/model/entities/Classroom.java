package ja.model.entities;

public abstract class Classroom extends AbstractComposite {

    public static final String TYPE_LECTUREROOM  = "Salle pour cours magistral";
    public static final String TYPE_CHEMISTRYLAB = "Salle de chimie";
    public static final String TYPE_COMPUTERROOM = "Salle machine";

    protected int              idClassroom;
    protected Level            level;
    protected int              capacity;
    protected String           type;

    public Classroom() {

    }

    public Classroom( int idClassroom, Level level ) {
        super();
        this.idClassroom = idClassroom;
        this.level = level;
    }

    public Classroom( int idClassroom, Level level, int capacity ) {

        this.idClassroom = idClassroom;
        this.level = level;
        this.capacity = capacity;
    }

    public int getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom( int idClassroom ) {
        this.idClassroom = idClassroom;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel( Level level ) {
        this.level = level;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity( int capacity ) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

}
