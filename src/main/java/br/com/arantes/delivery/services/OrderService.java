package br.com.arantes.delivery.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.arantes.delivery.dto.OrderDTO;
import br.com.arantes.delivery.dto.ProductDTO;
import br.com.arantes.delivery.entity.Order;
import br.com.arantes.delivery.entity.OrderStatus;
import br.com.arantes.delivery.entity.Product;
import br.com.arantes.delivery.repositories.OrderRepository;
import br.com.arantes.delivery.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public List<OrderDTO> findPedidosPendentes() {
		return orderRepository.findPedidosPendentes().stream().map(o -> new OrderDTO(o)).collect(Collectors.toList());
	}

	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING);

		for (ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}

		return new OrderDTO(orderRepository.save(order));
	}
}
