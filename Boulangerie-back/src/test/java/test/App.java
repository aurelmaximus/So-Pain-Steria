package test;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx =new ClassPathXmlApplicationContext("application-context.xml");
		System.out.println(ctx);
		
		Test principal = ctx.getBeanFactory().createBean(Test.class);
		principal.run(args);
		
		ctx.close();

	}

}
