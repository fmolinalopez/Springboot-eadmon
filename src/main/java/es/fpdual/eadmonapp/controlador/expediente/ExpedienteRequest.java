package es.fpdual.eadmonapp.controlador.expediente;

import java.util.List;

import es.fpdual.eadmonapp.controlador.documento.DocumentoRequest;
import lombok.Data;

@Data
public class ExpedienteRequest {

	private String alias;
	
	private List<DocumentoRequest> documentos;
	
	private List<TerceroRequest> terceros;
}
