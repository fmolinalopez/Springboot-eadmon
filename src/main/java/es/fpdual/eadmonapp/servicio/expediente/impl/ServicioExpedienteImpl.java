package es.fpdual.eadmonapp.servicio.expediente.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import es.fpdual.eadmonapp.modelo.expediente.Expediente;
import es.fpdual.eadmonapp.repositorio.expediente.RepositorioExpediente;
import es.fpdual.eadmonapp.servicio.expediente.ServicioExpediente;

@Service
public class ServicioExpedienteImpl implements ServicioExpediente {

	private final RepositorioExpediente repositorioExpediente;
	
	public ServicioExpedienteImpl(RepositorioExpediente repositorioExpediente) {
		this.repositorioExpediente = repositorioExpediente;
	}
	
	@Override
	public void cargarExpedientes() {
		this.repositorioExpediente.cargarExpedientes();
	}

	@Override
	public List<Expediente> getExpedientes() {
		return this.repositorioExpediente.getExpedientes();
	}

	@Override
	public Expediente altaExpediente(Expediente expediente) {
		
		return this.repositorioExpediente.altaExpediente(
				new Expediente(this.repositorioExpediente.getSiguienteId(),
						expediente.getAlias(), expediente.getDocumentos(),
						expediente.getTerceros()));
	}

	@Override
	public List<Expediente> getExpedientesPorDocumentoTercero(String dni) {
		return this.repositorioExpediente.getExpedientesPorDocumentoTercero(dni);
	}

	@Override
	public List<Expediente> getExpedientesPorIdDocumento(Integer idDocumento) {
		return this.repositorioExpediente.getExpedientesPorIdDocumento(idDocumento);
	}
	
	@Override
	public Expediente getExpedientePorId(Integer id) {
		return this.repositorioExpediente.getExpedientePorId(id);
	}

	@Override
	public Expediente modificarExpediente(Integer id, Expediente expediente) {
		
		final Expediente expedienteAModificar = this.repositorioExpediente.getExpedientePorId(id);
		
		if (Objects.nonNull(expedienteAModificar)) {
			return this.repositorioExpediente.modificarExpediente(
					this.completarExpedienteAModificar(id, expediente, expedienteAModificar));
		}
		
		return null;
	}

	private Expediente completarExpedienteAModificar(Integer id, Expediente expediente,
			final Expediente expedienteAModificar) {
		return new Expediente(id, Objects.nonNull(expediente.getAlias()) ? expediente.getAlias() : expedienteAModificar.getAlias(),
				Objects.nonNull(expediente.getDocumentos()) && !expediente.getDocumentos().isEmpty() ? expediente.getDocumentos() : expedienteAModificar.getDocumentos(), 
				Objects.nonNull(expediente.getTerceros()) && !expediente.getTerceros().isEmpty() ? expediente.getTerceros() : expedienteAModificar.getTerceros());
	}

	@Override
	public void eliminarExpediente(Integer id) {
		this.repositorioExpediente.eliminarExpediente(id);
	}
}
