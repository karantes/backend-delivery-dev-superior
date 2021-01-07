package br.com.arantes.delivery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.arantes.delivery.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query(value = "select o from Order o join fetch o.products " + "where o.status = 0 order by o.moment")
	List<Order> findPedidosPendentes();

}
