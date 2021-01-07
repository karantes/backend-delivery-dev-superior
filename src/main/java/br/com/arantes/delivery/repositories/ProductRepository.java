package br.com.arantes.delivery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arantes.delivery.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByOrderByName();
}
