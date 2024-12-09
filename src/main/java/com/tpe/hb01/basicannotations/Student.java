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

@Entity//bu sınıfın DB de bir tabloya karşılık gelmesini sağlıyoruz , tablonun adı :student
@Table(name = "t_student")//bu sınıfın hangi tabloya karşılık geleceğini belirtiyoruz, tablonun adı: student
//bu classı hibernate'nin bir entity olarak işaret ediyoruz.
//!!! Javaca konuşurken bu sınıfı belirtirken Student,
//SQLce konuşurken t_student kullanırız.
public class Student {
    @Id//id sütununa Primary key kısıtlamasını eklenmesini sağlar..// Id fieldı primary key ,Unique ve ilişkilendirilme zorunlu kılıyor.
    //@Column(name = "std_id")
   private Integer id;
    @Column(name = "student_name",nullable = false,unique=true,length=50)//varchar(255)//kısıtlamaları bu şekilde yapabiliyoruz.//nullable boşgeçilebilir
   private String name;//not null
   private int grade;

   //todo:transient,Lob

   //getter-setter for
    // id, name, grade


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
