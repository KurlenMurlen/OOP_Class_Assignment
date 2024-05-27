package model;

import java.util.Date;
import java.util.Scanner;
import dao.FornecedorDAO;

public class Fornecedor extends Pessoa {
    private String nomeFantasia;

    private String razaoSocial;
    private String CNPJ;

    private static FornecedorDAO fornecedorDAO = new FornecedorDAO();

    public Fornecedor(String nomeFantasia, String razaoSocial, String CNPJ, String email, String telefone, String cidade,
                      String estado, String pais, String endereco, int numero, String senha) {
        super(email, senha, telefone, cidade, estado, pais, endereco, numero);
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.CNPJ = CNPJ;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    @Override
    public String capturarDados() {
        return "Nome Fantasia: " + getNomeFantasia() + "\n" +
                "Razão Social: " + getRazaoSocial() + "\n" +
                "CNPJ: " + getCNPJ() + "\n" +
                "E-mail: " + getEmail() + "\n" +
                "Telefone: " + getTelefone() + "\n" +
                "Endereço: " + getEndereco() + ", " + getNumero() + "\n" +
                "Cidade: " + getCidade() + ", Estado: " + getEstado() + ", País: " + getPais() + "\n" +
                "Número: " + getNumero();
    }

    public static Fornecedor capturarInformacoesFornecedor(Scanner scanner) {
        System.out.print("Nome Fantasia: ");
        String nomeFantasia = scanner.nextLine();

        System.out.print("Razão Social: ");
        String razaoSocial = scanner.nextLine();

        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

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

        System.out.print("Número: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        return new Fornecedor(nomeFantasia, razaoSocial, cnpj, email, telefone, cidade, estado, pais, endereco, numero, senha);
    }

    public static void deletarFornecedor(Scanner scanner) {
        System.out.print("Digite o ID do Fornecedor a ser deletado: ");
        int idfornecedor = scanner.nextInt();
        if (fornecedorDAO.fornecedorExists(idfornecedor)) {
            fornecedorDAO.deleteFornecedor(idfornecedor);
            System.out.println("Fornecedor deletado com sucesso.\n");
        } else {
            System.out.println("Fornecedor com ID especificado não existe.\n");
        }
    }

    public static void updateFornecedor(Scanner scanner) {
        System.out.print("Digite o ID do fornecedor a ser atualizado: ");
        int idFornecedor = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo nome fantasia: ");
        String nomeFantasia = scanner.nextLine();

        System.out.print("Nova razão social: ");
        String razaoSocial = scanner.nextLine();

        System.out.print("Novo CNPJ: ");
        String cnpj = scanner.nextLine();

        System.out.print("Novo e-mail: ");
        String email = scanner.nextLine();

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

        System.out.print("Nova senha: ");
        String senha = scanner.nextLine();

        Fornecedor fornecedor = new Fornecedor(nomeFantasia, razaoSocial, cnpj, email, telefone, cidade, estado, pais, endereco, numero, senha);
        fornecedorDAO.updateFornecedor(fornecedor, idFornecedor);
        System.out.println("Fornecedor atualizado com sucesso.");
    }

}
