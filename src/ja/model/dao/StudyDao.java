package ja.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ja.model.entities.Study;

public class StudyDao extends TemplateDao<Study> {

    public StudyDao( Connection connexion ) {
        super( connexion );
    }

    @Override
    public void completeObject( Study obj, ResultSet keys ) throws SQLException {
        obj.setIdStudy( keys.getInt( 1 ) );
    }

    @Override
    public PreparedStatement creatingSql( Study obj ) throws SQLException {
        String query = "INSERT INTO Study (name) VALUES(?)";
        PreparedStatement pStatement = this.connect.prepareStatement( query, Statement.RETURN_GENERATED_KEYS );
        pStatement.setString( 1, obj.getName() );
        return pStatement;
    }

    @Override
    public boolean needReturnedValue() {
        return true;
    }

    @Override
    public Study map( ResultSet result ) throws SQLException {
        Study study = new Study();
        study.setIdStudy( result.getInt( "idStudy" ) );
        study.setName( result.getString( "name" ) );
        return study;
    }

    @Override
    public PreparedStatement gettingSql( Object[] ids ) throws SQLException {
        String query = "SELECT * FROM Study WHERE idStudy=?";
        PreparedStatement pStatement = this.connect.prepareStatement( query );
        pStatement.setObject( 1, ids[0] );
        return pStatement;
    }

}
