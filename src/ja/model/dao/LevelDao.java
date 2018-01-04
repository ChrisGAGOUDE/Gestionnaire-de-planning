package ja.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ja.model.entities.Building;
import ja.model.entities.Level;

public class LevelDao extends TemplateDao<Level> {

    public LevelDao( Connection connexion ) {
        super( connexion );
    }

    @Override
    public void completeObject( Level obj, ResultSet keys ) {
        // TODO Auto-generated method stub

    }

    @Override
    public PreparedStatement creatingSql( Level obj ) throws SQLException {

        Dao<Building> dao = new BuildingDao( this.connect );
        if ( dao.get( obj.getBuilding().getIdBuilding() ) == null )
            dao.create( obj.getBuilding() );

        String query = "INSERT INTO Level VALUES(?, ?)";
        PreparedStatement pStatement = this.connect.prepareStatement( query );
        pStatement.setInt( 1, obj.getIdLevel() );
        pStatement.setString( 2, obj.getBuilding().getIdBuilding() );
        return pStatement;
    }

    @Override
    public boolean needReturnedValue() {
        return false;
    }

    @Override
    public Level map( ResultSet result ) throws SQLException {
        Level level = new Level();
        level.setIdLevel( result.getInt( "idLevel" ) );
        Dao<Building> daoB = new BuildingDao( this.connect );
        level.setBuilding( daoB.get( result.getString( "idBuilding" ) ) );
        return level;
    }

    @Override
    public PreparedStatement gettingSql( Object[] ids ) throws SQLException {
        String query = "SELECT * FROM Level WHERE idLevel=? AND idBuilding=?";
        PreparedStatement pStatement = this.connect.prepareStatement( query );
        pStatement.setObject( 1, ids[0] );
        pStatement.setObject( 2, ids[1] );
        return pStatement;
    }

}
