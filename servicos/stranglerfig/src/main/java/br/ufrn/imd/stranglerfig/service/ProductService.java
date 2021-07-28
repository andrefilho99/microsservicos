package br.ufrn.imd.stranglerfig.service;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.ufrn.imd.stranglerfig.model.ProductInfo;

@Service
public class ProductService {

	public Page<ProductInfo> findAllInCategory(Integer categoryType, PageRequest request) {
		
		//Request Page<ProductInfo> from API
		return null;
	}

	public Page<ProductInfo> findAll(PageRequest request) {
		
		//Request Page<ProductInfo> from API
		return null;
	}

	public ProductInfo findOne(String productId) {
		
		//Request ProductInfo from API
		return null;
	}

	public Object save(@Valid ProductInfo product) {
		
		//Post ProductInfo to API
		return null;
	}

	public Object update(@Valid ProductInfo product) {
		
		//Update ProductInfo to API
		return null;
	}

	public void delete(String productId) {
		//Delete ProductInfo from API
	}

}
