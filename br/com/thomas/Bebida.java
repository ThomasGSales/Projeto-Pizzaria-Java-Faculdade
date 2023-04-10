package br.com.thomas;



public class Bebida {
	private String nome;
	private String tipo;
	private float valor;
	

	public Bebida(String nome, String tipo, float valor) {
		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
		
	}

	public String getNome() {
		return nome;
	}
	
	public String getTipo() {
		return tipo;
	}

	public float getValor() {
		return valor;
	}
	public static Bebida[] getBebidas() {
		Bebida[] bebidas = {
				new Bebida("Coca-cola", "Refrigerante", 5.00f),
				new Bebida("Água com gás", "Água", 4.10f),
				new Bebida("Água comum", "Água", 4.00f),
				new Bebida("Laranja", "Sucos", 6.00f),
				new Bebida("Maracujá", "Sucos", 6.00f),
				new Bebida("Limão", "Sucos", 6.00f),
				new Bebida("Espumante", "Vinho", 60.00f),
				new Bebida("Tinto", "Vinho", 50.00f),
				new Bebida("Rosé", "Vinho", 40.00f),
				new Bebida("Guaraná", "Refrigerante", 4.50f)
		};
		return bebidas;
	}
}
