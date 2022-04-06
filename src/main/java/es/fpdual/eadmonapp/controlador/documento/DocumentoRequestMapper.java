package es.fpdual.eadmonapp.controlador.documento;

import es.fpdual.eadmonapp.modelo.documento.Documento;
import es.fpdual.eadmonapp.modelo.documento.TipoDocumento;

public class DocumentoRequestMapper {

	public static Documento toDocumento(DocumentoRequest documentoRequest) {
		return new Documento(documentoRequest.getId(), documentoRequest.getAlias(), TipoDocumento.getTipoDocumentoPorId(documentoRequest.getTipoDocumento().getId()));
	}
}
