package ja.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ja.model.entities.Group;
import ja.model.entities.Student;
import ja.model.entities.Study;

public class GroupDao extends TemplateDao<Group> {

    public GroupDao( Connection connexion ) {
        super( connexion );
    }

    @Override
    public void completeObject( Group obj, ResultSet keys ) {
    }

    @Override
    public PreparedStatement creatingSql( Group obj ) throws SQLException {
        String query = "INSERT INTO GroupAssignement VALUES(?, ?)";

        Dao<Student> daoStudent = new StudentDao( this.connect );
        obj.getStudents().stream().forEach( a -> daoStudent.create( a ) );

        Dao<Study> daoStudy = new StudyDao( this.connect );
        if ( daoStudy.get( obj.getStudy().getIdStudy() ) == null )
            daoStudy.create( obj.getStudy() );

        PreparedStatement pStatement = this.connect.prepareStatement( query );
        pStatement.setInt( 1, obj.getIdGroup() );
        pStatement.setInt( 2, obj.getStudy().getIdStudy() );
        return pStatement;
    }

    @Override
    public boolean needReturnedValue() {
        return false;
    }

    @Override
    public Group map( ResultSet result ) throws SQLException {
        Group group = new Group();
        group.setIdGroup( result.getInt( "idGroup" ) );
        int idStudy = result.getInt( "idStudy" );
        if ( idStudy != 0 ) {
            Dao<Study> daoStudy = new StudyDao( this.connect );
            group.setStudy( daoStudy.get( idStudy ) );
        }
        return group;
    }

    @Override
    public PreparedStatement gettingSql( Object[] ids ) throws SQLException {
        String query = "SELECT * FROM GroupAssignement WHERE idGroup=? AND idModule=?";
        PreparedStatement pStatement = this.connect.prepareStatement( query );
        pStatement.setObject( 1, ids[0] );
        pStatement.setObject( 2, ids[1] );
        return pStatement;
    }

}
