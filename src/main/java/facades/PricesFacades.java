package facades;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entitys.Prices;
import lombok.Setter;
import repository.PricesRepository;

@Service
@Setter
public class PricesFacades {

	@Autowired
	PricesRepository pricesRespository;

	public List<Prices> getPricesByProductIdBrandDate(Long product_id,Date date, Long brand_id){ 
		 List<Prices>  pricesList = pricesRespository.getPricesByProductIdBrandDate(product_id,date,brand_id);
			 if(pricesList.isEmpty()) {
				 return null;
			}else{
				 return pricesList;
			 }
	 }
}
