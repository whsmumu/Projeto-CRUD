package domain;

import java.util.Scanner;
import dao.*;

public class Programa {
    public static void main(String[] args) {
        menu();

    }

    private static void menu() {
        ClienteMapDAO clienteMap = new ClienteMapDAO();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("---------------------");
            System.out.println("Escolha a opção: ");
            System.out.println("{1} cadastrar");
            System.out.println("{2} consultar");
            System.out.println("{3} alterar");
            System.out.println("{4} excluir");
            System.out.println("{5} mostrar todos os clientes");
            System.out.println("{6} sair");
            System.out.println("---------------------");
            int opc = scan.nextInt();
            scan.nextLine();

            if (opc == 1) {
                System.out.print("Digite em ordem o nome, cpf, telefone, cidade e estado: ");
                String clienteCadastro = scan.nextLine();
                String[] arrayCliente = clienteCadastro.split(",");

                if (arrayCliente.length == 5) {
                    String nome = arrayCliente[0].trim();
                    Long cpf = Long.parseLong(arrayCliente[1].trim());
                    Long telefone = Long.parseLong(arrayCliente[2].trim());
                    String cidade = arrayCliente[3].trim();
                    String estado = arrayCliente[4].trim();

                    Cliente cliente = new Cliente(nome, cpf, telefone, cidade, estado);
                    clienteMap.cadastrar(cliente);
                } else {
                    System.out.println("Por favor, forneça todos os campos corretamente.");
                }

            } else if (opc == 2) {
                System.out.print("Digite o CPF: ");
                Long cpf = scan.nextLong();
                System.out.println(clienteMap.consultar(cpf));

            } else if (opc == 3) {
                System.out.println("Digite o cpf do cliente que deseja alterar: ");
                Long alterarCliente = scan.nextLong();
                scan.nextLine();

                if (clienteMap.consultar(alterarCliente) != null) {
                    System.out.print("Digite em ordem um novo nome, cpf, telefone, cidade e estado: ");
                    String clienteCadastro = scan.nextLine();
                    String[] arrayCliente = clienteCadastro.split(",");

                    if (arrayCliente.length == 5) {
                        String nome = arrayCliente[0].trim();
                        Long cpf = Long.parseLong(arrayCliente[1].trim());
                        Long telefone = Long.parseLong(arrayCliente[2].trim());
                        String cidade = arrayCliente[3].trim();
                        String estado = arrayCliente[4].trim();

                        Cliente cliente = new Cliente(nome, cpf, telefone, cidade, estado);
                        clienteMap.alterar(cliente, alterarCliente);
                    } else {
                        System.out.println("Por favor, forneça todos os campos corretamente.");
                    }
                } else {
                    System.out.println("CPF não encontrado");
                }
            } else if (opc == 4) {

                System.out.println("Digite o cpf que deseja excluir: ");
                Long excluirCliente = scan.nextLong();
                scan.nextLine();
                clienteMap.excluir(excluirCliente);

            } else if (opc == 5) {
                System.out.println(clienteMap.buscarTodos());

            } else if (opc == 6) {
                scan.close();
                break;
            }
        }
    }
}