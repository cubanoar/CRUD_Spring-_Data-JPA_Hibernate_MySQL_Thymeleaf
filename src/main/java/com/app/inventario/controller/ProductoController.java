package com.app.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.inventario.entity.Producto;
import com.app.inventario.service.IProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	
	@GetMapping("/")
	public String inicio(Model model) {
		List<Producto> listaProductos = productoService.findAll();
		model.addAttribute("listaProductos", listaProductos);
		return "index";
	}

}
