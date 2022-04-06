package es.fpdual.eadmonapp.controlador.expediente;

import java.util.Objects;
import java.util.stream.Collectors;

import es.fpdual.eadmonapp.controlador.documento.DocumentoRequestMapper;
import es.fpdual.eadmonapp.modelo.expediente.Expediente;

public class ExpedienteRequestMapper {

	public static Expediente toExpediente(ExpedienteRequest expedienteRequest) {
		return new Expediente(expedienteRequest.getAlias(),
				Objects.nonNull(expedienteRequest.getDocumentos()) ? expedienteRequest.getDocumentos()
					.stream().map(DocumentoRequestMapper::toDocumento).collect(Collectors.toList()) : null,
				Objects.nonNull(expedienteRequest.getTerceros()) ? expedienteRequest.getTerceros()
					.stream().map(TerceroRequestMapper::toTercero).collect(Collectors.toList()) : null);
	}
}
