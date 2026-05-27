package ar.edu.unpaz.rotiseria.strategy;

/**
 * Contrato para reglas de descuento aplicables a un pedido.
 *
 * Este es el patron Strategy: cada implementacion puede calcular el total de
 * una forma distinta sin modificar el servicio de pedidos.
 */
public interface DescuentoStrategy {

	/**
	 * Aplica la regla de descuento sobre un subtotal.
	 *
	 * @param subtotal importe original antes del descuento
	 * @return importe final luego de aplicar la regla
	 */
	double aplicar(double subtotal);

	/**
	 * Nombre legible de la estrategia.
	 *
	 * @return nombre de la regla de descuento
	 */
	String getNombre();
}

