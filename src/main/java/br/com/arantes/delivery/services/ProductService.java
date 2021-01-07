package br.com.arantes.delivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.arantes.delivery.dto.ProductDTO;
import br.com.arantes.delivery.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		return productRepository.findByOrderByName().stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());
	}
}
