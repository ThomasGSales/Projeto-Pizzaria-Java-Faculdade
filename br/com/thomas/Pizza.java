package br.com.thomas;

public class Pizza {
	private int codigo; 
	private String sabor;
	private String tipo;
	private float valor;
	
	public Pizza(int codigo, String sabor, String tipo, float valor) {
		this.codigo = codigo;
		this.sabor = sabor;
		this.tipo = tipo;
		this.valor = valor;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getSabor() {
		return sabor;
	}
	public String getTipo() {
		return tipo;
	}
	public float getValor() {
		return valor;
	}
	public static Pizza[] getPizzas(){
		Pizza[] pizzas = {
				new Pizza(1, "Calabresa", "salgada", 30.0f),
	            new Pizza(2, "Margherita", "salgada", 35.0f),
	            new Pizza(3, "Frango com catupiry", "salgada", 40.0f),
	            new Pizza(4, "Quatro queijos", "salgada", 45.0f),
	            new Pizza(5, "Portuguesa", "salgada", 40.0f),
	            new Pizza(6, "Pepperoni", "salgada", 35.0f),
	            new Pizza(7, "Atum", "salgada", 40.0f),
	            new Pizza(8, "Bacon", "salgada", 35.0f),
	            new Pizza(9, "Palmito", "salgada", 40.0f),
	            new Pizza(10, "Napolitana", "salgada", 35.0f),
	            new Pizza(11, "Chocolate", "doce", 30.0f),
	            new Pizza(12, "Banana com canela", "doce", 35.0f),
	            new Pizza(13, "Romeu e Julieta", "doce", 40.0f),
	            new Pizza(14, "Brigadeiro", "doce", 35.0f),
	            new Pizza(15, "Prestígio", "doce", 40.0f),
	            new Pizza(16, "Morango com leite condensado", "doce", 35.0f),
	            new Pizza(17, "Abacaxi com coco", "doce", 40.0f),
	            new Pizza(18, "Nutella com morango", "doce", 45.0f),
	            new Pizza(19, "Doce de leite com ameixa", "doce", 40.0f),
	            new Pizza(20, "Maçã com canela", "doce", 35.0f)		 	
		};
		return pizzas;
	}
	
	
}
