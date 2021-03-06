package com.boaCompraAPI.address;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.boaCompraAPI.exceptions.DatabaseException;
import com.boaCompraAPI.exceptions.ResourceNotFoundException;
import com.boaCompraAPI.exceptions.ServiceException;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;

	private static final Logger LOG = LogManager.getLogger();
	private static final String ERROR_INSERT_CLIENTS = "Não foi possivel cadastrar este endereço";

	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	public Address findById(Long id) {
		Optional<Address> address = addressRepository.findById(id);
		return address.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Address insert(Address address) throws ServiceException {
			addressRepository.save(address);
		return address;
	}

	public void delete(Long id) {
		try {
			addressRepository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Address update(Long id, Address obj) {

			Address address= addressRepository.getOne(id);
			updateData(address, obj);
			return addressRepository.save(address);
	}

	private void updateData(Address address, Address obj) {

		address.setId(obj.getId());
		address.setCep(obj.getCep());
		address.setLogradouro(obj.getLogradouro());
		address.setComplemento(obj.getComplemento());
		address.setBairro(obj.getBairro());
		address.setUf(obj.getUf());
	
	}
}
