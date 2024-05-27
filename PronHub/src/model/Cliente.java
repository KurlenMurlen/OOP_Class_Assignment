package model;

import java.util.Date;
import java.util.Scanner;
import dao.ClienteDAO;

public class Cliente extends Pessoa {

    private static ClienteDAO clienteDAO = new ClienteDAO();
    private Date dataCadastro;


    // Construtor para criação de Cliente
    public Cliente(String nome, String sobrenome, Date dataNascimento, String telefone, String cidade, String estado,
                   String pais, String endereco, int numero, String email, String senha, String CPF, Date dataCadastro) {
        super(nome, sobrenome, dataNascimento, telefone, CPF, cidade, estado, pais, endereco, numero, email, senha);
        this.dataCadastro = dataCadastro;
    }

    // Construtor adicional para atualização
    public Cliente(String nome, String senha) {
        super(nome, null, null, null, null, null, null, null, null, 0, null, senha);
    }

    // Construtor padrão
    public Cliente() {
        super(null, null, null, null, null, null, null, null, null, 0, null, null);
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String capturarDados() {
        return "Nome: " + getNome() + " " + getSobrenome() + "\n" +
                "Data de Nascimento: " + getDataNascimento() + "\n" +
                "Telefone: " + getTelefone() + "\n" +
                "CPF: " + getCPF() + "\n" +
                "E-mail: " + getEmail() + "\n" +
                "Endereço: " + getEndereco() + ", " + getNumero() + "\n" +
                "Cidade: " + getCidade() + ", Estado: " + getEstado() + ", País: " + getPais() + "\n" +
                "Data de Cadastro: " + getDataCadastro() + "\n";
    }

    public static Cliente capturarInformacoesCliente(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();

        System.out.print("Data de Nascimento (dd/mm/aaaa): ");
        String dataNascimentoStr = scanner.nextLine();
        Date dataNascimento = parseDate(dataNascimentoStr);

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        System.out.print("País: ");
        String pais = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Código Postal: ");
        int codigoPostal = scanner.nextInt();
        scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Data de Cadastro (dd/mm/aaaa): ");
        String dataCadastroStr = scanner.nextLine();
        Date dataCadastro = parseDate(dataCadastroStr);
        System.out.println();

        return new Cliente(nome, sobrenome, dataNascimento, telefone, cidade, estado, pais,
                endereco, codigoPostal, email, senha, cpf, dataCadastro);
    }

    private static Date parseDate(String dateStr) {
        try {
            return new java.text.SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    public static void deletarCliente(Scanner scanner) {
        System.out.print("Digite o ID do cliente a ser deletado: ");
        int idcliente = scanner.nextInt();
        scanner.nextLine();
        if (clienteDAO.clienteExists(idcliente)) {
            clienteDAO.deleteCliente(idcliente);
            System.out.println("Cliente deletado com sucesso." + "\n");
        } else {
            System.out.println("Cliente com ID especificado não existe." + "\n");
        }
    }

    public static void updateCliente(Scanner scanner) {
        System.out.print("Digite o ID do cliente a ser atualizado: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo sobrenome: ");
        String sobrenome = scanner.nextLine();

        System.out.print("Nova data de Nascimento (dd/mm/aaaa): ");
        String dataNascimentoStr = scanner.nextLine();
        Date dataNascimento = parseDate(dataNascimentoStr);

        System.out.print("Novo telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Nova cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Novo estado: ");
        String estado = scanner.nextLine();

        System.out.print("Novo país: ");
        String pais = scanner.nextLine();

        System.out.print("Novo endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Novo número: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("Novo e-mail: ");
        String email = scanner.nextLine();

        System.out.print("Nova senha: ");
        String senha = scanner.nextLine();

        Cliente cliente = new Cliente(nome, sobrenome, dataNascimento, telefone, cidade, estado, pais, endereco, numero, email, senha, null, null);
        clienteDAO.updateCliente(cliente, idCliente);
        System.out.println("Cliente atualizado com sucesso.");
    }

}