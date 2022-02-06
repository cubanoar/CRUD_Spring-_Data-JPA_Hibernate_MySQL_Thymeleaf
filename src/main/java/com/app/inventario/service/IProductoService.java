package com.app.inventario.service;

import java.util.List;

import com.app.inventario.entity.Producto;

public interface IProductoService {
	
	public List<Producto> listAll(String palabra);
	
	public void save(Producto producto);
	
	public Producto findOne(Long id);
	
	public void delete(Long id);

}
