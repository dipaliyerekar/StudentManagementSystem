package com.jbk.SpringBoot.Hibernate.CRUD.op.with.DB;


	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class StudentController {

		@Autowired
		SessionFactory sf;
		
		
		
	//	@GetMapping ("single")
		public Student singleRecord() {
			Session ss = sf.openSession();
			Student s = ss.get(Student.class, 101);
			return s;
		}
		
		
		
		
		@PostMapping("insertRecord")
		public Student insert() {
			
			Session ss = sf.openSession();
			Transaction tx = ss.beginTransaction();

			Student s = new Student(101, "dipali");

			ss.save(s);

			System.out.println(s);

			tx.commit();
			
			return s;

		}
		
		
		
		
	//	@PutMapping("updateRecord")
		public Student update() {
			
			Session ss = sf.openSession();
			Transaction tx = ss.beginTransaction();

			Student s = new Student(101, "dp");

			ss.update(s);

			System.out.println(s);

			tx.commit();
			
			return s;

		}
		
		
		
	//	@DeleteMapping("deleteRecord")
		public Student delete() {
			
			Session ss = sf.openSession();
			Transaction tx = ss.beginTransaction();

			Student s = ss.get(Student.class,101);

			ss.delete(s);

			System.out.println(s);

			tx.commit();
			
			return s;

		}
		
	}


