package es.fpdual.eadmonapp.modelo.expediente;

import java.util.List;

import es.fpdual.eadmonapp.modelo.documento.Documento;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Expediente {

	private final Integer id;
	
	private final String alias;
	
	private final List<Documento> documentos;
	
	private final List<Tercero> terceros;
	
	public Expediente(String alias, List<Documento> documentos, List<Tercero> terceros) {	
		this(null, alias, documentos, terceros);
	}
}
