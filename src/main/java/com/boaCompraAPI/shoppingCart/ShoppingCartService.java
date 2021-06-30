package com.boaCompraAPI.shoppingCart;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.boaCompraAPI.exceptions.DatabaseException;
import com.boaCompraAPI.exceptions.ResourceNotFoundException;

@Service
public class ShoppingCartService {
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	private static final Logger LOG = LogManager.getLogger();
	private static final String ERROR_INSERT_CLIENTS = "Não foi possivel adicionar esse no carrinho";

	public List<ShoppingCart> findAll() {
		return shoppingCartRepository.findAll();
	}

	public ShoppingCart findById(Long id) {
		Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(id);
		return shoppingCart.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public ShoppingCart insert(ShoppingCart shoppingCart) throws ServiceException {
		shoppingCartRepository.save(shoppingCart);
		return shoppingCart;
	}

	public void delete(Long id) {
		try {
			shoppingCartRepository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public ShoppingCart update(Long id, ShoppingCart obj) {
		
		ShoppingCart shoppingCart = shoppingCartRepository.getOne(id);
			updateData(shoppingCart, obj);
			return shoppingCartRepository.save(shoppingCart);
		
	}

	private void updateData(ShoppingCart shoppingCart, ShoppingCart obj) {

		shoppingCart.setId(obj.getId());
	
	
}

}
