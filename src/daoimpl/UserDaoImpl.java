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

import dao.UserDAO;
import models.Book;
import models.Role;
import models.User;
import util.Database;

public class UserDaoImpl implements UserDAO{
	

	@Override
	public Integer addUser(User user) {
		Integer row = null;
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.save(user);

			
			
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
	public Integer updateUser(User user) {
		Integer row = null;
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.update(user);

			
			
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
	public Integer deleteUser(User user) {
		Integer row = null;
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.remove(user);

			
			
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
	public User getUserById(Integer id) {
		User user = null;
		try {
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();
			
			user = session.get(User.class, id);

			transaction.commit();
			System.out.println("Successfully updated.");
			//factory.close();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return user;
	}

	@Override
	public Integer getUserIdByName(String name) {
		User user = null;
		try {
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			user = session.get(User.class, name);
			
			transaction.commit();
			System.out.println("Successfully updated.");
			//factory.close();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return user.getId();
	}
	
	@Override
	public Integer getUserIdByEmailandPass(String email, String pass) {
		User user = null;
		try {
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			Query query=session.createQuery("from User u where u.email=:n and u.password=:p");
			query.setParameter("n", email);
			query.setParameter("p", pass);
			  
			List list= query.list();//will return the records from 5 to 10th number  
			
			user = (User) list.get(0);

			transaction.commit();
			System.out.println("Successfully updated.");
			//factory.close();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		if (user != null) {
			return user.getId();
		}
		return null;
	}

	@Override
	public List<User> getAllUser() {
		List<User>  allUser = new ArrayList<User>();
		
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			allUser = session.createQuery("from User").list();

			
			
			transaction.commit();
			System.out.println("Successfully fetched.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		
        return allUser;
	}

}
