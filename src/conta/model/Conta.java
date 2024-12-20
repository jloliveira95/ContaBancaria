// Pacote: conta.model
// Classe Abstrata: Conta
// Descrição: Representa uma conta bancária genérica

package conta.model;

public abstract class Conta {
	
		// Atributos comuns a todas as contas bancárias
	  	private int numero;
		private int agencia;
		private int tipo;
		private String titular;
		private float saldo;
		
		// Construtor para inicializar a conta
		public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
			this.numero = numero;
			this.agencia = agencia;
			this.tipo = tipo;
			this.titular = titular;
			this.saldo = saldo;

		}
		
		// Getters e Setters para acessar e modificar os atributos
		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public int getAgencia() {
			return agencia;
		}

		public void setAgencia(int agencia) {
			this.agencia = agencia;
		}

		public int getTipo() {
			return tipo;
		}

		public void setTipo(int tipo) {
			this.tipo = tipo;
		}

		public String getTitular() {
			return titular;
		}

		public void setTitular(String titular) {
			this.titular = titular;
		}

		public float getSaldo() {
			return saldo;
		}

		public void setSaldo(float saldo) {
			this.saldo = saldo;
		}

		// Método para realizar saque
		public boolean sacar(float valor) {
		    if (this.saldo >= valor) {
		        this.saldo -= valor;
		        System.out.println("Saque de R$" + valor + " realizado com sucesso!");
		        return true;
		    }
		    System.out.println("Saldo insuficiente.");
		    return false;
		}
		
		public void visualizar() {
		    System.out.println(this.toString());
		    String tipo = obterTipoConta();
		}
		
		@Override
		public String toString() {
		    String tipoConta = obterTipoConta();
		    return "\n\n******************" +
		           "\nDados da Conta:" +
		           "\n********************" +
		           "\nNúmero da Conta: " + this.numero +
		           "\nAgência: " + this.agencia +
		           "\nTipo da Conta: " + tipoConta +
		           "\nTitular: " + this.titular +
		           "\nSaldo: " + this.saldo;
		}
		
		// Método para realizar depósito
		public void depositar(float valor) {
			this.setSaldo(getSaldo() + valor);
			System.out.println("Depósito realizado com sucesso.");
		}
		
		private String obterTipoConta() {
			String tipo = "";
			
			switch(this.getTipo()) {
				case 1:
					tipo = "Conta Corrente";
					break;
				
				case 2:
					tipo = "Conta Poupança";
					break;
			}
			return tipo;
		}
}
