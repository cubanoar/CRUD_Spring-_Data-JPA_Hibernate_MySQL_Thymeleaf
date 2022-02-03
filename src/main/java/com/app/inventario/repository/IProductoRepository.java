package com.app.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.inventario.entity.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long>{

}
