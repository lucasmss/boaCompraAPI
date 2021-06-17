package com.boaCompraAPI.bought;

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
@Api(tags = { "Comprados" }, description = "Operações relacionadas a gerenciamento de compras")
public class BoughtResource {
	
	@Autowired
	BoughtService boughtService;

	private static final String SUCESSO = "sucesso";

	private static final String MENSAGEM = "mensagem";

	@GetMapping("/bought")
	@ApiOperation(value = "Retorna uma lista de Compras")
	public List<Bought> findlAll() {
		 
		return boughtService.findAll();
	}

	@GetMapping("/bought/{id}")
	@ApiOperation(value = "Retorna o compra por id")
	public ResponseEntity<Bought> findById(@PathVariable("id") Long id){
		Bought bought = boughtService.findById(id);
		return ResponseEntity.ok().body(bought);
	}

	@PostMapping("/bought")
	@ApiOperation(value = "Realiza o cadastro de compra")
	public ResponseEntity<Object> insert(@ApiParam(value = "Cadastro de compra", required = true) @Valid @RequestBody Bought bought) 
			throws ServiceException {
		HashMap<String, Object> response = new HashMap<>();

		try {
			bought = boughtService.insert(bought);
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
		response.put(MENSAGEM, "Compra cadastrado com sucesso!");
		response.put("Bought", bought);
		return ResponseEntity.ok().body(response);
	}

	@DeleteMapping(value = "/bought/{id}")
	@ApiOperation(value = "Deleta um compra por id")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		boughtService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/bought/{id}")
	@ApiOperation(value = "Atualiza compra por id")
	public ResponseEntity<Bought> update(@PathVariable Long id, @RequestBody Bought bought) {
		bought = boughtService.update(id, bought);
		return ResponseEntity.ok().body(bought);
	}

}
