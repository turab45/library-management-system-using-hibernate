package daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sun.org.apache.bcel.internal.generic.ISUB;

import dao.IssueDao;
import models.Book;
import models.Issue;
import models.Role;
import models.Student;
import models.User;
import sun.security.x509.SubjectKeyIdentifierExtension;
import util.Database;

public class IssueDaoImpl implements IssueDao{
	

	@Override
	public Integer addIssue(Issue issue) {
		Integer row = null;
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();
			
			session.save(issue);

			
			
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
	public Integer updateIssue(Issue issue) {
		Integer row = null;
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.update(issue);

			
			
			transaction.commit();
			System.out.println("Successfully updated.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer deleteIssue(Issue issue) {
		Integer row = null;
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.remove(issue);

			
			
			transaction.commit();
			System.out.println("Successfully removed.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return row;
	}

	@Override
	public Issue getIssueById(Integer id) {
		Issue issue = null;
		
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			issue = session.get(Issue.class, id);

			
			
			transaction.commit();
			System.out.println("Successfully fetched.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		
        return issue;
	}

	@Override
	public List<Issue> getAllIssue() {
		List<Issue> allIssue = new ArrayList<Issue>();
try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			allIssue = session.createQuery("from Issue i  where i.status>0").list();

			
			
			transaction.commit();
			System.out.println("Successfully fetched.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
            
        
        return allIssue;
	}

	@Override
	public Integer getIdByBookandStudent(Integer bookId, Integer studentID) {
		Issue issue = null;
		try {
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			Query query=session.createQuery("from Issue i where i.bookId=:n and i.studentId=:p");
			query.setParameter("n", bookId);
			query.setParameter("p", studentID);
			  
			List list= query.list();//will return the records from 5 to 10th number  
			
			issue = (Issue) list.get(0);

			transaction.commit();
			System.out.println("Successfully updated.");
			//factory.close();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return issue.getId();
	}

	@Override
	public Integer returnBook(Issue issue) {
		Integer row = null;
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();
			
			issue.setStatus(0);
			
			session.update(issue);

			
			
			transaction.commit();
			System.out.println("Successfully updated.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return row;
	}
	


}
