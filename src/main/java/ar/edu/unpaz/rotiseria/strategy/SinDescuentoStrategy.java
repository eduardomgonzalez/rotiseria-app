package ar.edu.unpaz.rotiseria.strategy;

import org.springframework.stereotype.Component;

/**
 * Estrategia por defecto que no modifica el subtotal.
 *
 * Se registra como componente de Spring para que pueda inyectarse donde se
 * necesite un {@link DescuentoStrategy}.
 */
@Component
public class SinDescuentoStrategy implements DescuentoStrategy {

	/**
	 * Devuelve el mismo subtotal recibido, sin aplicar rebajas.
	 *
	 * @param subtotal importe original antes del descuento
	 * @return el mismo subtotal recibido
	 */
	@Override
	public double aplicar(double subtotal) {
		return subtotal;
	}

	/**
	 * Obtiene el nombre descriptivo de esta estrategia.
	 *
	 * @return texto "Sin descuento"
	 */
	@Override
	public String getNombre() {
		return "Sin descuento";
	}
}

