package com.boaCompraAPI.shoppingCart;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Validated
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1")
@Api(tags = { "ShoppingCart" }, description = "Operações relacionadas a gerenciamento de carrinho")
public class ShoppingCartResource {
	
	@Autowired
	ShoppingCartService shoppingCartService;

	private static final String SUCESSO = "sucesso";

	private static final String MENSAGEM = "mensagem";

	@GetMapping("/shoppingCart")
	@ApiOperation(value = "Retorna uma lista de produtos do carrinho")
	public List<ShoppingCart> findlAll() {
		 
		return shoppingCartService.findAll();
	}

	@GetMapping("/shoppingCart/{id}")
	@ApiOperation(value = "Retorna um produto do carrinho por id")
	public ResponseEntity<ShoppingCart> findById(@PathVariable("id") Long id){
		ShoppingCart shoppingCart = shoppingCartService.findById(id);
		return ResponseEntity.ok().body(shoppingCart);
	}

	@PostMapping("/shoppingCart")
	@ApiOperation(value = "Realiza o cadastro de um produto no carrinho")
	public ResponseEntity<Object> insert(@ApiParam(value = "Adicionar no carrinho", required = true) @Valid @RequestBody ShoppingCart shoppingCart) 
			throws ServiceException {
		HashMap<String, Object> response = new HashMap<>();

		try {
			shoppingCart = shoppingCartService.insert(shoppingCart);
		} catch (EntityNotFoundException e) {
			response.put(SUCESSO, false);
			response.put(MENSAGEM, e.getMessage());
			return ResponseEntity.status((HttpStatus) HttpStatus.NOT_FOUND).body(response);
		} catch (ServiceException e) {
			response.put(SUCESSO, false);
			response.put(MENSAGEM, e.getMessage());
			return ResponseEntity.status((HttpStatus) HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
		response.put(SUCESSO, true);
		response.put(MENSAGEM, "Adicionado no Carinho com sucesso!");
		response.put("Carrinho", shoppingCart);
		return ResponseEntity.ok().body(response);
	}

	@DeleteMapping(value = "/shoppingCart/{id}")
	@ApiOperation(value = "Deleta um dado no carrinho por id")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		shoppingCartService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/shoppingCart/{id}")
	@ApiOperation(value = "Atualiza carrinho")
	public ResponseEntity<ShoppingCart> update(@PathVariable Long id, @RequestBody ShoppingCart shoppingCart) {
		shoppingCart = shoppingCartService.update(id, shoppingCart);
		return ResponseEntity.ok().body(shoppingCart);
	}


}
