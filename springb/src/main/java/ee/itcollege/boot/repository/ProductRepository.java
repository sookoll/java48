package ee.itcollege.boot.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ee.itcollege.boot.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	public List<Product> findByNameAllIgnoringCase(String name);
	
}
