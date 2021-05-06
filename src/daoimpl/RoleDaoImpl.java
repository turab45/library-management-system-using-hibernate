package daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.RoleDao;
import models.Book;
import models.Role;
import util.Database;

public class RoleDaoImpl implements RoleDao {

	@Override
	public Integer addRole(Role role) {
		try {

			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.save(role);

			transaction.commit();
			System.out.println("Successfully saved.");

			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer updateRole(Role role) {
		Integer row = null;
		try {

			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.update(role);

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
	public Integer deleteRole(Role role) {
		try {

			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.remove(role);

			transaction.commit();
			System.out.println("Successfully deleted.");

			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Role getRoleById(Integer id) {

		Role role = null;
		try {

			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			role = session.get(Role.class, id);

			transaction.commit();
			System.out.println("Successfully fetched.");

			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}

		return role;
	}

	@Override
	public Integer getRoleIdByName(String name) {
		Role role = null;
		try {

			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			role = session.get(Role.class, name);

			transaction.commit();
			System.out.println("Successfully saved.");

			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return role.getId();

	}

	@Override
	public List<Role> getAllRole() {
		List<Role> allRoles = new ArrayList<Role>();

		try {

			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			allRoles = session.createQuery("from role").list();

			transaction.commit();
			System.out.println("Successfully fetched.");

			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}

		return allRoles;
	}

}
