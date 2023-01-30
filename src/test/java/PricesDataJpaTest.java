import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import entitys.Prices;
import repository.PricesRepository;

/**
 * Example Unit test. Not meant to be a show case for 
 * best practice of writing Spring Boot JPA unit tests.
 * 
 * The main point here is that you can use the @DataJpaTest 
 * annotation because it will include Pre-Liquibase auto-configuration
 */

//@TestPropertySource(properties = {"spring.config.location=classpath:application-test.yml" })
@ContextConfiguration(classes=DemoApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@DataJpaTest
public class PricesDataJpaTest {
	
    @Autowired
	private PricesRepository pricesRepository;


    @Test
    @DisplayName("Componentes injectados no son nulos")
    void injectedComponentsAreNotNull() {
        assertThat(pricesRepository).isNotNull();


    }
    
    
    @Test	
    @DisplayName("Prueba guardar un prices")
    void guardarRazaPrices() {
		Prices prices1= new Prices();
		prices1.setId((long)1423);
		prices1.setProduct_id((long) 1235678);
		prices1.setBrand_id(1);
		prices1.setPrice_list((long) 5);
		prices1.setCurr("EUR");
		prices1.setStart_date(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		prices1.setEnd_date(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		prices1.setPrice(42);
		prices1.setPriority(2);
		
		Prices pricesOutput = pricesRepository.save(prices1);
		
        Optional<Prices> price1output = pricesRepository.findById(pricesOutput.getId());
        
        prices1.setId(pricesOutput.getId());
        
		assertThat(price1output.get()).usingRecursiveComparison().isEqualTo(prices1);

    }
    
   
}
