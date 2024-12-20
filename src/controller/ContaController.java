// Pacote: controller
// Classe: ContaController
// Descrição: Implementa as operações definidas em ContaRepository

package controller;

import java.util.List;

import conta.model.Conta;
import conta.repository.ContaRepository;


public class ContaController {
	
	  
	 
	 private ContaRepository contaRepository;
	 public ContaController(ContaRepository contaRepository) {
	        this.contaRepository = contaRepository;
	 }
	    
	  
	    public void cadastrar(Conta conta) {
	        contaRepository.cadastrar(conta);
	    	
	    }
	    
	   
	    public void atualizar(Conta conta) {
	        contaRepository.atualizar(conta);
	    }
	    
	
	    public void deletar(int numero) {
	        contaRepository.deletar(numero);
	    }

		


		
		public void transferir(int numeroOrigem, int numeroDestino, float valor) {
	        Conta contaOrigem = contaRepository.buscar(numeroOrigem);
	        Conta contaDestino = contaRepository.buscar(numeroDestino);
	        
	        if(contaOrigem != null && contaDestino != null) {
	            contaOrigem.sacar(valor);
	            contaDestino.depositar(valor);
	            contaRepository.atualizar(contaOrigem);
	            contaRepository.atualizar(contaDestino);
	        }
	    }
		
		public void listarTodasContas() {
	        List<Conta> contas = contaRepository.listarTodas(); // Método do repositório
	        if (contas.isEmpty()) {
	            System.out.println("Não há contas cadastradas.");
	        } else {
	            for (Conta conta : contas) {
	            	conta.visualizar(); // Imprime a representação da conta
	            }
	        }
	    }
		
	    public Conta buscarContaPorNumero(int numero) {
	        Conta conta = contaRepository.buscar(numero);  // Chama o repositório
	        if (conta != null) {
	            return conta;  // Conta encontrada
	        } else {
	            System.out.println("Conta não encontrada.");
	            return null;  // Caso não encontre
	        }
	    }
		
		public void depositar(int numeroConta, float valor) {
		    // Buscar a conta pelo número
		    Conta conta = buscarContaPorNumero(numeroConta);
		    
		    // Verificar se a conta foi encontrada
		    if (conta != null) {
		        if (valor > 0) {  // Verificar se o valor do depósito é válido
		            conta.depositar(valor);  // Realiza o depósito na conta
		            atualizar(conta);  // Atualiza o saldo da conta no repositório
		            System.out.println("Depósito de R$" + valor + " realizado com sucesso na conta " + numeroConta);
		        } else {
		            System.out.println("Valor de depósito inválido. O valor deve ser positivo.");
		        }
		    } else {
		        System.out.println("Conta não encontrada!");
		    }
		}
	}