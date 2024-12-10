package com.tpe.hb01.basicannotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {

        Student student1=new Student();
        student1.setId(1001);
        student1.setName("Jack Sparrow");
        student1.setGrade(99);

        Student student2=new Student();
        student2.setId(1002);
        student2.setName("Harry Potter");
        student2.setGrade(98);

        Student student3=new Student();
        student3.setId(1003);
        student3.setName("Sherlock Holmes");
        student3.setGrade(98);

        /*
        Configuration, Hibernate'in başlangıç aşamasında kullanılır
        ve Hibernate'in çalışması için gerekli ayarların (örneğin, veritabanı bağlantısı)
        yapılmasını sağlar. Hibernate ile çalışırken tipik olarak bir Configuration
        nesnesi oluşturulur, ardından bu nesne kullanılarak bir SessionFactory oluşturulur.

        SessionFactory, Hibernate'in temel bileşenlerinden biridir
        Veritabanı işlemleri gerçekleştirmek için Session nesneleri üretir.
        Uygulama boyunca genellikle bir kez oluşturulur ve tüm uygulama tarafından paylaşılır.

        Session, Hibernate ile veritabanı arasında bağlantıyı sağlar.
        Veritabanı üzerinde Create, Read, Update, Delete (CRUD) işlemlerini gerçekleştirir.
        Her işlem için yeni bir Session oluşturulması önerilir.
        */

        //default olarak hibernate bu ismi arar.Configuration
        //ile bir hibernate.cfg.xml dosyasına göre hibernate'nin işleyişini başlatır.
        //Bu dosyada hibernate'nin hangi sınıfları ile çalışacağını ve hangi veritabanı ile bağlantı kuracağını
        //belirtiyoruz.

        //addAnnotatedClass methodu, hibernate'nin anotasyonlarla çalışmasını sağlayan metod.
        //Bu metod, anotasyonlarımızı (Student sınıfımızın @Entity ve @Table anotasyonları)
        //Hibernate'e göstermek için kullanır.

        //Configuration'un buildSessionFactory metodu, Configuration'un yaptığı işlemlerle
        //SessionFactory nesnesi üretir ve bu nesneyi sessionFactory değişkenine atar.
        //SessionFactory, hibernate'in temel bileşenlerinden biridir.
        //Uygulama boyunca genellikle bir kez oluşturulur ve tüm uygulama tarafından paylaşılır.

        //Session, Hibernate ile veritabanı arasında bağlantıyı sağlar.
        //Veritabanı üzerinde Create, Read, Update, Delete (CRUD) işlemlerini gerçekleştirir.
        //Her işlem için yeni bir Session oluşturulması önerilir.

        //Configuration, Hibernate'in başlangıç aşamasında kullanılır
        //ve Hibernate'in çalışması için gerekli ayarların (örneğin, veritabanı bağlantısı)
        //yaplmasını sağlar.

        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).addAnnotatedClass(Employee.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        //hibernatede default olarak auto-commit:false
        //db de işlemlerin kalıcı olması için transaction başlatılıp onaylanması gerekir
        Transaction transaction=session.beginTransaction();
        //transaction (db de atomic işlem birimi)başlatıldı.

        //student1 i tabloya ekleyelim
        //save metodu, hibernate'nin işlemleri için önemli bir işlemdir.
        //save metodu, yeni bir obje hibernate'e kaydetmek için kullanılır.
        //save metodu, hibernate'nin objedeki id'yi kontrol eder ve id'ye sahip bir obje yoksa
        //objeyi db'ye kaydeder. id'ye sahip bir obje varsa, update işlemi yapılır.
        //save metodu, hibernate'nin işlemlerinde çok önemli bir işlemdir.
        //save metodu, hibernate'nin objedeki id'yi kontrol eder ve id'ye sahip bir obje yoksa


        //insert, update, delete işlemleri
        //student1 i tabloya ekleyelim
        //"INSERT INTO t_student VALUES(....)"
        session.save(student1);
        session.save(student2);
        session.save(student3);

        //commit işlemi
        session.getTransaction().commit();

        //session'ın kapatılması
        session.close();

        //SessionFactory'ın kapatılması//database işimiz bittiğinde tamamen kapatırız.
        sessionFactory.close();

        System.out.println("Student saved successfully");






    }
}
