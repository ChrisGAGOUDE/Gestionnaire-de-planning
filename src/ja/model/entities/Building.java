package ja.model.entities;

public class Building {
    private String idBuilding;
    private String description;

    public Building() {

    }

    public Building( String id ) {
        this.idBuilding = id;
    }

    public Building( String id, String desc ) {
        this.idBuilding = id;
        this.description = desc;
    }

    public String getIdBuilding() {
        return idBuilding;
    }

    public void setIdBuilding( String idBuilding ) {
        this.idBuilding = idBuilding;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

}
