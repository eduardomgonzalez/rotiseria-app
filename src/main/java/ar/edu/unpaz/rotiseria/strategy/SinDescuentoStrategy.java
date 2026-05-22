package ar.edu.unpaz.rotiseria.strategy;

import org.springframework.stereotype.Component;

@Component
public class SinDescuentoStrategy implements DescuentoStrategy {

	@Override
	public double aplicar(double subtotal) {
		return subtotal;
	}

	@Override
	public String getNombre() {
		return "Sin descuento";
	}
}

