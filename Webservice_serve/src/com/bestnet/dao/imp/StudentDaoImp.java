package com.bestnet.dao.imp;

import com.bestnet.dao.StudentDao;
import com.bestnet.vo.BooksEntity;
import com.bestnet.vo.StudentEntity;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImp implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.openSession();
    }

    @Override
    public List<StudentEntity> getStudentEntity() {
        String sql = " FROM BooksEntity";
        Query query = getSession().createQuery(sql);
        List<BooksEntity> list = query.list();
        for(BooksEntity b : list){
            System.out.println("In StudentDaoImp StudentEntity Iterator:"+b.getName());
            System.out.println("booksList:"+b.getStudentEntity().getName());
        }

        //System.out.println("In StudentDaoImp StudentEntity:"+list);
        List<StudentEntity> list1 = null;
        return list1;
    }

    @Override
    public void addStudent() {
        Session session = getSession();
        BooksEntity booksEntity = new BooksEntity();
        StudentEntity studentEntity = new StudentEntity();
        booksEntity.setId("4");
        booksEntity.setName("平凡的世界");
        booksEntity.setPrice(100);
        booksEntity.setStudentEntity(studentEntity);
        studentEntity.setId("3");
        studentEntity.setName("王二麻");
        studentEntity.setSex("男");
        studentEntity.getBooksEntityList().add(booksEntity);
        session.save(studentEntity);
        session.save(booksEntity);
        Transaction transaction = session.beginTransaction();
        transaction.commit();
    }

    @Override
    public List qryStudentEntityById() {
        Session session = getSession();
        String sql = "select * from student where id = '1'";
        /*String sql = " FROM StudentEntity where id=:sid";
        Query query = session.createQuery(sql);
        List<StudentEntity> list = query.setString("sid","1").list();*/
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        List list = sqlQuery.list();
        //StudentEntity s =list.get(0);
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        return list;
    }
}
