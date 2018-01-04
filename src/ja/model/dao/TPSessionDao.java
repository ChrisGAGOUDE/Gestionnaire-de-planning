package ja.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ja.model.entities.Group;
import ja.model.entities.Module;
import ja.model.entities.Study;
import ja.model.entities.TPSession;
import ja.model.entities.Teacher;

public class TPSessionDao extends TemplateDao<TPSession> {

    public TPSessionDao( Connection connexion ) {
        super( connexion );
    }

    @Override
    public void completeObject( TPSession obj, ResultSet keys ) throws SQLException {
        obj.setIdCourse( keys.getInt( 1 ) );

    }

    @Override
    public TPSession map( ResultSet result ) throws SQLException {
        TPSession course = new TPSession();
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
        // "yyyy/MM/dd HH:mm" );
        course.setIdCourse( result.getInt( "idCourse" ) );
        // course.setStartTime( LocalDateTime.parse( result.getString(
        // "startDate" ), formatter ) );
        // course.setEndTime( LocalDateTime.parse( result.getString( "endDate"
        // ), formatter ) );
        int idModule = result.getInt( "idModule" );
        int idTeacher = result.getInt( "idTeacher" );
        int idStudy = result.getInt( "idStudy" );
        int idGroup = result.getInt( "idGroup" );
        if ( idModule != 0 ) {

            Dao<Module> daoModule = new ModuleDao( this.connect );
            course.setModule( daoModule.get( idModule ) );
        }
        if ( idTeacher != 0 ) {
            Dao<Teacher> daoTeacher = new TeacherDao( this.connect );
            course.setTeacher( daoTeacher.get( idTeacher ) );
        }
        if ( idStudy != 0 ) {
            Dao<Study> daoStudy = new StudyDao( this.connect );
            course.setStudy( daoStudy.get( idStudy ) );
        }
        if ( idGroup != 0 ) {
            Dao<Group> daoGroup = new GroupDao( this.connect );
            course.setGroup( daoGroup.get( idGroup ) );
        }

        return course;

    }

    @Override
    public PreparedStatement gettingSql( Object[] ids ) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PreparedStatement creatingSql( TPSession obj ) throws SQLException {
        String query = "INSERT INTO Course (idModule, idTeacher, type, idGroup) VALUES(?, ?, ?, ? )";
        PreparedStatement pStatement = this.connect.prepareStatement( query );
        pStatement.setInt( 1, obj.getModule().getIdModule() );
        pStatement.setInt( 2, obj.getTeacher().getIdPerson() );
        pStatement.setString( 3, "TP" );
        pStatement.setInt( 4, obj.getGroup().getIdGroup() );
        return pStatement;
    }

    @Override
    public boolean needReturnedValue() {
        return true;
    }

}
