package services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entitys.Prices;
import facades.PricesFacades;
import lombok.Setter;

@Service
@Setter
public class PricesService {

	@Autowired
	PricesFacades pricesFacades;

	public List<Prices> findPricesByProductIdBrandDate(Long product_id, Date date, Long brand_id) {
		return pricesFacades.getPricesByProductIdBrandDate(product_id, date, brand_id);
	}

}
