// Pacote: conta.repository
// Interface: ContaRepository
// Descrição: Define as operações para manipular contas bancárias

package conta.repository;

import java.util.List;

import conta.model.Conta;

public interface ContaRepository {

	void cadastrar(Conta conta); // Método para cadastrar uma nova conta
    List<Conta> listarTodas(); // Método para listar todas as contas
    void deletar(int numero); // Método para deletar uma conta
    void atualizar(Conta conta); // Método para atualizar as informações de uma conta
    Conta buscar(int numero); // Método para buscar uma conta pelo número
}