package ar.edu.unpaz.rotiseria.model;

/**
 * Estados posibles de un pedido durante su ciclo de vida.
 *
 * Se persiste como texto en la entidad {@link Pedido}, lo que hace que la
 * base de datos sea mas legible que si se guardaran numeros ordinales.
 */
public enum EstadoPedido {
	/** Pedido cargado pero todavia no preparado. */
	CREADO,
	/** Pedido en preparacion dentro de la cocina. */
	EN_PREPARACION,
	/** Pedido listo para retirar o entregar. */
	LISTO,
	/** Pedido ya entregado al cliente. */
	ENTREGADO,
	/** Pedido cancelado antes de completarse. */
	CANCELADO
}

