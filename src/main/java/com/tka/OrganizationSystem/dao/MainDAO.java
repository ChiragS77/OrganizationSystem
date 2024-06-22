package com.tka.OrganizationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Repository
public class MainDAO {

	@Autowired
	SessionFactory sf;

	public String addCountry(Country c) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			session.persist(c);
			tx.commit();
			msg = "Country added successfully ";

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	//-------------------------------------------------------------------------------------------
	
	
	public String updateCountry(Country c) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			Country country  = session.get(Country.class, c.getCid());
			country.setCname(c.getCname());
			session.merge(country);
			tx.commit();
			msg = "Country updated successfully ";

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}
	
	//---------------------------------------------------------------------------------------------

	public String deleteCountry(int id) {
		
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			Country country  = session.get(Country.class,id);
			session.remove(country);
			tx.commit();
			msg = "Country deleted successfully ";

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		
		
		return msg;
	}
	
	//-------------------------------------------------------------------------------------------------

	public List<Country> getAllCountry() {

		Session session = null;
		Transaction tx = null;
		List<Country> list = null;
		String hqlQuery = "From Country";
		

		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			Query<Country> query = session.createQuery(hqlQuery,Country.class);
			list = query.list();
			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		
		return list;
	}
	
	//------------------------------------------------------------------------------------------------------

	public Country getCountryById(int id) {
		Session session = null;
		Transaction tx = null;
		
		Country c = null;

		try {
			session = sf.openSession();
			tx  = session.beginTransaction();
			 c = session.get(Country.class, id);
			 tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return c;
		
	}

	public String addEmployee(Employee emp) {
		
			Session session = null;
			Transaction tx = null;
			String msg  = null;
			
			try {
				session = sf.openSession();
				tx  = session.beginTransaction();
				session.persist(emp);
				 tx.commit();  
				 msg = "Employee added successfully.....";

			} catch (Exception e) {

				if (tx != null) {
					tx.rollback();
				}

				e.printStackTrace();
			} finally {
				if (session != null) {
					session.close();
				}
			}
			
			
			
		
		return msg;
	}

	public List<Employee> getAllEmployeee() {
		
		Session session = null;
		Transaction tx = null;
		
		List<Employee> list = null;
		String hqlQuery = "From Employee";
		String msg  = null;
		
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			Query<Employee> query  =  session.createQuery(hqlQuery,Employee.class);
			list = query.list();
			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public String updateEmployee(Employee emp) {

		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			session.merge(emp);
			tx.commit();
			msg = "Employee has been updated..";
		}catch(Exception e) {


			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return msg;
	}

	public String deleteEmployee(int id) {
		
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			Employee emp = session.get(Employee.class, id);
			session.delete(emp);
			tx.commit();
			msg = "Employee has been deleted..";
		}catch(Exception e) {


			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return msg;
	}

	
	public Employee getEmpById(int id) {
		
		Session session = null;
		Transaction tx = null;
		
		Employee emp = null;
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			 emp = session.get(Employee.class, id);
			
			
		}catch(Exception e){
			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
			
		}finally {
			if (session != null) {
				session.close();
			}
		}
		
		
		return emp;
	}
}
