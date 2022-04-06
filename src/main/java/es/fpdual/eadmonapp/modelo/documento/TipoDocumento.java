package es.fpdual.eadmonapp.modelo.documento;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoDocumento {

	PROPUESTA(1,"Propuesta"), CERTIFICACION(2,"Certificación"), MOCION(3,"Mocion"), FACTURA(4,"Factura");
	
	private final Integer id;
	
	private final String descripcion;
	
	public static TipoDocumento getTipoDocumentoPorId(Integer id) {
		return Arrays.stream(TipoDocumento.values()).filter(tdo -> tdo.getId().equals(id)).findFirst().orElse(null);
	}
	
	public static TipoDocumento getTipoDocumentoPorDescripcion(String desc) {
		return Arrays.stream(TipoDocumento.values()).filter(tdo -> tdo.getDescripcion().equalsIgnoreCase(desc)).findFirst().orElse(null);
	}
}
