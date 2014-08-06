package ru.push.backend;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test_applicationContext.xml")
@Transactional("transactionManager")
public class DeviceDAOImplTest {

    @Autowired
    private DeviceDAO dao;

    private static final Logger LOG = Logger.getLogger(DeviceDAOImplTest.class.getSimpleName());

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    @Ignore
    public void testGetList() throws Exception {
        LOG.info("testGetList");
        List list = dao.getAll();
        assertNotNull(list);
        assertTrue(list.size() != 0);
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    @Ignore
    public void testAddItem() {
        LOG.info("testAddItem");
        int start = dao.getAll().size();

        RegisteredDevice demo = new RegisteredDevice();
        demo.setPushId("rughughiu589dr45v6sfb48");
        demo.setFaculty("ГМФ");
        demo.setGroupName("АТП-12");
        demo.setDataTime("2015-03-15 10:21:28");
        dao.addItem(demo);

        List finish = dao.getAll();
        int end = finish.size();

        assertEquals(end - start, 1);

        assertEquals(finish.get(end - 1), demo);
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    @Ignore
    public void testUpdate() {
        LOG.info("testUpdate");
        RegisteredDevice expected = new RegisteredDevice();
        expected.setPushId("fhth456484t89h4");
        expected.setFaculty("FGZV");
        expected.setGroupName("TTPV-11");
        dao.updateItem(expected);


        RegisteredDevice current = dao.getDeviceByPushId(expected.getPushId());

        assertEquals(expected, current);
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    @Ignore
    public void TestGetDeviceByPushId() {
        RegisteredDevice expected = new RegisteredDevice();
        expected.setPushId("fhth456484t89h4");
        expected.setFaculty("FGZ");
        expected.setGroupName("TTP-11");
        expected.setIsSent(false);
        expected.setDataTime("2014-06-27 01:32:18.410345");

        RegisteredDevice obj = dao.getDeviceByPushId(expected.getPushId());
        assertNotNull(obj);

        assertEquals(obj, expected);
    }


    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    @Ignore
    public void testGetPage() {
        LOG.info("testGetPage");
        List list = dao.getPage(1);

        assertNotNull(list);
        assertEquals(list.size(), DeviceDAO.COUNT_ITEM_PAGE);
    }

}