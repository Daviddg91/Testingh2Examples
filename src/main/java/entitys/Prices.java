package entitys;

 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@Entity

@Table(name = "Prices")
public class Prices {
//	BRAND_ID: foreign key de la cadena del grupo (1 = ZARA).
//	START_DATE , END_DATE: rango de fechas en el que aplica el precio tarifa indicado.
//	PRICE_LIST: Identificador de la tarifa de precios aplicable.
//	PRODUCT_ID: Identificador código de producto.
//	PRIORITY: Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de m
//	ayor prioridad (mayor valor numérico).
//	PRICE: precio final de venta.
//	CURR: iso de la moneda.
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	@Id
	private long id;
 
	private long brand_id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
	private Date start_date;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
	private Date end_date;
	
	private Long price_list;
	
	private Long product_id;
	
	private int priority;
	
	private int price;

	private String curr;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(long brand_id) {
		this.brand_id = brand_id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Long getPrice_list() {
		return price_list;
	}

	public void setPrice_list(Long price_list) {
		this.price_list = price_list;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	

	
}
