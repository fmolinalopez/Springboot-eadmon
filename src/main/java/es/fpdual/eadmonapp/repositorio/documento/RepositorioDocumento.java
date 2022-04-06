package es.fpdual.eadmonapp.repositorio.documento;

import java.util.List;

import es.fpdual.eadmonapp.modelo.documento.Documento;
import es.fpdual.eadmonapp.modelo.documento.TipoDocumento;

public interface RepositorioDocumento {
	
	public void cargarDocumentos();
	
	public Integer getSiguienteId();  
	
	public List<Documento> getDocumentos();
	
	public List<Documento> getDocumentosPorTipo(TipoDocumento tipoDocumento);
	
	public Documento getDocumentoPorId(Integer id);
	
	public Documento altaDocumento(Documento documento);
	
	public Documento modificarDocumento(Documento documento);
	
	public void eliminarDocumento(Integer id);
}
