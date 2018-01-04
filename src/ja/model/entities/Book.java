package ja.model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Book {
    private Course          course;
    private Classroom       classroom;
    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    private LocalDate       dateBook;

    public Course getCourse() {
        return course;
    }

    public void setCourse( Course course ) {
        this.course = course;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom( Classroom classroom ) {
        this.classroom = classroom;
    }

    public LocalDate getDateBook() {
        return dateBook;
    }

    public void setDateBook( LocalDate dateBook ) {
        this.dateBook = dateBook;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime( LocalDateTime startTime ) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime( LocalDateTime endTime ) {
        this.endTime = endTime;
    }

    public Book( Course course, Classroom classroom, LocalDate dateBook ) {
        this.course = course;
        this.classroom = classroom;
        this.dateBook = dateBook;
    }

    public Book() {
        // TODO Auto-generated constructor stub
    }

}
