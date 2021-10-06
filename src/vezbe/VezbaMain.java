package vezbe;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


public class VezbaMain {

	static JFrame frame;
	static JList list;
	static JTextField text;
	static JPanel panel;
	public static void main(String[] args) {

		fillInList();
		frame=new JFrame();
	//	list=new JList();
		text=new JTextField();
		panel=new JPanel();
		
		list=new JList(join.toArray());
	    list.setSelectedIndex(2);
	    list.setFont(new Font("ARIAL BLACK", Font.PLAIN, 16));
		
		
		//layout
		panel.add(new JScrollPane(list));
		panel.add(text);
		//frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.add(panel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(550, 350);
        frame.setVisible(true);
	}
	

	static List<Object> join=new ArrayList<Object>();
	static List <Dao> dao=new ArrayList<Dao>();
	static List <Person> per=new ArrayList<Person>();
	static public void fillInList() {
		 SessionFactory sessionFactory = Hibernate.getSessionFactory();
			Session session=sessionFactory.getCurrentSession();
			session.beginTransaction();
		    
		   // String hql = "from Dao";
			//  String hql = "select c from Category c join fetch c.events where c.parentCategory.categoryId = 1";
		 String hql = "select d from Dao d join fetch d.person";
		// String hql = "from Person";
			  Query query = session.createQuery(hql);
			  //vidi sta je u listi
			join = query.list(); 
			
			System.out.println("ispisi listu: fillInList metoda");
			System.out.println("lista ima: "+join.size());
			for(int i=0; i<join.size(); i++) {
				System.out.println(join.get(i));
			}
			session.getTransaction().commit();
		    
	}
}
