package ja.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ja.model.entities.Building;

public class BuildingDao extends TemplateDao<Building> {

    public BuildingDao( Connection connexion ) {
        super( connexion );
    }

    @Override
    public PreparedStatement creatingSql( Building obj ) throws SQLException {
        String query = "INSERT INTO Building VALUES(?, ?)";
        PreparedStatement pStatement = this.connect.prepareStatement( query );
        pStatement.setString( 1, obj.getIdBuilding() );
        pStatement.setString( 2, obj.getDescription() );
        return pStatement;
    }

    @Override
    public boolean needReturnedValue() {
        return false;
    }

    @Override
    public void completeObject( Building building, ResultSet keys ) {
        // TODO Auto-generated method stub
    }

    @Override
    public PreparedStatement gettingSql( Object[] ids ) throws SQLException {
        String query = "SELECT *  FROM Building WHERE idBuilding=?";
        PreparedStatement pStatement = this.connect.prepareStatement( query );
        pStatement.setObject( 1, ids[0] );
        return pStatement;
    }

    @Override
    public Building map( ResultSet result ) throws SQLException {
        Building build = new Building();
        build.setIdBuilding( result.getString( "idBuilding" ) );
        build.setDescription( result.getString( "description" ) );
        return build;
    }

}
