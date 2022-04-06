package es.fpdual.eadmonapp.servicio.documento.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.eadmonapp.modelo.documento.Documento;
import es.fpdual.eadmonapp.modelo.documento.TipoDocumento;
import es.fpdual.eadmonapp.repositorio.documento.RepositorioDocumento;
import es.fpdual.eadmonapp.servicio.documento.ServicioDocumento;

@Service
public class ServicioDocumentoImpl implements ServicioDocumento {

	private final RepositorioDocumento repositorioDocumento;
	
	@Autowired
	public ServicioDocumentoImpl(RepositorioDocumento repositoioDocumento) {
		this.repositorioDocumento = repositoioDocumento;
	}
	
	@Override
	public void cargarDocumentos() {
		this.repositorioDocumento.cargarDocumentos();
	}

	@Override
	public List<Documento> getDocumentos() {
		return this.repositorioDocumento.getDocumentos();
	}

	@Override
	public List<Documento> getDocumentosPorTipo(TipoDocumento tipoDocumento) {
		return this.repositorioDocumento.getDocumentosPorTipo(tipoDocumento);
	}

	@Override
	public Documento getDocumentoPorId(Integer id) {
		return this.repositorioDocumento.getDocumentoPorId(id);
	}

	@Override
	public Documento altaDocumento(Documento documento) {
		
		final Documento documentoAInsertar = new Documento(this.repositorioDocumento.getSiguienteId(), documento.getAlias(), documento.getTipoDocumento());
		
		return this.repositorioDocumento.altaDocumento(documentoAInsertar);
	}

	@Override
	public Documento modificarDocumento(Integer id, Documento documento) {
		
		if (Objects.nonNull(this.getDocumentoPorId(id))) {
			return this.repositorioDocumento.modificarDocumento(new Documento(id, documento.getAlias(), documento.getTipoDocumento()));
		}
		
		return null;
	}

	@Override
	public void eliminarDocumento(Integer id) {
		this.repositorioDocumento.eliminarDocumento(id);
	}

}
