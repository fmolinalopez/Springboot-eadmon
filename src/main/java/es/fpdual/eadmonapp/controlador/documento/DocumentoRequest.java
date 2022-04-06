package es.fpdual.eadmonapp.controlador.documento;

import lombok.Data;

@Data
public class DocumentoRequest {

	private Integer id;
	
	private String alias;
	
	private TipoDocumentoRequest tipoDocumento;
}
