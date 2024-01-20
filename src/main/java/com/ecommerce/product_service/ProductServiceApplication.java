package com.ecommerce.product_service;

import com.ecommerce.product_service.inheritaneExample.joinedTable.MentorRepository;
import com.ecommerce.product_service.inheritaneExample.joinedTable.Student;
import com.ecommerce.product_service.inheritaneExample.joinedTable.StudentRepository;
import com.ecommerce.product_service.inheritaneExample.singleTable.Mentor;
import com.ecommerce.product_service.inheritaneExample.tablePerClass.User;
import com.ecommerce.product_service.inheritaneExample.tablePerClass.UserRepository;
import com.ecommerce.product_service.models.Category;
import com.ecommerce.product_service.models.Order;
import com.ecommerce.product_service.models.Price;
import com.ecommerce.product_service.models.Product;
import com.ecommerce.product_service.repositories.CategoryRepository;
import com.ecommerce.product_service.repositories.OrderRepository;
import com.ecommerce.product_service.repositories.PriceRepository;
import com.ecommerce.product_service.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class  ProductServiceApplication implements CommandLineRunner {
	//for single table
//	private MentorRepository mentorRepository;
//	private StudentRepository studentRepository;
//	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

//	public ProductServiceApplication(MentorRepository mentorRepository,
//									 StudentRepository studentRepository,
//									 UserRepository userRepository) {
//		this.mentorRepository = mentorRepository;
//		this.studentRepository = studentRepository;
//		this.userRepository = userRepository;
//	}

//for joined table
	private MentorRepository mentorRepository;
	private StudentRepository studentRepository;

	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	private PriceRepository priceRepository;
	private OrderRepository orderRepository;
	public ProductServiceApplication(MentorRepository mentorRepository,
									 StudentRepository studentRepository,
									 ProductRepository productRepository,
									 CategoryRepository categoryRepository,
									 PriceRepository priceRepository,
									 OrderRepository orderRepository) {
		this.mentorRepository = mentorRepository;
		this.studentRepository = studentRepository;
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.priceRepository = priceRepository;
		this.orderRepository = orderRepository;
	}

	@Override
	public void run(String... args) throws Exception {
//		Mentor mentor = new Mentor();
//		mentor.setName("Vikranth");
//		mentor.setEmail("v@gmail.com");
//		mentor.setAvgRating(100.0);
//		mentorRepository.save(mentor);
//		User user = new User();
//		user.setId(1L);
//		user.setName("Kishan");
//		user.setEmail("k@gmail.com");
//		userRepository.save(user);
//
//		Student student = new Student();
//		student.setId(2L);
//		student.setName("meera");
//		student.setEmail("m@gmail.com");
//		student.setBatch("batch1");
//		student.setPsp(99.0);
//
//		studentRepository.save(student);
//
//		List<User>users = userRepository.findAll();
//		users.forEach(user2 ->{
//			System.out.println(user2.getName());
//		} );
//		Student student = new Student();
//		student.setName("Nishtha");
//		student.setEmail("m@gmail.com");
//		student.setBatch("batch2");
//		student.setPsp(98.0);
//
//		studentRepository.save(student);

		Category category = new Category();
		category.setName("cosmetics");

		Category savedCategory = categoryRepository.save(category);
		Price price = new Price("Rupee",250.0);
//		Price savedPrice =  priceRepository.save(price);

		Product product = new Product();
		product.setTitle("mabiline lipstic");
//		product.setPrice(100.0);
		product.setImage("image url");
		product.setDescription("Best lipstic ever");

		product.setCategory(savedCategory);
		product.setPrice(price);
//		product.setOrder(savedOrder);
		productRepository.save(product);
//	List<Product> products = productRepository.findByTitleAndPrice_currency("mabiline lipstic","Rupee");
//		System.out.println(products);
		Product product1 = productRepository.findByTitle("sugar lipstic");

//		Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString("ac5c9421-0ab9-4150-b29c-5f777e386af3"));
//		if(!categoryOptional.isEmpty()){
//			Category category = categoryOptional.get();
//			System.out.printf("DEBUG");
//		}

//		productRepository.deleteById(UUID.fromString("d62697a4-6e37-4cb5-877c-a8671469ece2"));

	}
}
