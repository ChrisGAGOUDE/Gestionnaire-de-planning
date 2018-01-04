package ja.model.entities;

public class Module {

    private int    idModule;
    private String name;

    public Module() {

    }

    public Module( int idModule, String name ) {
        this.idModule = idModule;
        this.name = name;
    }

    public Module( String name ) {
        this.name = name;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule( int idModule ) {
        this.idModule = idModule;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

}
