package ar.com.educacionit.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.services.SociosService;

@RestController
@RequestMapping("/socio")
public class SociosController {

	//D.I
	@Autowired
	private SociosService sociosService;
	
	
	
	@GetMapping("/{id}") 
	public ResponseEntity preEdit(
			@PathVariable(name="id",required = true ) Long id
			) {
		
		Socios socios = this.sociosService.buscarSocio(id);
		if(socios != null) {
			return ResponseEntity.ok(socios);				
		}	
	
		return ResponseEntity.notFound().build();
	}
}