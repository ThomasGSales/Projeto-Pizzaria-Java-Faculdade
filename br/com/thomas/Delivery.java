package br.com.thomas;

public class Delivery {
	private float taxa;
	private Pedido pedido;
	
	public float getTaxa() {
		return taxa;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public Delivery(float taxa, Pedido pedido) {
		this.taxa = taxa;
		this.pedido = pedido;
	}
}
