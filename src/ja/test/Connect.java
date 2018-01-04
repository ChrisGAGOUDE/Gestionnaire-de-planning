package ja.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ja.model.dao.BuildingDao;
import ja.model.dao.CourseDao;
import ja.model.dao.Dao;
import ja.model.dao.LevelDao;
import ja.model.dao.StudentDao;
import ja.model.entities.Building;
import ja.model.entities.Course;
import ja.model.entities.Level;
import ja.model.entities.Module;
import ja.model.entities.Student;
import ja.model.entities.Study;
import ja.model.entities.Teacher;

public class Connect {
    public static final String DRIVER   = "com.mysql.jdbc.Driver";

    public static final String URL      = "jdbc:mysql://localhost:3306/ja_db";
    public static final String USER     = "java";
    public static final String PASSWORD = "";

    public static void main( String[] args ) throws Exception {

        Connection connexion = null;
        try {
            Class.forName( DRIVER );
            connexion = DriverManager.getConnection( URL, USER, PASSWORD );
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        } catch ( SQLException e ) {
            e.printStackTrace();
        }

        Dao<Building> dao = new BuildingDao( connexion );
        Building bat = dao.get( "I" );
        System.out.println( bat.getIdBuilding() + " " + bat.getDescription() );

        // Building bat = new Building( "H", "Histoire" );
        Dao<Level> dao2 = new LevelDao( connexion );
        Level lev = dao2.get( 4, "H" );
        System.out.println( lev.getIdLevel() );
        System.out.println( lev.getBuilding().getDescription() );

        Dao<Student> dao4 = new StudentDao( connexion );
        Student etudiant = dao4.get( 3 );
        System.out.println( etudiant.getIdPerson() + " " + etudiant.getFirstName() + " " + etudiant.getLastName()
                + etudiant.getStudy() );

        Dao<Course> courseDao = new CourseDao( connexion );
        Module module = new Module( "Fonctionnement des réseaux" );
        Teacher teacher = new Teacher( "BES", "Alexis" );
        teacher.setIdPerson( 1 );
        Study study = new Study( "M1 Info" );
        Course cours = new Course( module, teacher, study );
        // courseDao.create( cours );

        Course cours2 = courseDao.get( 3 );

        System.out.println( cours2.getTeacher().getFirstName() + " " + cours2.getModule().getName() + " "
                + cours2.getStudy().getName() );
    }
}