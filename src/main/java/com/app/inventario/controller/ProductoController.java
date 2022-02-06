package com.app.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.inventario.entity.Producto;
import com.app.inventario.service.IProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	
	@GetMapping("/")
	public String inicio(Model model, @Param(value = "palabra") String palabra) {
		List<Producto> listaProductos = productoService.listAll(palabra);
		model.addAttribute("listaProductos", listaProductos);
		model.addAttribute("palabra", palabra);
		return "index";
	}

	@GetMapping("/agregar_producto")
	public String agregarProducto(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		return "agregar_producto";
	}
	
	@PostMapping("/agregar_producto")
	public String guardar( Producto producto ) {
		productoService.save(producto);
		return "redirect:/";
	}
	
	/*
	 * @GetMapping("/agregar_producto/{id}") public String editar( @PathVariable
	 * Long id, Model model ) { Producto producto = productoService.findOne(id);
	 * producto.setId(producto.getId()); producto.setNombre(producto.getNombre());
	 * producto.setDescripcion(producto.getDescripcion());
	 * producto.setMarca(producto.getMarca());
	 * producto.setPrecio(producto.getPrecio()); model.addAttribute("producto",
	 * producto); return "agregar_producto";
	 * }
	 **/
	
	@GetMapping("/editar_producto/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelo = new ModelAndView("editar_producto");
		Producto producto = productoService.findOne(id);
		/*Enviamos el objeto producto a la vista "editar_producto"*/
		modelo.addObject("producto", producto);
		return modelo;
	}
	
	
	@GetMapping("/eliminar_producto/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		Producto producto = productoService.findOne(id);
		productoService.delete(producto.getId());
		return "redirect:/";
	}

}
