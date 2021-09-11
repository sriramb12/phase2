package com.entity;



import com.util.HibernateUtil;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Test {

	public static void main(String[] args) {
		
		  SessionFactory sf = HibernateUtil.buildSessionFactory();
		  Session session = sf.openSession();
		  session.beginTransaction();
		  
		  
		  
//		  Classes course1 = new Classes();
//		  
//		  course1.setClassName("Java Full Stack");
//		  
//		  Classes course2 = new Classes();
//		  
//		  course2.setClassName("JavaScript Full Stack");
//		  
//		  Classes course3 = new Classes();
//		  
//		  course3.setClassName("Python Full Stack");
//		  
//		
//		  
//		  
//		  
//		  
//		  Teacher t1 = new Teacher ();
//		  t1.setfName("Lam");
//		  t1.setlName("Bas");
//		  
//		  
//		  
//		  Subject sub1 = new Subject();
//		  sub1.setSubjectName("web dev");
//		  sub1.setCourse(course1);
//		  sub1.setTeacher(t1);
//		  
//		  Subject sub2 = new Subject();
//		  sub2.setSubjectName("Java");
//		  sub2.setCourse(course1);
//		  sub2.setTeacher(t2);
//		  
//		  
//		  List<Subject> class1sub = new ArrayList<>();
//		  class1sub.add(sub1);
//		  class1sub.add(sub2);
//		  class1sub.add(sub3);
//		  course1.setSubjects(class1sub);
//		  
//		  List<Subject> class2sub = new ArrayList<>();
//		  class2sub.add(sub11);
//		  class2sub.add(sub12);
//		  class2sub.add(sub13);
//		  course2.setSubjects(class2sub);
//		  
//		  List<Subject> class3sub = new ArrayList<>();
//		  class3sub.add(sub21);
//		  class3sub.add(sub22);
//		  class3sub.add(sub23);
//		  course3.setSubjects(class3sub);
//		 
//		  
//		  
//		  
//		  
//		  
//		  Student s1 = new Student();
//		
//		  s1.setfName("John");
//		  s1.setlName("Dow");
//		  s1.setCourse(course1);
//		  
//		  Student s2 = new Student();
//		 
//		  s2.setfName("Laman");
//		  s2.setlName("rama");
//		  s2.setCourse(course1);
//		  
//
//		  
//		 
//		  
//		  session.save(course1);
//		  session.save(course2);
//		  
//		
//		  
		  
		 Query q = session.createQuery("from Subject where class_id = 10001");
		 List <Subject> sl = (List <Subject>) q.list();
		 for(Subject subject : sl) {
			 System.out.println(subject.getSubjectName() + " " +subject.getTeacher().getfName() +" " +subject.getTeacher().getlName()   + " " +subject.getCourse().getClassName());
		 }
		 
		  session.getTransaction().commit();

	}

}
