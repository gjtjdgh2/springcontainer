package springcontainer;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringContainerApp {

	public static void main(String[] args) {
		//testBeanFactory();
		//testApplicationContext();
		testBeanFactory2();
	}
	
	private  static void testApplicationContext() {
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext("congfig/applicationContext.xml");
		
		//타입으로 받기
		//해당 타입으로 생성된 객체가 유일해야 한다
//		User user1 =ac.getBean(User.class);
//		System.out.println("Get by type:"+user1);
		
		//id or name으로 받아오기
		User user1=(User)ac.getBean("user"); //id 명시
		User user2=(User)ac.getBean("member"); //name 으로 받아오기
		
		System.out.println("Get by type:"+user1);
		System.out.println("Get by name:"+user2);
		
		//spring containar는 기본적으로 singleton 컨테이너이다
		//id로 받아오던 name으로 받아오던 등록된 객체는 1개다
		System.out.println("user1 == user2:"+(user1 == user2));
		
		User user3=(User)ac.getBean("user3");
		System.out.println("user3:"+user3);
		System.out.println("user1 == user3:"+(user1 == user3));
		
		//생성자로 만들어진 빈 얻어오기
		User user4 = (User)ac.getBean("user4");
		System.out.println("user4:"+user4);
		
		//setter로 생성된 빈 얻어 오기
		User user5 = (User)ac.getBean("user5");
		System.out.println("user5:"+user5);
		
//		의존성이 주입된 빈 얻어오기
			Friend friend = (Friend)ac.getBean("friend");
			System.out.println("Friend:" + friend);
			User user6 = (User)ac.getBean("user6");
			System.out.println("User6:" + user6);
			
			//	집합 객체가 주입된 빈 얻어오기
			User user7 = (User)ac.getBean("user7");
			System.out.println("User7:" + user7);
		
	}
	
	
	private static void testBeanFactory() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("congfig/applicationContext.xml"));
		
		//타입 얻어오기
		User user = bf.getBean(User.class);
		System.out.println("by type:"+user);
		
		//id로 얻어오기
		user=(User)bf.getBean("user"); //id가 user인 bean 획득하기
		System.out.println("by id:"+user);
		
		//name 으로 얻어오기
		user=(User)bf.getBean("member");//name이 user인 bean 횟득
		System.out.println("by name:"+user);
	}
	
	private static void testBeanFactory2() {
		BeanFactory bf =
				new XmlBeanFactory(new ClassPathResource("config/applicationContext2.xml"));
		
		User user = (User)bf.getBean("user");
		System.out.println("by Component Scan:" + user);
	}
}
