package co.au.vog.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import co.au.vog.model.entity.User;
import co.au.vog.utils.Log;

@Transactional
public class UserDAOImpl implements UserDAO{

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}


	public void addUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		Log.i("Person saved successfully, Person Details="+p);
	}

	public void updateUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		Log.i("Person updated successfully, Person Details="+p);
	}

	public List<User> listUser() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<User> associate = (List<User>) session.createSQLQuery(
			    "SELECT * FROM tb_user")
			    .addEntity(User.class)
			    .list(); 

		return associate;
	}

	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		User p = (User) session.load(User.class, new Integer(id));
		Log.i("Person loaded successfully, Person details="+p);
		return p;
	}

	public void removeUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		Log.i("Person deleted successfully, person details="+p);	
	}

}
