package dao;

import java.util.Collection;

import domain.Cliente;

public interface IClienteDAO {

    public boolean cadastrar(Cliente cliente);

    public void excluir(Long cpf);

    public void alterar(Cliente cliente, Long cpfExistente);

    public Cliente consultar(Long cpf);

    public Collection<Cliente> buscarTodos();
}