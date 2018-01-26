package com.ssm.dao;

import com.ssm.BaseTest;
import com.ssm.entity.Appointment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AppointmentDaoTest extends BaseTest {
    @Autowired
    private AppointmentDao appointmentDao;

    @Test
    public void testInsertAppoinment() {
        long bookId = 1000;
        long studentId = 12345678910L;
        int insert=appointmentDao.insertAppointment(bookId,studentId);
        System.out.println(insert);
    }

    @Test
    public void testQueryByIdForBook(){
        long bookId=1000;
        long studentId=12345678910L;
        Appointment appointment=appointmentDao.queryByKeyWithBook(bookId,studentId);
        System.out.println(appointment);
        System.out.println(appointment.getBook());
    }
}
