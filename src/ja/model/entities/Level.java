package ja.model.entities;

public class Level {
    private Building building;
    private int      idLevel;

    public Level() {

    }

    public Level( int idLevel, Building building ) {
        this.building = building;
        this.idLevel = idLevel;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding( Building building ) {
        this.building = building;
    }

    public int getIdLevel() {
        return idLevel;
    }

    public void setIdLevel( int idLevel ) {
        this.idLevel = idLevel;
    }

}
