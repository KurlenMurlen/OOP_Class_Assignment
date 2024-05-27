package model;

import java.util.Scanner;
import dao.ProdutoDAO;

public class Produto {
    private int idProduto;
    private String descricao;
    private int quantidade;
    private double preco;
    private int idFornecedor;

    private static ProdutoDAO produtoDAO = new ProdutoDAO();

    public Produto(String descricao, int quantidade, double preco, int idFornecedor) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.idFornecedor = idFornecedor;
    }

    // Getters e Setters
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getidFornecedor() {
        return idFornecedor;
    }

    public void setidFornecedor(int idfornecedor) {
        this.idFornecedor = idfornecedor;
    }

    public static Produto capturarInformacoesProduto(Scanner scanner) {
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Quantidade de produtos: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("ID do Fornecedor: ");
        int idFornecedor = scanner.nextInt();
        scanner.nextLine();

        return new Produto(descricao, quantidade, preco, idFornecedor);
    }

    public static Produto deletarProduto(Scanner scanner) {
        System.out.print("Digite o ID do produto a ser deletado: ");
        int idproduto = scanner.nextInt();
        if (produtoDAO.produtoExists(idproduto)) {
            produtoDAO.deleteProduto(idproduto);
            System.out.println("Produto deletado com sucesso." + "\n");
        } else {
            System.out.println("Produto com ID especificado não existe." + "\n");
        }
        return null;
    }

    public static void updateProduto(Scanner scanner) {
        System.out.print("Digite o ID do produto a ser atualizado: ");
        int idProduto = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("Nova descrição: ");
        String novaDescricao = scanner.nextLine();

        System.out.print("Nova quantidade de produtos: ");
        int novaQuantidade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("Novo preço: ");
        double novoPreco = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("Novo ID do Fornecedor: ");
        int novoIdFornecedor = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Produto novoProduto = new Produto(novaDescricao, novaQuantidade, novoPreco, novoIdFornecedor);
        novoProduto.setIdProduto(idProduto);

        produtoDAO.updateProduto(novoProduto);

        System.out.println("Produto atualizado com sucesso.");
    }

}
