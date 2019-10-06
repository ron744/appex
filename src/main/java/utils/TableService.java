package utils;

import model.NoticeTable;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TableService {

    private Session session;
    private final HibernateUtils hibernateUtils;
    public TableService(HibernateUtils hibernateUtils){this.hibernateUtils = hibernateUtils;}

    public void add(NoticeTable noticeTable){
        System.out.println("add");
        session = hibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            session.save(noticeTable);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
    }

    public List<NoticeTable> getAllElements(){
        System.out.println("get all elements");
        List<NoticeTable> noticeTableList = null;
        session = hibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "FROM " + NoticeTable.class.getSimpleName();

        try{
            Query query = session.createQuery(hql);
            noticeTableList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();

        return noticeTableList;
    }

}
