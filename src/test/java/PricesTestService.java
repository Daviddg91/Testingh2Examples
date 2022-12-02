import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;

import controllers.PricesController;
import entitys.Prices;
import facades.PricesFacades;
import repository.PricesRepository;
import services.PricesService;

public class PricesTestService {

	@Spy
	@Autowired
	private PricesController pricesController;

	@Spy
	@Autowired
	private PricesService pricesService;

	@Spy
	@Autowired
	private PricesFacades pricesFacades;

	@Mock
	private PricesRepository pricesRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);

		pricesFacades.setPricesRespository(pricesRepository);
		pricesService.setPricesFacades(pricesFacades);
		pricesController.setPricesService(pricesService);
		
	}



	@Test
	@DisplayName("Pruba para obtener listado de prices")
	public void listadoPricesTest()  {
		// se hace una instancia de la entidad ( de prueba)
		

		Prices prices1= new Prices();
		prices1.setId(1);
		prices1.setProduct_id((long) 123);
		prices1.setBrand_id(1);
		prices1.setPrice_list((long) 5);
		prices1.setCurr("EUR");
		prices1.setStart_date(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		prices1.setEnd_date(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		prices1.setPrice(42);
		prices1.setPriority(2);
		
		Prices prices2= new Prices();
		prices2.setId(2);
		prices2.setProduct_id((long) 123);
		prices2.setBrand_id(1);
		prices2.setPrice_list((long) 5);
		prices2.setCurr("EUR");
		prices2.setStart_date(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		prices2.setEnd_date(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		prices2.setPrice(42);
		prices2.setPriority(2);
		
		Prices prices3= new Prices();
		prices3.setId(3);
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

		
		given(pricesRepository.getPricesByProductIdBrandDate((Long)Mockito.any(), (Date)Mockito.any(), (Long)Mockito.any())).willReturn(listaInputPrices);

		// se llama a la funcion que desencadena la ejecucion
		List<Prices> outputPricestList = pricesController.findPricesByProductIdBrandDate((long) 123, new Date(), (long) 1);

		// Se compara el objeto inicial con el objeto generado por toda la capa de
		// clases

		assertEquals(listaInputPrices.size(), outputPricestList.size());
		assertThat(prices1).usingRecursiveComparison().isEqualTo(outputPricestList.get(0));
		assertThat(prices2).usingRecursiveComparison().isEqualTo(outputPricestList.get(1));
		assertThat(prices3).usingRecursiveComparison().isEqualTo(outputPricestList.get(2));

		
	}

}
