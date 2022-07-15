package com.muller.devincars.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "DEVS")
@SequenceGenerator(name="seq", initialValue=4, allocationSize=100)
public class Dev {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "course_name")
    String courseName;

    @Column(name = "student_class")
    String studentClass;

    String sponsor;

    @Column(name = "start_year")
    Integer startYear;

    public Dev() {
    }

    public Dev(String courseName, String studentClass, String sponsor, Integer startYear) {
        this.courseName = courseName;
        this.studentClass = studentClass;
        this.sponsor = sponsor;
        this.startYear = startYear;
    }

    public Dev(UUID id, String courseName, String studentClass, String sponsor, Integer startYear) {
        this.id = id;
        this.courseName = courseName;
        this.studentClass = studentClass;
        this.sponsor = sponsor;
        this.startYear = startYear;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }
}
