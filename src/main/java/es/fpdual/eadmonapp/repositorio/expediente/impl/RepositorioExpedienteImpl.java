package es.fpdual.eadmonapp.repositorio.expediente.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import es.fpdual.eadmonapp.modelo.documento.Documento;
import es.fpdual.eadmonapp.modelo.documento.TipoDocumento;
import es.fpdual.eadmonapp.modelo.expediente.Expediente;
import es.fpdual.eadmonapp.modelo.expediente.Tercero;
import es.fpdual.eadmonapp.repositorio.expediente.RepositorioExpediente;

@Repository
public class RepositorioExpedienteImpl implements RepositorioExpediente{

	private final List<Expediente> expedientesBBDD = new ArrayList<>();
	
	@Override
	public void cargarExpedientes() {
		final List<Documento> documentosExpediente1 = new ArrayList<>();
		final List<Documento> documentosExpediente2 = new ArrayList<>();
		final List<Documento> documentosExpediente3 = new ArrayList<>();
		final Documento propuesta = new Documento(1, "JGL-05/04/2022-1 - Propuesta", TipoDocumento.PROPUESTA);
		final Documento certificacion = new Documento(2, "JGL-05/04/2022-1 - Certificacion Propuesta 1", TipoDocumento.CERTIFICACION);
		final Documento mocion = new Documento(3, "JGL-05/04/2022-1 - Mocion 1", TipoDocumento.MOCION);
		final Documento factura = new Documento(4, "0000005042022-1 - Factura 1", TipoDocumento.FACTURA);
		
		documentosExpediente1.add(propuesta);
		documentosExpediente1.add(certificacion);
		documentosExpediente1.add(mocion);
		documentosExpediente2.add(propuesta);
		documentosExpediente2.add(mocion);
		documentosExpediente2.add(factura);
		documentosExpediente3.add(certificacion);
		documentosExpediente3.add(mocion);
		documentosExpediente3.add(factura);

		final List<Tercero> tercerosExpediente1 = new ArrayList<>();
		final List<Tercero> tercerosExpediente2 = new ArrayList<>();
		final List<Tercero> tercerosExpediente3 = new ArrayList<>();
		final Tercero tercero1 = new Tercero(1, "Fran", "11111111-A");
		final Tercero tercero2 = new Tercero(2, "Miguel", "11111111-B");
		final Tercero tercero3 = new Tercero(3, "Jesus", "11111111-C");
		final Tercero tercero4 = new Tercero(4, "Alvaro", "11111111-D");
		
		tercerosExpediente1.add(tercero1);
		tercerosExpediente1.add(tercero2);
		tercerosExpediente1.add(tercero3);
		tercerosExpediente2.add(tercero1);
		tercerosExpediente2.add(tercero3);
		tercerosExpediente2.add(tercero4);
		tercerosExpediente3.add(tercero2);
		tercerosExpediente3.add(tercero3);
		tercerosExpediente3.add(tercero4);
		
		this.expedientesBBDD.add(new Expediente(1, "Expediente 1", documentosExpediente1, tercerosExpediente1));
		this.expedientesBBDD.add(new Expediente(2, "Expediente 2", documentosExpediente2, tercerosExpediente2));
		this.expedientesBBDD.add(new Expediente(3, "Expediente 3", documentosExpediente3, tercerosExpediente3));
	}

	@Override
	public List<Expediente> getExpedientes() {
		return this.expedientesBBDD;
	}

	@Override
	public Expediente altaExpediente(Expediente expediente) {
		this.expedientesBBDD.add(expediente);
		
		return expediente;
	}

	@Override
	public Integer getSiguienteId() {
		return this.expedientesBBDD.isEmpty() ? 1 : this.expedientesBBDD.get(this.expedientesBBDD.size()-1).getId()+1;
	}

	@Override
	public List<Expediente> getExpedientesPorDocumentoTercero(String dni) {
		return this.expedientesBBDD.stream()
				.filter(exp -> this.expedienteContieneTerceroConDni(exp, dni)).collect(Collectors.toList());
	}
	
	@Override
	public List<Expediente> getExpedientesPorIdDocumento(Integer idDocumento) {
		return this.expedientesBBDD.stream()
				.filter(exp -> this.expedienteContieneIdDocumento(exp, idDocumento)).collect(Collectors.toList());
	}

	@Override
	public Expediente getExpedientePorId(Integer id) {
		return this.expedientesBBDD.stream().filter(exp -> exp.getId().equals(id)).findFirst().orElse(null);
	}

	private Boolean expedienteContieneTerceroConDni(Expediente exp, String dni) {
		return exp.getTerceros().stream().anyMatch(ter -> ter.getDni().equalsIgnoreCase(dni));
	}
	
	private Boolean expedienteContieneIdDocumento(Expediente exp, Integer idDocumento) {
		return exp.getDocumentos().stream().anyMatch(doc -> doc.getId().equals(idDocumento));
	}

	@Override
	public Expediente modificarExpediente(Expediente expediente) {
		final Expediente expedienteAModificar = this.getExpedientePorId(expediente.getId());
		
		if (Objects.nonNull(expedienteAModificar)) {
			this.expedientesBBDD.set(this.expedientesBBDD.indexOf(expedienteAModificar), expediente);
			return expediente;
		}
		
		return null;
	}

	@Override
	public void eliminarExpediente(Integer id) {
		this.expedientesBBDD.remove(this.expedientesBBDD.indexOf(this.getExpedientePorId(id)));
	}
}
