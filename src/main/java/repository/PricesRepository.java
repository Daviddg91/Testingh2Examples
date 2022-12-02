package repository; 

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entitys.Prices;
@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {
	
	@Query("select prs from Prices prs where prs.product_id = :productId AND prs.brand_id = :brandId AND start_date <= :date AND end_date >= :date")
	 List<Prices> getPricesByProductIdBrandDate(@Param("productId") Long product_id,@Param("date") Date date,@Param("brandId") Long brand_id);
	
}



