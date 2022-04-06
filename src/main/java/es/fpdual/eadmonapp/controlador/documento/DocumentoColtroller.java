package es.fpdual.eadmonapp.controlador.documento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.fpdual.eadmonapp.modelo.documento.Documento;
import es.fpdual.eadmonapp.modelo.documento.TipoDocumento;
import es.fpdual.eadmonapp.servicio.documento.ServicioDocumento;

@RestController
public class DocumentoColtroller {

	private final ServicioDocumento servicioDocumento;
	
	@Autowired
	public DocumentoColtroller(ServicioDocumento servicioDocumento) {
		this.servicioDocumento = servicioDocumento;
	}
	
	@GetMapping("/cargarDocumentos")
	public void cargarDocumentos() {
		this.servicioDocumento.cargarDocumentos();
	}
	
	@GetMapping("/documentos")
	public List<Documento> getDocumentos() {
		return this.servicioDocumento.getDocumentos();
	}

	@GetMapping("/documentos/tdo/id/{id}")
	public List<Documento> getDocumentosPorTdo(@PathVariable("id") Integer idTdo) {
		return this.servicioDocumento.getDocumentosPorTipo(TipoDocumento.getTipoDocumentoPorId(idTdo));
	}
	
	@GetMapping("/documentos/tdo/desc/{desc}")
	public List<Documento> getDocumentosPorTdo(@PathVariable("desc") String desc) {
		return this.servicioDocumento.getDocumentosPorTipo(TipoDocumento.getTipoDocumentoPorDescripcion(desc));
	}
	
	@GetMapping("/documentos/id/{id}")
	public Documento getDocumentoPorId(@PathVariable("id") Integer id) {
		return this.servicioDocumento.getDocumentoPorId(id);
	}
	
	@PostMapping("/documento")
	public Documento altaDocumento(@RequestBody DocumentoRequest documentoRequest) {
		return this.servicioDocumento.altaDocumento(DocumentoRequestMapper.toDocumento(documentoRequest));
	}
	
	@DeleteMapping("/documento/{id}")
	public void eliminarDocumento(@PathVariable("id") Integer id) {
		this.servicioDocumento.eliminarDocumento(id);
	}
	
	@PutMapping("/documento/{id}")
	public Documento modificarDocumeno(@PathVariable("id") Integer id,
			@RequestBody DocumentoRequest documentoRequest) {
		return this.servicioDocumento.modificarDocumento(id, DocumentoRequestMapper.toDocumento(documentoRequest));
	}
}
