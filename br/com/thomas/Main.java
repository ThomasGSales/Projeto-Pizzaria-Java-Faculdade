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
		
		
		
		// declaração da variavel taxa tipo float e iniciando ela com 0
		float taxa = 0;
		
		//Mais outra condição depois da classe pedido ser instanciada ->
		// Condição que visa instanciar a classe de acordo com o tipo do pedido
		// esses 2 tipos tem cada um sua propria classe
		if(tipo.equals("Delivery")) {
			
			Delivery delivery = new Delivery(5.50f, pedido);
			taxa = delivery.getTaxa();
			
		} else if(tipo.equals("Retirar no Balcao")) {
			
			RetiradaBalcao retiradaBalcao = new RetiradaBalcao(nome, pedido);
			
		}
		
		
		
		
		//criando um tipo Object para armazenar as String que serão as 2 oções do swing a seguir
		//logo depois de declarar o tipo Object eu inicie o swing com as opções do proprio Object
		// declarei uma variavel tipo >>inteira<< para armazenar a escolha do usuário
		// declarei como inteiro pois o JOptionPane do tipo Option Dialog armazena a resposta com numeros inteiros apartir do 0
		// ou seja se o usuário escolher a primeira opção ele vai armazenar o numero -> 0 
		// e se escolher a segunda ele armazena o numero -> 1 (e assim por diante)
		Object [] tipoPizza = {"Salgada", "Doce"}; 
		int scanTipoSabor = JOptionPane.showOptionDialog(null, "Escolha o tipo da pizza:", "Pizzaria", 0, 3, null, tipoPizza, "");
		
		
		
		// Apartir daqui tive um pouco de dificuldade na hora do desenvolvimento >>
		// não sei explicar muito bem teoricamente mas meio que instanciei um array da classe pizza
		
		Pizza[] pizzas = Pizza.getPizzas();
		
		// Aqui inicia a condição que envolve a variavel inteira de antes que armazenou a escolha do usuário
		// a condição serve pra caso o usuário tenha escolhido as pizzas Salgadas -> apareça apenas as salgadas ou ao contrario
		if(scanTipoSabor == 0) {
	        	Document.writee("Pizzas salgadas:");
			
			/* ainda dentro da condição, eu inicio um for loop com uma condição dentro pra ele localizar apenas as pizzas na classe pizza 
			com o atributo tipo = salgada e printar todas no console */
	       		for (Pizza pizza : pizzas) {
	            		if (pizza.getTipo().equals("salgada")) {
	                	System.out.println(pizza.getCodigo() + " - " + pizza.getSabor() + " (" + pizza.getTipo() + "): R$" + pizza.getValor());
	           		}	
	       		}
		} // no else é literalmente a mesma coisa caso ele escolha a opção que não retorne 0 (literalmente a unica que resta que é a doce)
		else {
	        Document.writee("Pizzas doces:");
	        for (Pizza pizza : pizzas) {
	            if (pizza.getTipo().equals("doce")) {
	                System.out.println(pizza.getCodigo() + " - " + pizza.getSabor() + " (" + pizza.getTipo() + "): R$" + pizza.getValor());
	            }
	        }
	       
		}
		
		
		
		
		/* Após ele ver no console a lista de pizzas, ele tem que selecionar uma né? então aqui eu começo esse processo,
		confesso que o metodo que eu usei não é o melhor visto que vou usar o swing junto com o console, mas eu pretendo melhorar em breve
		essa parte */
		
		// começo essa etapa inicializando a string pizzaSelecionada e o tipo float precoPizza
		String pizzaSelecionada = null;
		float precoPizza = 0;
		
		//inicio aqui um while loop pra ele recomeçar todo o processo caso o usuário clique em ok sem informar nada no input
		while(pizzaSelecionada==null) {
			
			//Já dentro do loop, o inicio do processo é declarando uma String chamada scanCod que vai armazenar o input do usuário
			String scanCod;
			scanCod = JOptionPane.showInputDialog(null, "Veja a lista de pizzas no console e escolha o código da pizza que quiser");
			//nesse momento a usuário terá que observar a lista de pizzas no console e informar o numero da pizza que ele desejar
			// eu usei tipo String para armazenar o código porque esse tipo de JOption aparentemente só armazena string 
			// mas eu fiz uma gambiarra para arrumar isso depois
		
			
			// ainda dentro do loop eu abro outro loop só que em for kkkkkk
			// mas com o esquema parecido com o usado pra printar as pizzas na tela antes
			for(Pizza pizza: pizzas) {
				
				//abro uma condição dentro do for para ele puxar o codigo da pizza que for igual o numero que o usuário informou
				// como a variavel era tipo String, eu usei o Integer.parseInt para tornala em Inteira nessa comparação
				if(pizza.getCodigo() == Integer.parseInt(scanCod)) {
					
					// caso a condição seja verdadeira ele vai armazenar o atributo sabor da mesma em pizzaSelecionada
					// e também o atributo valor dela em precoPizza
					pizzaSelecionada = pizza.getSabor();
					precoPizza = pizza.getValor();
					break;
				}
			}
			
			/*	depois dos processos anteriores temos outra condição para caso tenha dado tudo certo ele vai verificar se tem algo
			armazenado na variavel pizzaSelecionada e se tiver ele vai setar o atributo que ela armazenou no atributo pizza da classe
			pedido    */
			if(pizzaSelecionada != null) {
				pedido.setPizza(pizzaSelecionada);
				Document.alert("Você escolheu a pizza: "+ pizzaSelecionada);
			} else { // mas caso o usuário não tenha escolhido nenhnuma pizza anteriormente, antes do loop começar denovo, ele vai avisar o erro
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

