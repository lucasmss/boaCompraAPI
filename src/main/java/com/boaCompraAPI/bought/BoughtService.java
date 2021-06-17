package com.boaCompraAPI.bought;

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
public class BoughtService {

	@Autowired
	private BoughtRepository boughtRepository;

	private static final Logger LOG = LogManager.getLogger();
	private static final String ERROR_INSERT_CLIENTS = "Não foi possivel cadastrar esta compra";

	public List<Bought> findAll() {
		return boughtRepository.findAll();
	}

	public Bought findById(Long id) {
		Optional<Bought> bought = boughtRepository.findById(id);
		return bought.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Bought insert(Bought bought) throws ServiceException {
		try {
			boughtRepository.save(bought);
		} catch (Exception e) {
			LOG.warn(ERROR_INSERT_CLIENTS);
			LOG.warn(e.getMessage());
			throw new ServiceException(ERROR_INSERT_CLIENTS);
		}
		return bought;
	}

	public void delete(Long id) {
		try {
			boughtRepository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Bought update(Long id, Bought obj) {
		
		Bought bought = boughtRepository.getOne(id);
			updateData(bought, obj);
			return boughtRepository.save(bought);
		
	}

	private void updateData(Bought bought, Bought obj) {

		bought.setId(obj.getId());
		bought.setStatusPay(obj.getStatusPay());
	
	
}
