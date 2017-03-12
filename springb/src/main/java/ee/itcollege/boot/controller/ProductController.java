package ee.itcollege.boot.controller;


import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ee.itcollege.boot.entity.Product;
import ee.itcollege.boot.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository repo;
	
	
	@RequestMapping("/")
	public String hello () {
		return "hello";
	}
	
	@RequestMapping("/list")
	public Iterable<Product> list () {
//		ArrayList<String> list = new ArrayList<String>();
//		
//		list.add("Mati");
//		list.add("Kati");
//		list.add("Kati");
//		
//		return list;
		
		Product product = new Product();
		
		product.setName("Mati");
		
		product.setCreated(new Date());
		
		repo.save(product);
		return repo.findByNameAllIgnoringCase("Mati");
		//return repo.findAll();
		
		
	}
	
	@RequestMapping("/ok")
	public Product test (@RequestParam(name="id", required = true, defaultValue = "12") long id) {
		Product product = new Product();
		product.setId(id);
		product.setName("Mati Kaal");
		product.setCreated(new Date());
		
		return product;
		
	}
}
