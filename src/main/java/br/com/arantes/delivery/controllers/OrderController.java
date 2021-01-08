package br.com.arantes.delivery.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.arantes.delivery.dto.OrderDTO;
import br.com.arantes.delivery.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<List<OrderDTO>> findPedidosPendentes() {
		return ResponseEntity.ok().body(orderService.findPedidosPendentes());
	}

	@PostMapping
	public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto) {
		dto = orderService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
