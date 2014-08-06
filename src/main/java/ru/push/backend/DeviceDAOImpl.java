package ru.push.backend;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DeviceDAOImpl implements DeviceDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<RegisteredDevice> getAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(RegisteredDevice.class)
                .addOrder(Order.asc("dataTime")).list();
    }

    @Override
    @Transactional
    public void addItem(RegisteredDevice item) {
        item.setDataTime(getCurrentTimeInDBFormat());

        Session s = sessionFactory.getCurrentSession();
        s.save(item);
        s.flush();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void updateItem(RegisteredDevice new_item) {
        Session session = sessionFactory.getCurrentSession();

        RegisteredDevice old = (RegisteredDevice) session.get(RegisteredDevice.class, new_item.getPushId());
        old.setFaculty(new_item.getFaculty());
        old.setGroupName(new_item.getGroupName());
        old.setDataTime(getCurrentTimeInDBFormat());

        session.saveOrUpdate(old);
        session.flush();
    }

    @Override
    @Transactional(readOnly = true)
    public RegisteredDevice getDeviceByPushId(String pushId) {
        Session session = sessionFactory.getCurrentSession();
        return (RegisteredDevice) session.get(RegisteredDevice.class, pushId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegisteredDevice> getPage(int page) {

        Session session = sessionFactory.getCurrentSession();

        page = page - 1;

        return session.createCriteria(RegisteredDevice.class)
                .setFirstResult(page * COUNT_ITEM_PAGE)
                .setMaxResults(COUNT_ITEM_PAGE)
                .list();
    }

    @Override
    public void delete(String pushId) {
        RegisteredDevice deletable = getDeviceByPushId(pushId);
        sessionFactory.getCurrentSession().delete(deletable);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static String getCurrentTimeInDBFormat() {
        //2014-03-15 10:21:28
        //YYYY-MM-DD HH:MM:SS MySQL DATETIME default format
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        return sdfDate.format(now);
    }
}
