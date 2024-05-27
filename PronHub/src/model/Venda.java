package model;

import java.util.Scanner;

public class Venda {
    private int id;
    private int clienteId;
    private int vendedorId;
    private String tipoPagamento;

    // Construtor
    public Venda(int clienteId, int vendedorId, String tipoPagamento) {
        this.clienteId = clienteId;
        this.vendedorId = vendedorId;
        this.tipoPagamento = tipoPagamento;
    }

    public int getIdVenda() {
        return id;
    }

    public void setIdVenda(int idVenda) {
        this.id = idVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(int vendedorId) {
        this.vendedorId = vendedorId;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public static Venda capturarInformacoesVenda(Scanner scanner) {
        System.out.println("Cadastro de venda:");
        System.out.print("ID do Cliente: ");
        int clienteId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID do Vendedor: ");
        int vendedorId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tipo de Pagamento (credito/debito/dinheiro): ");
        String tipoPagamento = scanner.nextLine();

        return new Venda(clienteId, vendedorId, tipoPagamento);
    }
}
