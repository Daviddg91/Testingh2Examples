import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.google.gson.Gson;

import entitys.Prices;

@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PricesControllerTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	@DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 ")
	public void Test1() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
		Date date1 = formatter.parse("2020-06-14-00.00.00");
		Date date2 = formatter.parse("2020-12-31-23.59.59");

		Prices prices1 = new Prices();

		prices1.setProduct_id((long) 35455);
		prices1.setBrand_id(1);
		prices1.setPrice_list((long) 1);
		prices1.setCurr("EUR");
		prices1.setStart_date(date1);
		prices1.setEnd_date(date2);
		prices1.setPrice(36);
		prices1.setPriority(0);

		ResultActions endpointAction = mockMvc.perform(get("/prices/products/35455/date/2020-06-14-10.00.00/brand/1"))
				.andExpect(status().isOk());

		String JsonOutputString = endpointAction.andReturn().getResponse().getContentAsString();

		Prices[] outputPricestList = new Gson().fromJson(JsonOutputString, Prices[].class);

		prices1.setId(outputPricestList[0].getId());

		assertThat(prices1).usingRecursiveComparison().isEqualTo(outputPricestList[0]);

	}

	@Test
	@DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 ")
	public void Test2() throws Exception {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
		Date date1 = formatter.parse("2020-06-14-00.00.00");
		Date date2 = formatter.parse("2020-12-31-23.59.59");

		Prices prices1 = new Prices();

		prices1.setProduct_id((long) 35455);
		prices1.setBrand_id(1);
		prices1.setPrice_list((long) 1);
		prices1.setCurr("EUR");
		prices1.setStart_date(date1);
		prices1.setEnd_date(date2);
		prices1.setPrice(36);
		prices1.setPriority(0);

		ResultActions endpointAction = mockMvc.perform(get("/prices/products/35455/date/2020-06-14-16.00.00/brand/1"))
				.andExpect(status().isOk());

		String JsonOutputString = endpointAction.andReturn().getResponse().getContentAsString();

		Prices[] outputPricestList = new Gson().fromJson(JsonOutputString, Prices[].class);

		prices1.setId(outputPricestList[0].getId());

		assertThat(prices1).usingRecursiveComparison().isEqualTo(outputPricestList[0]);

	}

	@Test
	@DisplayName(" Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 ")
	public void Test3() throws Exception {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
		Date date1 = formatter.parse("2020-06-14-00.00.00");
		Date date2 = formatter.parse("2020-12-31-23.59.59");

		Prices prices1 = new Prices();

		prices1.setProduct_id((long) 35455);
		prices1.setBrand_id(1);
		prices1.setPrice_list((long) 1);
		prices1.setCurr("EUR");
		prices1.setStart_date(date1);
		prices1.setEnd_date(date2);
		prices1.setPrice(36);
		prices1.setPriority(0);

		ResultActions endpointAction = mockMvc.perform(get("/prices/products/35455/date/2020-06-14-21.00.00/brand/1"))
				.andExpect(status().isOk());

		String JsonOutputString = endpointAction.andReturn().getResponse().getContentAsString();

		Prices[] outputPricestList = new Gson().fromJson(JsonOutputString, Prices[].class);

		prices1.setId(outputPricestList[0].getId());

		assertThat(prices1).usingRecursiveComparison().isEqualTo(outputPricestList[0]);

	}

	@Test
	@DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 ")
	public void Test4() throws Exception {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
		Date date1 = formatter.parse("2020-06-14-00.00.00");
		Date date2 = formatter.parse("2020-12-31-23.59.59");

		Prices prices1 = new Prices();

		prices1.setProduct_id((long) 35455);
		prices1.setBrand_id(1);
		prices1.setPrice_list((long) 1);
		prices1.setCurr("EUR");
		prices1.setStart_date(date1);
		prices1.setEnd_date(date2);
		prices1.setPrice(36);
		prices1.setPriority(0);

		ResultActions endpointAction = mockMvc.perform(get("/prices/products/35455/date/2020-06-15-21.00.00/brand/1"))
				.andExpect(status().isOk());

		String JsonOutputString = endpointAction.andReturn().getResponse().getContentAsString();

		Prices[] outputPricestList = new Gson().fromJson(JsonOutputString, Prices[].class);

		prices1.setId(outputPricestList[0].getId());

		assertThat(prices1).usingRecursiveComparison().isEqualTo(outputPricestList[0]);

	}

	@Test
	@DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 ")
	public void Test5() throws Exception {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
		Date date1 = formatter.parse("2020-06-14-00.00.00");
		Date date2 = formatter.parse("2020-12-31-23.59.59");

		Prices prices1 = new Prices();

		prices1.setProduct_id((long) 35455);
		prices1.setBrand_id(1);
		prices1.setPrice_list((long) 1);
		prices1.setCurr("EUR");
		prices1.setStart_date(date1);
		prices1.setEnd_date(date2);
		prices1.setPrice(36);
		prices1.setPriority(0);

		ResultActions endpointAction = mockMvc.perform(get("/prices/products/35455/date/2020-06-16-21.00.00/brand/1"))
				.andExpect(status().isOk());

		String JsonOutputString = endpointAction.andReturn().getResponse().getContentAsString();

		Prices[] outputPricestList = new Gson().fromJson(JsonOutputString, Prices[].class);

		prices1.setId(outputPricestList[0].getId());

		assertThat(prices1).usingRecursiveComparison().isEqualTo(outputPricestList[0]);

	}

}