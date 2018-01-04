package ja.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ja.model.entities.ChemistryLab;
import ja.model.entities.Classroom;
import ja.model.entities.ComputerRoom;
import ja.model.entities.LectureRoom;
import ja.model.entities.Level;

public class ClassroomDao extends TemplateDao<Classroom> {

    public ClassroomDao( Connection connexion ) {
        super( connexion );
    }

    @Override
    public void completeObject( Classroom obj, ResultSet keys ) {

    }

    @Override
    public PreparedStatement creatingSql( Classroom obj ) throws SQLException {
        String query = "INSERT INTO Classroom VALUES(?, ?, ?, ?, ?)";

        Dao<Level> dao = new LevelDao( this.connect );
        if ( dao.get( obj.getLevel().getIdLevel(), obj.getLevel().getBuilding().getIdBuilding() ) == null )
            dao.create( obj.getLevel() );

        PreparedStatement pStatement = this.connect.prepareStatement( query );
        pStatement.setInt( 1, obj.getIdClassroom() );
        pStatement.setInt( 3, obj.getCapacity() );
        pStatement.setString( 2, obj.getType() );
        pStatement.setInt( 4, obj.getLevel().getIdLevel() );
        pStatement.setString( 5, obj.getLevel().getBuilding().getIdBuilding() );
        return pStatement;
    }

    @Override
    public boolean needReturnedValue() {
        return false;
    }

    @Override
    public Classroom map( ResultSet result ) throws SQLException {
        Classroom classroom;

        String classType = result.getString( "type" );

        if ( classType.equals( Classroom.TYPE_LECTUREROOM ) )
            classroom = new LectureRoom();
        else if ( classType.equals( Classroom.TYPE_COMPUTERROOM ) )
            classroom = new ComputerRoom();
        else
            classroom = new ChemistryLab();

        classroom.setIdClassroom( result.getInt( "idClassroom" ) );
        classroom.setCapacity( result.getInt( "capacity" ) );

        int idLevel = result.getInt( "idLevel" );
        String idBuilding = result.getString( "idBuilding" );
        Dao<Level> daoLevel = new LevelDao( this.connect );
        classroom.setLevel( daoLevel.get( idLevel, idBuilding ) );

        return classroom;
    }

    @Override
    public PreparedStatement gettingSql( Object[] ids ) throws SQLException {
        String query = "SELECT * FROM Classroom WHERE idClassroom=? AND idLevel=? AND idBuilding=?";
        PreparedStatement pStatement = this.connect.prepareStatement( query );
        pStatement.setObject( 1, ids[0] );
        pStatement.setObject( 2, ids[1] );
        pStatement.setObject( 3, ids[2] );
        return pStatement;
    }

}
