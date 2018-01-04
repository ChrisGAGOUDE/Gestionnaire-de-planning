package ja.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ja.model.entities.Course;
import ja.model.entities.Module;
import ja.model.entities.Study;
import ja.model.entities.Teacher;

public class CourseDao extends TemplateDao<Course> {

    public CourseDao( Connection connexion ) {
        super( connexion );
    }

    @Override
    public void completeObject( Course obj, ResultSet keys ) throws SQLException {
        obj.setIdCourse( keys.getInt( 1 ) );

    }

    @Override
    public PreparedStatement creatingSql( Course obj ) throws SQLException {
        String query = "INSERT INTO Course (idModule, idTeacher, type) VALUES(?, ?, ?)";
        Dao<Module> moduleDao = new ModuleDao( this.connect );
        if ( moduleDao.get( obj.getModule().getIdModule() ) == null ) {
            moduleDao.create( obj.getModule() );
        }
        Dao<Teacher> teacherDao = new TeacherDao( this.connect );
        if ( teacherDao.get( obj.getTeacher().getIdPerson() ) == null ) {
            teacherDao.create( obj.getTeacher() );
        }
        Dao<Study> studyDao = new StudyDao( this.connect );
        if ( studyDao.get( obj.getStudy().getIdStudy() ) == null ) {
            studyDao.create( obj.getStudy() );
        }
        PreparedStatement pStatement = this.connect.prepareStatement( query, Statement.RETURN_GENERATED_KEYS );
        pStatement.setInt( 1, obj.getModule().getIdModule() );
        pStatement.setInt( 2, obj.getTeacher().getIdPerson() );
        pStatement.setString( 3, "CM" );
        return pStatement;

    }

    @Override
    public boolean needReturnedValue() {
        return true;
    }

    @Override
    public Course map( ResultSet result ) throws SQLException {
        Course course = new Course();
        course.setIdCourse( result.getInt( "idCourse" ) );
        int idModule = result.getInt( "idModule" );
        int idTeacher = result.getInt( "idTeacher" );
        int idStudy = result.getInt( "idStudy" );
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

        return course;
    }

    @Override
    public PreparedStatement gettingSql( Object[] ids ) throws SQLException {
        String query = "SELECT * FROM Course WHERE idCourse=?";
        PreparedStatement pStatement = this.connect.prepareStatement( query );
        pStatement.setObject( 1, ids[0] );
        return pStatement;
    }
}
