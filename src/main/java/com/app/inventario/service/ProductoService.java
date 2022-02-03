package com.app.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.inventario.entity.Producto;
import com.app.inventario.repository.IProductoRepository;

@Service
public class ProductoService implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Producto producto) {
		productoRepository.save(producto);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findOne(Long id) {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productoRepository.deleteById(id);
		
	}
	
	
}
