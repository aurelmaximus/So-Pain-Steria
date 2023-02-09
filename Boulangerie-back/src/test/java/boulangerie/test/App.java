package boulangerie.test;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx =new ClassPathXmlApplicationContext("application-context.xml");
		System.out.println(ctx);
		
		TestWithRepo principal = ctx.getBeanFactory().createBean(TestWithRepo.class);
		principal.run(args);
		
		ctx.close();

	}

}
