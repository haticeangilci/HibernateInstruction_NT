package com.tpe.hb01.basicannotations;

//hedef:
//dataları persist etmek için bu classa karşılık bir tablo gerekli
//tablonun sütunları:id,name,grade
//create table student(id int, name varchar...)
//hibernate(ORM) bizim için bu hedefi otomatik olarak yapar.

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//bu sinifin DB de bir tabloya karsilik gelmesini sagliyoruz, tablonun adı: student
@Table(name = "t_student")//tablonun ismini kendimiz verebiliriz.OPSİYONEL
//!!! Javaca konuşurken bu sınıfı belirtirken Student,
//SQLce konuşurken t_student kullanırız.
public class Student {

    @Id//id sütununa PK kısıtlamasının eklenmesini sağlar
    //@Column(name = "std_id")
    private Integer id;

    @Column(name = "student_name",nullable = false,unique = true,length = 50)//default : varchar(255)
    private String name;//not null
    private int grade;


    //getter-setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    //toString
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
