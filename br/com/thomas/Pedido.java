package br.com.thomas;

public class Pedido {
	private int codigo;
	private String tipo;
	private String cliente;
	private String pizza;
	private String bebida;
	private String pagamento;
	
	
	public int getCodigo() {
		return codigo;
	}


	public String getTipo() {
		return tipo;
	}


	public String getCliente() {
		return cliente;
	}


	public String getPizza() {
		return pizza;
	}


	public String getBebida() {
		return bebida;
	}
	
	public Pedido(int codigo, String tipo, String cliente, String pizza, String bebida, String pagamento) {
		
		this.codigo = codigo;
		this.tipo = tipo;
		this.cliente = cliente;
		this.pizza = pizza;
		this.bebida = bebida;
		this.pagamento = pagamento;
		
	}


	public String getPagamento() {
		return pagamento;
	}


	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public void setPizza(String pizza) {
		this.pizza = pizza;
	}


	public void setBebida(String bebida) {
		this.bebida = bebida;
	}
}
