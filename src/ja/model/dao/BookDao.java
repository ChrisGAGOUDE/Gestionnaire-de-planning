package ja.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ja.model.entities.Book;
import ja.model.entities.Classroom;
import ja.model.entities.Course;

public class BookDao extends TemplateDao<Book> {

    public BookDao( Connection connexion ) {
        super( connexion );
        // TODO Auto-generated constructor stub
    }

    @Override
    public void completeObject( Book obj, ResultSet keys ) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public PreparedStatement creatingSql( Book obj ) throws SQLException {
        String query = "INSERT INTO Book VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pStatement = this.connect.prepareStatement( query );
        pStatement.setInt( 1, obj.getClassroom().getIdClassroom() );
        pStatement.setInt( 2, obj.getClassroom().getLevel().getIdLevel() );
        pStatement.setString( 3, obj.getClassroom().getLevel().getBuilding().getIdBuilding() );
        pStatement.setInt( 4, obj.getCourse().getIdCourse() );
        pStatement.setObject( 5, obj.getDateBook() );
        pStatement.setObject( 6,
                obj.getStartTime().format( DateTimeFormatter.ofPattern( "yyyy/MM/dd HH:mm:ss" ) ) );
        pStatement.setObject( 7,
                obj.getEndTime().format( DateTimeFormatter.ofPattern( "yyyy/MM/dd HH:mm:ss" ) ) );

        return pStatement;
    }

    @Override
    public boolean needReturnedValue() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Book map( ResultSet result ) throws SQLException {
        Book book = new Book();
        int idClassroom = result.getInt( "idClassroom" );
        int idLevel = result.getInt( "idLevel" );
        String idBuilding = result.getString( "idBuilding" );
        int idCourse = result.getInt( "idCourse" );
        Dao<Classroom> daoClassroom = new ClassroomDao( this.connect );
        book.setClassroom( daoClassroom.get( idClassroom, idLevel, idBuilding ) );
        Dao<Course> daoCourse = new CourseDao( this.connect );
        book.setCourse( daoCourse.get( idCourse ) );
        book.setDateBook( LocalDate.parse( result.getString( "bookDate" ) ) );
        book.setStartTime( LocalDateTime.parse( result.getString( "startDate" ),
                DateTimeFormatter.ofPattern( "yyyy/MM/dd HH:mm" ) ) );
        book.setEndTime( LocalDateTime.parse( result.getString( "endDate" ),
                DateTimeFormatter.ofPattern( "yyyy/MM/dd HH:mm" ) ) );
        return book;
    }

    @Override
    public PreparedStatement gettingSql( Object[] ids ) throws SQLException {
        String query = "SELECT * FROM Book WHERE idClassroom=? AND idLevel=?, AND idBuilding=? AND idCourse=?";
        PreparedStatement pStatement = this.connect.prepareStatement( query );
        pStatement.setObject( 1, ids[0] );
        pStatement.setObject( 2, ids[1] );
        pStatement.setObject( 3, ids[3] );
        pStatement.setObject( 4, ids[4] );
        return pStatement;
    }

}
