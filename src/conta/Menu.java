// Projeto: Sistema Bancário Simples
// Linguagem: Java
// Objetivo: Aprender conceitos de POO, organização de código e boas práticas

package conta;


import java.util.Scanner;
import conta.model.*;
import conta.util.Cores;
import controller.ContaController;
import java.util.InputMismatchException;
import conta.repository.*;

public class Menu {

	public static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// Criar Repositório e controller para gerenciar contas
		ContaRepository contaRepository = new ContaRepositoryImpl();
        ContaController controller = new ContaController(contaRepository);
        
        int opcao;
		while (true) {
			
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO JOÃO                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     "); 
			System.out.println("*****************************************************");
			System.out.print("Entre com a opção desejada: ");
			opcao = leia.nextInt();
			
			try {
				if(opcao == 9) {
					System.out.println("\nBanco do João Luiz com Z - O seu futuro começa aqui!");
					leia.close();
					System.exit(0);
				}
				
				switch(opcao) {
				case 1:
					System.out.println("\n Criar Conta");
					criarConta(leia, controller);
	                 break;
	                 
				case 2:
					System.out.println("\n Listar todas as Contas");
                    controller.listarTodasContas(); 
                    break;
	                 
				case 3:
					System.out.println("\n Buscar Conta por número");
                    System.out.print("Digite o número da conta: ");
                    int numeroBusca = leia.nextInt();
                    controller.buscarContaPorNumero(numeroBusca); // Buscar a conta
                    break;
					
				case 4:
					System.out.println("\n Atualizar dados da Conta");
					atualizarConta(leia,controller);
	                 break;
	                 
				case 5:
					System.out.println("\n Apagar Conta");
					deletarConta(leia,controller);
	                 break;
	                 
				case 6:
					System.out.println("\n Sacar");
					sacar(leia, controller);
					break;
					
	             case 7:
					System.out.println("\n Depositar");
					depositar(leia, controller);
					break;
					
	             case 8:
					System.out.println("\n Transferir");
					break;
					
				default:
					System.out.println("\nOpção Inválida");
	                 break;
				}
	        } catch (InputMismatchException e) {
				System.out.println("Digite Valores Inteiros");
				leia.nextLine(); // Limpa o buffer
	        	}
			}
		
		}
	  private static void criarConta(Scanner leia, ContaController controller) {
		  
		  	System.out.println("Escolha o tipo de conta (1 - Corrente / 2 - Poupança): ");
	        int tipo = leia.nextInt();
	        
	        if(tipo == 1) {
	        	System.out.print("Digite o número da conta: ");
		        int numero = leia.nextInt();
		        System.out.print("Digite a agência: ");
		        int agencia = leia.nextInt();
		        System.out.print("Digite o titular: ");
		        leia.nextLine(); // Consumir a nova linha
		        String titular = leia.nextLine();
		        System.out.print("Digite o saldo inicial: ");
		        float saldo = leia.nextFloat();
		        System.out.print("Digite o limite de crédito desejado: ");
		        float limite = leia.nextFloat();
	            ContaCorrente contaCorrente = new ContaCorrente(numero, agencia, titular, saldo, limite);
	            controller.cadastrar(contaCorrente);
	            
	            
	        } else if(tipo == 2) {
	            System.out.print("Digite o aniversário (somente números): ");
	            int aniversario = leia.nextInt();
	            System.out.print("Digite o número da conta: ");
		        int numero = leia.nextInt();
		        System.out.print("Digite a agência: ");
		        int agencia = leia.nextInt();
		        System.out.print("Digite o titular: ");
		        leia.nextLine(); // Consumir a nova linha
		        String titular = leia.nextLine();
		        System.out.print("Digite o saldo inicial: ");
		        float saldo = leia.nextFloat();
	            ContaPoupanca contaPoupanca = new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario);
	            controller.cadastrar(contaPoupanca);
	            
	        } else {System.out.println("Opção inválida, Tente novamente.");}
	}
	
	  private static void atualizarConta(Scanner leia, ContaController controller) {
		    System.out.print("Digite o número da conta a ser atualizada: "); 
		    int numero = leia.nextInt(); 
		    System.out.print("Digite a nova agência: "); 
		    int agencia = leia.nextInt(); 
		    System.out.print("Digite o novo titular: "); 
		    leia.nextLine(); // Consumir a nova linha 
		    String titular = leia.nextLine(); 
		    System.out.print("Digite o novo saldo: "); 
		    float saldo = leia.nextFloat(); 
		    System.out.print("Digite o novo limite: "); 
		    float limite = leia.nextFloat();
		    
		    // Criando uma nova conta para atualizar
		    Conta contaAtualizada = controller.buscarContaPorNumero(numero);
		    if (contaAtualizada != null) {
		        contaAtualizada.setAgencia(agencia);
		        contaAtualizada.setTitular(titular);
		        contaAtualizada.setSaldo(saldo);
		        controller.atualizar(contaAtualizada);
		        System.out.println("Conta atualizada com sucesso!");
		    } else {
		        System.out.println("Conta não encontrada!");
		    }
		}
	
	private static void deletarConta(Scanner leia, ContaController controller) { 
		System.out.print("Digite o número da conta a ser deletada: "); 
		int numero = leia.nextInt(); controller.deletar(numero); 
		}
	
	public static void sacar(Scanner scanner, ContaController contaController) {
	    System.out.print("Informe o número da conta para o saque: ");
	    int numeroSacar = scanner.nextInt();
	    Conta contaSacar = contaController.buscarContaPorNumero(numeroSacar);
	    
	    if (contaSacar != null) {
	        System.out.print("Informe o valor do saque: ");
	        float valorSaque = scanner.nextFloat();
	        
	        boolean saqueRealizado = contaSacar.sacar(valorSaque);
	        
	        if (saqueRealizado) {
	            contaController.atualizar(contaSacar); // Atualiza a conta após o saque
	        } else {
	            System.out.println("Saldo insuficiente para o saque.");
	        }
	    } else {
	        System.out.println("Conta não encontrada!");
	    }
	}
	
	private static void depositar(Scanner leia, ContaController controller) { 
	    System.out.print("Digite o número da conta: "); 
	    int numero = leia.nextInt(); 
	    System.out.print("Digite o valor a ser depositado: "); 
	    float valor = leia.nextFloat(); 
	    
	    // Chama o método depositar do controller
	    controller.depositar(numero, valor);  
	}
	private static void transferir(Scanner leia, ContaController controller) { 
		System.out.print("Digite o número da conta de origem: "); 
		int numeroOrigem = leia.nextInt(); 
		System.out.print("Digite o número da conta de destino: "); 
		int numeroDestino = leia.nextInt(); 
		System.out.print("Digite o valor a ser transferido: "); 
		float valor = leia.nextFloat(); 
		controller.transferir(numeroOrigem, numeroDestino, valor); 
		}
	
	}
