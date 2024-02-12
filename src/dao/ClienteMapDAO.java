package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import domain.Cliente;

public class ClienteMapDAO implements IClienteDAO {

    private Map<Long, Cliente> map;

    public ClienteMapDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public boolean cadastrar(Cliente cliente) {
        if (this.map.containsKey(cliente.getCpf())) {
            System.out.println("CPF já cadastrado.");
            return false;
        }
        this.map.put(cliente.getCpf(), cliente);
        System.out.println("Cliente cadastrado com sucesso");
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = this.map.get(cpf);
        if (clienteCadastrado != null) {
            this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
            System.out.println("Cliente excluido com sucesso");
        } else {
            System.out.println("Não foi possivel excluir cliente");
        }
    }

    @Override
    public void alterar(Cliente cliente, Long cpfExistente) {
        Cliente clienteCadastrado = this.map.get(cpfExistente);

        if (clienteCadastrado != null) {

            if (!cpfExistente.equals(cliente.getCpf())) {
                this.map.remove(cpfExistente);
                this.map.put(cliente.getCpf(), clienteCadastrado);
            }

            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setCpf(cliente.getCpf());
            clienteCadastrado.setEstado(cliente.getEstado());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setTelefone(cliente.getTelefone());

            System.out.println("Cliente alterado com sucesso");
        } else {
            System.out.println("Não foi possivel alterar o cliente");
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
}
