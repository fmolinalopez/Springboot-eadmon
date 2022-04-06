package es.fpdual.eadmonapp.repositorio.expediente;

import java.util.List;

import es.fpdual.eadmonapp.modelo.expediente.Expediente;

public interface RepositorioExpediente {

	public void cargarExpedientes();
	
	public Integer getSiguienteId();
	
	public List<Expediente> getExpedientes();
	
	public List<Expediente> getExpedientesPorDocumentoTercero(String dni);
	
	public List<Expediente> getExpedientesPorIdDocumento(Integer idDocumento);
	
	public Expediente getExpedientePorId(Integer id);
	
	public Expediente altaExpediente(Expediente expediente);
	
	public Expediente modificarExpediente(Expediente expediente);
	
	public void eliminarExpediente(Integer id);
	
	public Expediente eliminarDocumentoDeExpediente(Integer idExp, Integer idDoc);
}
