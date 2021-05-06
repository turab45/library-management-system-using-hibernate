package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.StudentDao;
import models.Student;
import util.Database;

public class StudentDaoImpl implements StudentDao {

	@Override
	public Integer addStudent(Student student) {
		Integer row = null;
		try {

			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.save(student);

			transaction.commit();
			System.out.println("Successfully saved.");

			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer updateStudent(Student student) {
		Integer row = null;

		try {

			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.update(student);

			transaction.commit();
			System.out.println("Successfully updated.");

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return row;
	}

	@Override
	public Integer deleteStudent(Student student) {
		Integer row = null;

		try {
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.remove(student);

			transaction.commit();
			System.out.println("Successfully deleted.");

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return row;
	}

	@Override
	public Student getStudentById(Integer studentId) {
		Student student = null;
		ResultSet rs = null;
		try {
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			student = session.get(Student.class, studentId);

			transaction.commit();
			System.out.println("Successfully updated.");

			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return student;
	}

	@Override
	public Integer getStudentIdByName(String studentName) {

		Student student = null;
		try {
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			Query query = session.createQuery("from Student S where S.name=:n");
			query.setParameter("n", studentName);

			List list = query.list();// will return the records from 5 to 10th number

			student = (Student) list.get(0);

			transaction.commit();
			System.out.println("Successfully updated.");
			// factory.close();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return student.getId();
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> allStudent = new ArrayList<>();
		ResultSet rs = null;
		try {

			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			allStudent = session.createQuery("From Student").list();

			transaction.commit();
			System.out.println("Successfully updated.");
			// factory.close();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return allStudent;
	}

	@Override
	public Integer getIdByRollNo(String rollNo) {
		Integer id = null;

		Student student = null;
		try {
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			Query query = session.createQuery("from Student S where S.rollNo=:n");
			query.setParameter("n", rollNo);

			List list = query.list();// will return the records from 5 to 10th number

			student = (Student) list.get(0);

			transaction.commit();
			System.out.println("Successfully fetched.");
			// factory.close();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return student.getId();
	}

}
