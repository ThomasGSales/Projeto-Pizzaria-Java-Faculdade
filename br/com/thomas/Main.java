package br.com.thomas;

import java.util.Scanner;

import javax.swing.JOptionPane;


public class Main {
	
	public static void main(String args[]) {

// THOMAS GABRIEL MARTINS SALES - 3º PERIODO ENGENHARIA DE SOFTWARE
	//SISTEMA DE UMA PIZZARIA EM JAVA
		//EU OPTEI POR FAZER A ENTRADA DE DADOS DO USUARIO COM INPUTS DO SWING
		
		/*    COMECEI A ESTUDAR JAVA NA SEMANA DO ENVIO NO TRABALHO NO CLASSROOM ATÉ ENTÃO TINHA 0 CONTATO COM A LINGUAGEM
			  ENTÃO EU TE AGRADEÇO PROFESSOR PELO TRABALHO, POR CONTA DO MEDO DO DESCONHECIDO (JAVA) TIVE QUE CORRER ATRAS
			  E ACHEI INCRIVEL, POIS COMO O PRIMEIRO TRABALHO É UM PROJETINHO EU CAI DE PARAQUEDAS E ACABEI APRENDENDO MUITO
			  EM POUCO TEMPO E VOU CONTINUAR ESTUDANDO MAIS, TMJ PROFESSOR           */
		
		
		
		//Iniciando o código iniciando a string nome
		String nome = "";
		String endereco = "";
		String telefone = "";
		String email = "";
		Cliente cliente = new Cliente(nome, endereco, telefone, email);
		
		//Declarando tipo object para listar as formas de pedido e usar no swing na linha para a lista
		
		Object [] tipoPedido = {"Delivery", "Retirar no Balcao", "La carte"};
		
		//Input em forma de lista feito com swing para o usuário escolher o tipo da pizza 
		// declarei um tipo object para armazenar o dado do input em forma de string e também porque os dados tão em objeto kkkkk
		
		Object scanTipo = JOptionPane.showInputDialog(null, "Tipo do pedido", "Pizzaria", 3, null, tipoPedido, "");
		
		//String inicializada antes das condições pra não dar erro mais pra frente no código
		
		String tipo = null;
		
		
		//Inicio da primeira condição -> condição essa que vai verificar a escolha do usuário naquele input
		//de acordo com a condição (se for Delivery ou Retirada no Balcao) ele vai pedir o cadastro do cliente e acionar a classe cliente
		
		if(scanTipo.equals("Delivery")){
			
			Document.alert("Você escolheu Delivery! Será necessário o cadastro ->");
			nome = Document.prompt("Informe o seu nome");
			endereco = Document.prompt("Informe o seu endereco");
			telefone = Document.prompt("Informe o seu telefone");
			email = Document.prompt("Informe o seu email");
			
			cliente.setNome(nome);
			cliente.setEndereco(endereco);
			cliente.setTelefone(telefone);
			cliente.setEmail(email);
			
			tipo = "Delivery";
			
			
		} else if(scanTipo.equals("Retirar no Balcao")) {
			
			Document.alert("Você escolheu Reitrar no Balcao! Será necessário o cadastro ->");
			nome = Document.prompt("Informe o seu nome");
			endereco = Document.prompt("Informe o seu endereco");
		    telefone = Document.prompt("Informe o seu telefone");
			email = Document.prompt("Informe o seu email");
			
			cliente.setNome(nome);
			cliente.setEndereco(endereco);
			cliente.setTelefone(telefone);
			cliente.setEmail(email);
			
			tipo = "Retirada no Balcao";
			
			
		} else if(scanTipo.equals("La carte")) {
			
			Document.alert("Você escolheu La carte");
			tipo = "La carte";
		}
		
		
		//Depois das condições -> Acionar a classe pedido e por os atributos
		// obs: agora usando a variavel tipo (tipo de pedido) que declarei antes 
		Pedido pedido = new Pedido(1, tipo, cliente.getNome(), "", "não", "");
		
		
		
		
		float taxa = 0;
				
		if(tipo.equals("Delivery")) {
			
			Delivery delivery = new Delivery(5.50f, pedido);
			taxa = delivery.getTaxa();
			
		} else if(tipo.equals("Retirar no Balcao")) {
			
			RetiradaBalcao retiradaBalcao = new RetiradaBalcao(nome, pedido);
			
		}
		
		
		
		
		
		Object [] tipoPizza = {"Salgada", "Doce"}; 
		int scanTipoSabor = JOptionPane.showOptionDialog(null, "Escolha o tipo da pizza:", "Pizzaria", 0, 3, null, tipoPizza, "");
		
		Pizza[] pizzas = Pizza.getPizzas();
		
		if(scanTipoSabor == 0) {
	        Document.writee("Pizzas salgadas:");
	        for (Pizza pizza : pizzas) {
	            if (pizza.getTipo().equals("salgada")) {
	                System.out.println(pizza.getCodigo() + " - " + pizza.getSabor() + " (" + pizza.getTipo() + "): R$" + pizza.getValor());
	            }
	        }
		}
		else {
	        Document.writee("Pizzas doces:");
	        for (Pizza pizza : pizzas) {
	            if (pizza.getTipo().equals("doce")) {
	                System.out.println(pizza.getCodigo() + " - " + pizza.getSabor() + " (" + pizza.getTipo() + "): R$" + pizza.getValor());
	            }
	        }
	       
		}
		
		
		
		
		
		String pizzaSelecionada = null;
		float precoPizza = 0;
		
		while(pizzaSelecionada==null) {
			
			String scanCod;
			scanCod = JOptionPane.showInputDialog(null, "Veja a lista de pizzas no console e escolha o código da pizza que quiser");
		
			for(Pizza pizza: pizzas) {
				if(pizza.getCodigo() == Integer.parseInt(scanCod)) {
					pizzaSelecionada = pizza.getSabor();
					precoPizza = pizza.getValor();
					break;
				}
			}
			if(pizzaSelecionada != null) {
				pedido.setPizza(pizzaSelecionada);
				Document.alert("Você escolheu a pizza: "+ pizzaSelecionada);
			} else {
				Document.alert("pizza não encontrada");
				
			}
		}
		
		
		
		
		
		int scanBebidaYN = JOptionPane.showConfirmDialog(null, "Vai uma bebidinha?");
		Object scanBebida = null;
		if(scanBebidaYN == 0) {
			Object [ ] bbds = {"Refrigerantes", "Água", "Sucos", "Vinho"};
			Object scanBbds = JOptionPane.showInputDialog(null, "Bebidas:", "Pizzaria", 3, null, bbds, "");
			if(scanBbds.equals("Refrigerantes")) {
				Object [ ] refris = {"Coca-cola", "Guaraná"};
				scanBebida = JOptionPane.showInputDialog(null, "Refrigerantes:", "Pizzaria", 3, null, refris, "");
			} else if (scanBbds.equals("Água")) {
				Object [ ] aguas = {"Água com gás", "Água comum"};
				scanBebida = JOptionPane.showInputDialog(null, "Bebidas:", "Pizzaria", 3, null, aguas, "");
			} else if (scanBbds.equals("Sucos")) {
				Object [ ] sucos = {"Laranja", "Maracujá", "Limão"};
				scanBebida = JOptionPane.showInputDialog(null, "Bebidas:", "Pizzaria", 3, null, sucos, "");
			} else if (scanBbds.equals("Vinho")) {
				Object [ ] vinhos = {"Espumante", "Rosé", "Tinto"};
				scanBebida = JOptionPane.showInputDialog(null, "Bebidas:", "Pizzaria", 3, null, vinhos, "");
			}
			
			Bebida[] bebidas = Bebida.getBebidas();
			String bebidaSelecionada = null;
			  
			for(Bebida Bebida : bebidas) {
				if(Bebida.getNome().equals(scanBebida)) {
					bebidaSelecionada = Bebida.getNome();
					break;
					}
			}
			pedido.setBebida(bebidaSelecionada);
			Document.alert("A bebida selecionada é: " + bebidaSelecionada);
		}
		
		
		
		
		
		
		Object [ ] tipoPay = {"Pix", "Cartão de crédito", "Cartão de débito"};
		int scanPay = JOptionPane.showOptionDialog(null, "Escolha a forma de pagamento", "Pizzaria", 0, 3, null, tipoPay, "" );
		String pay = "";
		if(scanPay==0) {
			pay = "Pix";
		} else if(scanPay==1) {
			pay = "Cartão de crédito";
		} else if(scanPay==2) {
			pay = "Cartão de débito";
		}
		pedido.setPagamento(pay);
		
		
		
		Document.alert("Veja os dados do pedido no console e finalize a compra");
		
		Document.writee("\n\nDados do pedido:");
		
		Document.writee("Código: "+ pedido.getCodigo());
		Document.writee("Cliente: "+ pedido.getCliente());
		Document.writee("Endereco: "+ cliente.getEndereco());
		Document.writee("Telefone: "+ cliente.getNome());
		Document.writee("Email: "+ cliente.getEmail());
		Document.writee("Tipo de Pedido: "+ pedido.getTipo());
		Document.writee("Pizza: sabor "+ pedido.getPizza());
		Document.writee("Bebida: "+ pedido.getBebida());
		Document.writee("Forma de Pagamento: "+ pedido.getPagamento());
		Document.writee("Preço da Pizza: "+ precoPizza);
		Document.writee("Taxa: "+ taxa);
		
		Document.writee("\nTotal a pagar: "+ (precoPizza+taxa));
		
		if(tipo.equals("Retirada no Balcao")) {
			Document.writee("\n"+ pedido.getCliente() +"! Venha no balcao por favor!");
		}
		
		Scanner scanner = new Scanner(System.in);
		String scanConfirm = null;
		
		while(scanConfirm == null) {
			Document.writee("Confirme a compra -> digite \"sim\" para confirmar, \"nao\" para cancelar.");
			scanConfirm = scanner.nextLine();
			
			if(scanConfirm.equals("sim")) {
				Document.alert("Compra concluída! Tenha um ótimo dia");
			} else if(scanConfirm.equals("nao")) {
				Document.alert("Compra cancelada! Tenha um ótimo dia");
			} else if(scanConfirm != "sim" && scanConfirm != "nao") {
				Document.alert("Dado inválido! Digite exatamente como o exemplo no enunciado!");
			}
		}
			
	
	}	
		
		
	
}

