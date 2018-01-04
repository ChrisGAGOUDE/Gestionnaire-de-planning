package ja.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ja.model.entities.Teacher;

public class TeacherDao extends TemplateDao<Teacher> {

    public TeacherDao( Connection connexion ) {
        super( connexion );
    }

    @Override
    public void completeObject( Teacher obj, ResultSet keys ) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public PreparedStatement creatingSql( Teacher obj ) throws SQLException {
        String query = "INSERT INTO Teacher (firstName, lastName) VALUES(?,?)";
        PreparedStatement pStatement = this.connect.prepareStatement( query );
        pStatement.setString( 1, obj.getFirstName() );
        pStatement.setString( 2, obj.getLastName() );
        return pStatement;
    }

    @Override
    public boolean needReturnedValue() {
        return true;
    }

    @Override
    public Teacher map( ResultSet result ) throws SQLException {
        Teacher teacher = new Teacher();
        teacher.setIdPerson( result.getInt( "idTeacher" ) );
        teacher.setFirstName( result.getString( "firstName" ) );
        teacher.setLastName( result.getString( "lastName" ) );
        return teacher;
    }

    @Override
    public PreparedStatement gettingSql( Object[] ids ) throws SQLException {
        String query = "SELECT * FROM Teacher WHERE idTeacher=?";
        PreparedStatement pStatement = this.connect.prepareStatement( query );
        pStatement.setObject( 1, ids[0] );
        return pStatement;
    }

}
