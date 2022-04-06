package es.fpdual.eadmonapp.controlador.expediente;

import es.fpdual.eadmonapp.modelo.expediente.Tercero;

public class TerceroRequestMapper {

	public static Tercero toTercero(TerceroRequest terceroRequest) {
		return new Tercero(terceroRequest.getId(), terceroRequest.getNombre(), terceroRequest.getDni());
	}
}
