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

import com.mysql.fabric.xmlrpc.base.Data;
import com.sun.prism.paint.RadialGradient;

import dao.BookDao;
import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;
import models.Book;
import models.Category;
import models.Role;
import models.Student;
import util.Database;

public class BookDaoImpl implements BookDao{
	
		

	@Override
	public Integer addBook(Book book) {
		Integer row = null;
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.save(book);

			
			
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
	public Integer updateBook(Book book) {
		Integer row = null;
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.update(book);

			
			
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
	public Integer deleteBook(Book book) {
		Integer row = null;
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.remove(book);

			
			
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
	public Integer getIdByName(String name) {
		
		Book book = null;
		try {
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			Query query=session.createQuery("from Book b where b.title=:n");
			query.setParameter("n", name);
			  
			List list= query.list();//will return the records from 5 to 10th number  
			
			book = (Book) list.get(0);

			transaction.commit();
			System.out.println("Successfully updated.");
			//factory.close();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return book.getId();
	}

	@Override
	public Book getBookById(Integer id) {
		Book book = null;
		
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			book = session.get(Book.class, id);

			
			
			transaction.commit();
			System.out.println("Successfully saved.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		
        return book;
	}

	@Override
	public List<Book> getAllBook() {
		List<Book> allBook = new ArrayList<Book>();
		
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			allBook = session.createQuery("from Book").list();

			
			
			transaction.commit();
			System.out.println("Successfully fetched.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		
        return allBook;
	}
	

}
