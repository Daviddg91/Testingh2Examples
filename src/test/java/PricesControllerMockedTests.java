import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.google.gson.Gson;

import entitys.Prices;
import services.PricesService;
 

@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PricesControllerMockedTests {
 
  @MockBean
  PricesService pricesService;
 
  @Autowired
  MockMvc mockMvc;
 
  
  @Test
  @DisplayName("Mocked respository simple controller test")
  public void testFindPricesByProductIdBrandDate() throws Exception {

		Prices prices1= new Prices();
		
		prices1.setProduct_id((long) 123);
		prices1.setBrand_id(1);
		prices1.setPrice_list((long) 5);
		prices1.setCurr("EUR");
		prices1.setStart_date(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		prices1.setEnd_date(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		prices1.setPrice(42);
		prices1.setPriority(2);
		
		Prices prices2= new Prices();
		
		prices2.setProduct_id((long) 123);
		prices2.setBrand_id(1);
		prices2.setPrice_list((long) 5);
		prices2.setCurr("EUR");
		prices2.setStart_date(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		prices2.setEnd_date(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		prices2.setPrice(42);
		prices2.setPriority(2);
		
		Prices prices3= new Prices();
		
		prices3.setProduct_id((long) 123);
		prices3.setBrand_id(1);
		prices3.setPrice_list((long) 5);
		prices3.setCurr("EUR");
		prices3.setStart_date(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		prices3.setEnd_date(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		prices3.setPrice(42);
		prices3.setPriority(2);
		

		List<Prices> listaInputPrices = new ArrayList<>();
		listaInputPrices.add(prices1);
		listaInputPrices.add(prices2);
		listaInputPrices.add(prices3);
 
		Mockito.when(pricesService.findPricesByProductIdBrandDate((Long)Mockito.any(), (Date)Mockito.any(), (Long)Mockito.any())).thenReturn(listaInputPrices);
 
   ResultActions endpointAction = mockMvc.perform(get("/prices/products/35455/date/2020-06-14-22.30.00/brand/1"))
        .andExpect(status().isOk());
        
    
      String JsonOutputString = endpointAction.andReturn().getResponse().getContentAsString();
   
   Prices[] outputPricestList = new Gson().fromJson(JsonOutputString, Prices[].class);


	assertEquals(listaInputPrices.size(), outputPricestList.length);
	assertThat(prices1).usingRecursiveComparison().isEqualTo(outputPricestList[0]);
	assertThat(prices2).usingRecursiveComparison().isEqualTo(outputPricestList[1]);
	assertThat(prices3).usingRecursiveComparison().isEqualTo(outputPricestList[2]);

	

        
  }
  
 
  
}