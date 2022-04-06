package es.fpdual.eadmonapp.servicio.documento;

import java.util.List;

import es.fpdual.eadmonapp.modelo.documento.Documento;
import es.fpdual.eadmonapp.modelo.documento.TipoDocumento;

public interface ServicioDocumento {

	public void cargarDocumentos();
	
	public List<Documento> getDocumentos();
	
	public List<Documento> getDocumentosPorTipo(TipoDocumento tipoDocumento);
	
	public Documento getDocumentoPorId(Integer id);
	
	public Documento altaDocumento(Documento documento);
	
	public Documento modificarDocumento(Integer id, Documento documento);
	
	public void eliminarDocumento(Integer id);
}
