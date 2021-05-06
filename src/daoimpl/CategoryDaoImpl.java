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

import dao.CategoryDao;
import models.Book;
import models.Category;
import models.Role;
import util.Database;

public class CategoryDaoImpl implements CategoryDao{
	

	@Override
	public Integer addCategory(Category category) {
		Integer row = null;
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.save(category);

			
			
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
	public Integer updateCategory(Category category) {
		Integer row = null;
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.update(category);

			
			
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
	public Integer deleteCategory(Category category) {
		Integer row = null;
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.remove(category);

			
			
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
	public Integer getIdByName(String name) {
		Category category = null;
		try {
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			Query query=session.createQuery("from Category c where c.category=:n");
			query.setParameter("n", name);
			  
			List list= query.list();//will return the records from 5 to 10th number  
			
			category = (Category) list.get(0);

			transaction.commit();
			System.out.println("Successfully updated.");
			//factory.close();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return category.getId();
	}

	@Override
	public Category getCategoryById(Integer id) {
		Category category = null;
		
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			category = session.get(Category.class, id);

			
			
			transaction.commit();
			System.out.println("Successfully fetched.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		
        return category;
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> allCategory = new ArrayList<Category>();
		
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			allCategory = session.createQuery("from Category").list();

			
			
			transaction.commit();
			System.out.println("Successfully fetched.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		
        return allCategory;
	}

}
