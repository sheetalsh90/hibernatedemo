package com.example.hibernate.hibernate.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class StoreData {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Employee e1 = new Employee();
		e1.setEmpId(1);
		e1.setName("Sheetal");
		e1.setSalary(2000000);
		Phone phone1 = new Phone("airtel", "9926490845");
		e1.setPhoneNumber(phone1);
		phone1.setEmployee(e1);
		Employee e2 = new Employee();
		e2.setEmpId(2);
		e2.setName("Nidhi");
		e2.setSalary(7000000);
		Phone phone2 = new Phone("airtel", "9893140373");
		e2.setPhoneNumber(phone2);
		phone2.setEmployee(e2);
		session.save(e1);
		session.save(e2);
		if (session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().commit();
		}
		session.close();
	}

}
