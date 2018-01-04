package ja.model.entities;

public abstract class Person {

    protected int    idPerson;
    protected String firstName;
    protected String lastName;

    public Person() {

    }

    public Person( String firstName, String lastName ) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson( int idPerson ) {
        this.idPerson = idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

}
