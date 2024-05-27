package model;

import java.util.Date;
import java.util.Scanner;
import dao.VendedorDAO;

public class Vendedor extends Pessoa {

    private static VendedorDAO vendedorDAO = new VendedorDAO();

    public Vendedor(String nome, String sobrenome, Date dataNascimento, String telefone, String cidade, String estado,
                    String pais, String endereco, int numero, String email, String senha, String CPF) {
        super(nome, sobrenome, dataNascimento, telefone, CPF, cidade, estado, pais, endereco, numero, email, senha);
    }

    private void setId(int idVendedor) {
    }

    @Override
    public String capturarDados() {
        return "Nome: " + getNome() + " " + getSobrenome() + "\n" +
                "Telefone: " + getTelefone() + "\n" +
                "CPF: " + getCPF() + "\n" +
                "E-mail: " + getEmail() + "\n" +
                "Endereço: " + getEndereco() + ", " + getNumero() + "\n" +
                "Cidade: " + getCidade() + ", Estado: " + getEstado() + ", País: " + getPais() + "\n";
    }

    public static Vendedor capturarInformacoesVendedor(Scanner scanner) {

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();

        System.out.print("Data de Nascimento (dd/mm/aaaa): ");
        String dataNascimentoStr = scanner.nextLine();
        Date dataNascimento = parseDate(dataNascimentoStr);

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("CPF: ");
        String CPF = scanner.nextLine();

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        System.out.print("País: ");
        String pais = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Número: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        return new Vendedor(nome, sobrenome, dataNascimento, telefone, cidade, estado, pais, endereco, numero, email, senha, CPF);
    }

    private static Date parseDate(String dateStr) {
        try {
            return new java.text.SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    public static Vendedor deletarVendedor(Scanner scanner) {
        System.out.print("Digite o ID do Vendedor a ser deletado: ");
        int idvendedor = scanner.nextInt();
        if (vendedorDAO.vendedorExists(idvendedor)) {
            vendedorDAO.deleteVendedor(idvendedor);
            System.out.println("Vendedor deletado com sucesso." + "\n");
        } else {
            System.out.println("Vendedor com ID especificado não existe." + "\n");
        }
        return null;
    }

    public static void updateVendedor(Scanner scanner) {
        System.out.print("Digite o ID do vendedor a ser atualizado: ");
        int idVendedor = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();

        System.out.print("Novo sobrenome: ");
        String novoSobrenome = scanner.nextLine();

        System.out.print("Nova data de Nascimento (dd/mm/aaaa): ");
        String dataNascimentoStr = scanner.nextLine();
        Date novaDataNascimento = parseDate(dataNascimentoStr);

        System.out.print("Novo telefone: ");
        String novoTelefone = scanner.nextLine();

        System.out.print("Novo CPF: ");
        String novoCPF = scanner.nextLine();

        System.out.print("Nova cidade: ");
        String novaCidade = scanner.nextLine();

        System.out.print("Novo estado: ");
        String novoEstado = scanner.nextLine();

        System.out.print("Novo país: ");
        String novoPais = scanner.nextLine();

        System.out.print("Novo endereço: ");
        String novoEndereco = scanner.nextLine();

        System.out.print("Novo número: ");
        int novoNumero = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("Novo e-mail: ");
        String novoEmail = scanner.nextLine();

        System.out.print("Nova senha: ");
        String novaSenha = scanner.nextLine();

        Vendedor novoVendedor = new Vendedor(novoNome, novoSobrenome, novaDataNascimento, novoTelefone, novaCidade, novoEstado, novoPais, novoEndereco, novoNumero, novoEmail, novaSenha, novoCPF);
        vendedorDAO.updateVendedor(novoVendedor, idVendedor);

        System.out.println("Vendedor atualizado com sucesso.");
    }

}