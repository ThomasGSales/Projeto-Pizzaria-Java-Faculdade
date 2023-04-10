package br.com.thomas;

public class RetiradaBalcao {
	private String cliente;
	private Pedido pedido;
	
	public RetiradaBalcao(String cliente, Pedido pedido) {
		this.cliente = cliente;
		this.pedido = pedido;
	}

	public String getCliente() {
		return cliente;
	}

	public Pedido getPedido() {
		return pedido;
	}
}
