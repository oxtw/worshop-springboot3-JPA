package com.migueljava.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.migueljava.course.entities.Category;
import com.migueljava.course.entities.Order;
import com.migueljava.course.entities.Product;
import com.migueljava.course.entities.User;
import com.migueljava.course.entities.enums.OrderStatus;
import com.migueljava.course.repositories.CategoryRepository;
import com.migueljava.course.repositories.OrderRepository;
import com.migueljava.course.repositories.ProductRepository;
import com.migueljava.course.repositories.UserRepository;

@Configuration // toda classe de configuração precisa ter o @configuration.
@Profile("test") // "test" é o perfil de teste que crei na apllication-test.properties, o nome
					// precisa estar igual. É nessa annotation onde escolhemos o perfil que vamos usar.
public class TestConfig implements CommandLineRunner{
	
	//Injeções de dependencia
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2,cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		//instânciando usuário
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//OrderStatus é definido aqui.
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); //strings no formato ISO 8601
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); //Ano-mes-dia letra T horas:min:seg letra Z
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);//horário padrão UTC, timezone GNT. Pode ser configurado por qualquer dev no mundo para um horário local.
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
}
