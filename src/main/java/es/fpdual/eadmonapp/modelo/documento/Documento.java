package es.fpdual.eadmonapp.modelo.documento;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Documento {

	private final Integer id;
	
	private final String alias;
	
	private final TipoDocumento tipoDocumento;
	
	public Documento(String alias, TipoDocumento tipoDocumento) {
		this(null, alias, tipoDocumento);
	}
}
