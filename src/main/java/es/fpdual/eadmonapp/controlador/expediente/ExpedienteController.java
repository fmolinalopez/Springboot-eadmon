package es.fpdual.eadmonapp.controlador.expediente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.fpdual.eadmonapp.modelo.expediente.Expediente;
import es.fpdual.eadmonapp.servicio.expediente.ServicioExpediente;

@RestController
public class ExpedienteController {

	private final ServicioExpediente servicioExpediente;
	
	@Autowired
	public ExpedienteController(ServicioExpediente servicioExpediente) {
		this.servicioExpediente = servicioExpediente;
	}
	
	@GetMapping("/cargarExpedientes")
	public void cargarExpedientes() {
		this.servicioExpediente.cargarExpedientes();
	}
	
	@GetMapping("/expedientes")
	public List<Expediente> getExpedientes() {
		return this.servicioExpediente.getExpedientes();
	}
	
	@GetMapping("/expedientes/ter/{dni}")
	public List<Expediente> getExpedientesPorDniTercero(@PathVariable("dni") String dni) {
		return this.servicioExpediente.getExpedientesPorDocumentoTercero(dni);
	}
	
	@GetMapping("/expedientes/doc/{id}")
	public List<Expediente> getExpedientesPorIdDocumento(@PathVariable("id") Integer id) {
		return this.servicioExpediente.getExpedientesPorIdDocumento(id);
	}
	
	@GetMapping("/expedientes/{id}")
	public Expediente getExpedientePorId(@PathVariable("id") Integer id) {
		return this.servicioExpediente.getExpedientePorId(id);
	}
	
	@PostMapping("/expediente")
	public Expediente altaExpediente(@RequestBody ExpedienteRequest expedienteRequest) {
		return this.servicioExpediente.altaExpediente(ExpedienteRequestMapper.toExpediente(expedienteRequest));
	}
	
	@PutMapping("/expediente/{id}")
	public Expediente modificarExpediente(@PathVariable("id") Integer id, @RequestBody ExpedienteRequest expedienteRequest) {
		return this.servicioExpediente.modificarExpediente(id, ExpedienteRequestMapper.toExpediente(expedienteRequest));
	}
	
	@DeleteMapping("/expediente/{id}")
	public void eliminarExpediente(@PathVariable("id") Integer id) {
		this.servicioExpediente.eliminarExpediente(id);
	}
}
