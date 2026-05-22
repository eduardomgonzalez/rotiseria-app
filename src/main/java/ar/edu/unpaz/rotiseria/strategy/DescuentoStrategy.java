package ar.edu.unpaz.rotiseria.strategy;

public interface DescuentoStrategy {

	double aplicar(double subtotal);

	String getNombre();
}

