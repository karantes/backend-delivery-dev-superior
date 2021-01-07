package br.com.arantes.delivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arantes.delivery.dto.OrderDTO;
import br.com.arantes.delivery.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<OrderDTO> findPedidosPendentes() {
		return orderRepository.findPedidosPendentes().stream().map(o -> new OrderDTO(o)).collect(Collectors.toList());
	}
}
