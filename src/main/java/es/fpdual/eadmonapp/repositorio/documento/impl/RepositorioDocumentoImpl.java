package es.fpdual.eadmonapp.repositorio.documento.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import es.fpdual.eadmonapp.modelo.documento.Documento;
import es.fpdual.eadmonapp.modelo.documento.TipoDocumento;
import es.fpdual.eadmonapp.repositorio.documento.RepositorioDocumento;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {

	final List<Documento> documentosBBDD = new ArrayList<>();
	
	@Override
	public void cargarDocumentos() {
		this.documentosBBDD.add(new Documento(this.getSiguienteId(), "JGL-05/04/2022-1 - Propuesta", TipoDocumento.PROPUESTA));
		this.documentosBBDD.add(new Documento(this.getSiguienteId(), "JGL-05/04/2022-2 - Propuesta", TipoDocumento.PROPUESTA));
		this.documentosBBDD.add(new Documento(this.getSiguienteId(), "JGL-05/04/2022-3 - Propuesta", TipoDocumento.PROPUESTA));
		this.documentosBBDD.add(new Documento(this.getSiguienteId(), "JGL-05/04/2022-1 - Certificacion Propuesta 1", TipoDocumento.CERTIFICACION));
		this.documentosBBDD.add(new Documento(this.getSiguienteId(), "JGL-05/04/2022-2 - Certificacion Propuesta 2", TipoDocumento.CERTIFICACION));
		this.documentosBBDD.add(new Documento(this.getSiguienteId(), "JGL-05/04/2022-3 - Certificacion Propuesta 3", TipoDocumento.CERTIFICACION));
		this.documentosBBDD.add(new Documento(this.getSiguienteId(), "JGL-05/04/2022-1 - Mocion 1", TipoDocumento.MOCION));
		this.documentosBBDD.add(new Documento(this.getSiguienteId(), "JGL-05/04/2022-1 - Mocion 2", TipoDocumento.MOCION));
		this.documentosBBDD.add(new Documento(this.getSiguienteId(), "JGL-05/04/2022-1 - Mocion 3", TipoDocumento.MOCION));
		this.documentosBBDD.add(new Documento(this.getSiguienteId(), "0000005042022-1 - Factura 1", TipoDocumento.FACTURA));
		this.documentosBBDD.add(new Documento(this.getSiguienteId(), "0000005042022-2 - Factura 2", TipoDocumento.FACTURA));
		this.documentosBBDD.add(new Documento(this.getSiguienteId(), "0000005042022-3 - Factura 3", TipoDocumento.FACTURA));
	}

	@Override
	public Integer getSiguienteId() {
		return this.documentosBBDD.isEmpty() ? 1 : this.documentosBBDD.get(this.documentosBBDD.size()-1).getId()+1;
	}

	@Override
	public List<Documento> getDocumentos() {
		return this.documentosBBDD;
	}

	@Override
	public List<Documento> getDocumentosPorTipo(TipoDocumento tipoDocumento) {
		return this.documentosBBDD.stream().filter(d -> d.getTipoDocumento().equals(tipoDocumento)).collect(Collectors.toList());
	}

	@Override
	public Documento getDocumentoPorId(Integer id) {
		return this.documentosBBDD.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
	}

	@Override
	public Documento altaDocumento(Documento documento) {
		this.documentosBBDD.add(documento);
		
		return documento;
	}
	
	@Override
	public Documento modificarDocumento(Documento documento) {
		
		final Documento documentoAModifcar = this.getDocumentoPorId(documento.getId());
		
		this.documentosBBDD.set(this.documentosBBDD.indexOf(documentoAModifcar), documento);
		
		return documento;
	}
	
	@Override
	public void eliminarDocumento(Integer id) {
		this.documentosBBDD.remove(this.getDocumentoPorId(id));
	}
}
