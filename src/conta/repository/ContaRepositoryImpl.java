package conta.repository;

import conta.model.Conta;
import java.util.ArrayList;
import java.util.List;

public class ContaRepositoryImpl implements ContaRepository {
    private List<Conta> contas = new ArrayList<>();

    // Implementação do método
    public void cadastrar(Conta conta) {
        contas.add(conta);
        System.out.println("Conta cadastrada com sucesso!");
    }

    @Override
    public List<Conta> listarTodas() {
        return contas; // Retorna a lista de contas
    }
    
    // Implementação do método para deletar uma conta pelo número
    @Override
    public void deletar(int numero) {
        contas.removeIf(conta -> conta.getNumero() == numero);
        System.out.println("Conta deletada com sucesso!");
    }

    
    @Override
    public void atualizar(Conta conta) {
        // Atualização simples para encontrar e substituir a conta
        for(int i = 0; i < contas.size(); i++) {
            if(contas.get(i).getNumero() == conta.getNumero()) {
                contas.set(i, conta);
                System.out.println("Conta atualizada com sucesso!");
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    //buscar uma conta pelo número
    @Override
    public Conta buscar(int numero) {
    	System.out.println("Buscando conta com o número: " + numero);
        for(Conta conta : contas) {
        	System.out.println("Verificando conta: " + conta);
            if(conta.getNumero() == numero) {
                return conta;
            }
        }
        return null; // Retorna null caso a conta não seja encontrada
    }
}