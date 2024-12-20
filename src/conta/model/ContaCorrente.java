// Pacote: conta.model
// Classe: ContaCorrente
// Descrição: Subclasse de Conta com comportamento específico para contas correntes

package conta.model;

public class ContaCorrente extends Conta {
	
	private float limite; // Limite especial exclusivo da conta corrente
	
	// Construtor que chama o construtor da classe-mãe (Conta)
	public ContaCorrente(int numero, int agencia, String titular, float saldo, float limite) {
		// Passa o tipo 1 para indicar que é uma conta corrente (no caso, Conta Corrente é do tipo 1)
        super(numero, agencia, 1, titular, saldo); 
		this.limite = limite;
		
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	// Sobrescreve o método
	@Override
	public boolean sacar(float valor) { 
		//nem o limite cobre o estrago da conta
		if(this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\n Saldo Insuficiente!");
			return false;
		}
		
		this.setSaldo(this.getSaldo() - valor);
		System.out.println("Saque realizado com sucesso.");
		return true;		
	}
	
	// Sobrescreve o método visualizar para exibir detalhes adicionais
    @Override
	public void visualizar() {
		super.visualizar(); // Chama o método visualizar da classe-mãe
		System.out.println("Limite de Crédito: " + this.limite);
    }
    
    
	
}