package com.tpe.practice;

import javax.persistence.Entity;

/*TASK 1:Student-Course-Instructor entitylerini oluşturun.
        Student-Course:M-M
        Course-Instructor:M-1
        Student: id:auto generated,name,grade,courseList(öğrenci geldiğinde kursu da gelsin)

        Course:id,name,credit,studentList,instructor(course kaydedilince instructor da kaydedilsin)

        Instructor:id:auto generated,name,courses

        TASK 2:5'er tane objeyi kaydedin

        TASK 3:id:100 olan öğrenciyi ve kurs listesini getirin
        TASK 4:id:11 olan kursu ve öğrenci listesini getirin
        TASK 5:id:1 olan instructorı getirin
        TASK 6:HQL sorguları çalıştırın:
*/
@Entity
@Table(name = "p_student")
public class Student {

    private Integer id;

    private String name;

    private Integer grade;


}
