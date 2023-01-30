package controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entitys.Prices;
import lombok.Setter;
import repository.PricesRepository;
import services.PricesService;

@CrossOrigin()
@RestController
@RequestMapping("/prices")
@Setter
public class PricesController {
	@Autowired
	PricesService pricesService;

	@Autowired
	PricesRepository pricesrepo;
	
	@RequestMapping("/products/{product_id}/date/{date}/brand/{brand_id}")
	public List<Prices> findPricesByProductIdBrandDate(
			@PathVariable("product_id") Long product_id,
			@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") Date date,
			@PathVariable("brand_id") Long brand_id) {

		return pricesService.findPricesByProductIdBrandDate(product_id, date, brand_id);
	}
	
}