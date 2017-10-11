package cz.fi.muni.pa165.tasks;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.validation.ConstraintViolationException;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cz.fi.muni.pa165.PersistenceSampleApplicationContext;
import cz.fi.muni.pa165.entity.Category;
import cz.fi.muni.pa165.entity.Product;

 
@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
public class Task02 extends AbstractTestNGSpringContextTests {

	@PersistenceUnit
	private EntityManagerFactory emf;
        private Category kitchen;
        private Category electro;
        private Product flashlight;
        private Product kitchenRobot;
        private Product plate;

	@BeforeClass
        private void initialize(){
            EntityManager em = emf.createEntityManager();
            kitchen = new Category();
            kitchen.setName("Kitchen");
            electro = new Category();
            electro.setName("Electro");
            
            flashlight = new Product();
            flashlight.setName("Flashlight");
            flashlight.addCategory(electro);
            
            kitchenRobot = new Product();
            kitchenRobot.setName("Kitchen robot");
            kitchenRobot.addCategory(electro);
            kitchenRobot.addCategory(kitchen);
            
            plate = new Product();
            plate.setName("Plate");
            plate.addCategory(kitchen);
            
            em.getTransaction().begin();
            em.persist(kitchen);
            em.persist(electro);
            em.persist(kitchenRobot);
            em.persist(flashlight);
            em.persist(plate);
            em.getTransaction().commit();
            em.close();
            
        }
        
        @Test
        private void kitchenCategoryTest(){
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Category catA = em.find(Category.class, 1L);
            em.close();
            
            assertContainsProductWithName(catA.getProducts(), "Kitchen robot");
            assertContainsProductWithName(catA.getProducts(), "Plate");
            
        }
        
	private void assertContainsCategoryWithName(Set<Category> categories,
			String expectedCategoryName) {
		for(Category cat: categories){
			if (cat.getName().equals(expectedCategoryName))
				return;
		}
			
		Assert.fail("Couldn't find category "+ expectedCategoryName+ " in collection "+categories);
	}
	private void assertContainsProductWithName(Set<Product> products,
			String expectedProductName) {
		
		for(Product prod: products){
			if (prod.getName().equals(expectedProductName))
				return;
		}
			
		Assert.fail("Couldn't find product "+ expectedProductName+ " in collection "+products);
	}

	
}
