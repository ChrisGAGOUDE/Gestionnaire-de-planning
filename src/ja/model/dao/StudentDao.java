package ja.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ja.model.entities.Student;
import ja.model.entities.Study;

public class StudentDao extends TemplateDao<Student> {

    public StudentDao( Connection connexion ) {
        super( connexion );

    }

    @Override
    public void completeObject( Student obj, ResultSet keys ) throws SQLException {
        obj.setIdPerson( keys.getInt( 1 ) );

    }

    @Override
    public PreparedStatement creatingSql( Student obj ) throws SQLException {
        String query = "INSERT INTO Student (firstName, lastName) VALUES(?, ?, ?)";
        PreparedStatement pStatement = this.connect.prepareStatement( query, Statement.RETURN_GENERATED_KEYS );
        pStatement.setString( 1, obj.getFirstName() );
        pStatement.setString( 2, obj.getLastName() );
        pStatement.setInt( 3, obj.getStudy().getIdStudy() );
        return pStatement;
    }

    @Override
    public boolean needReturnedValue() {
        return true;
    }

    @Override
    public Student map( ResultSet result ) throws SQLException {
        Student student = new Student();
        student.setIdPerson( result.getInt( "idStudent" ) );
        student.setFirstName( result.getString( "firstName" ) );
        student.setLastName( result.getString( "lastName" ) );
        int idStudy = result.getInt( "idStudy" );
        if ( idStudy != 0 ) {
            Dao<Study> daoStudy = new StudyDao( this.connect );
            student.setStudy( daoStudy.get( idStudy ) );
        }

        return student;

    }

    @Override
    public PreparedStatement gettingSql( Object[] ids ) throws SQLException {
        String query = "SELECT * FROM Student WHERE idStudent=?";
        PreparedStatement pStatement = this.connect.prepareStatement( query );
        pStatement.setObject( 1, ids[0] );
        return pStatement;
    }

}
