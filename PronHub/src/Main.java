import dao.*;
import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClienteDAO clienteDAO = new ClienteDAO();
        AdminDAO adminDAO = new AdminDAO();
        VendedorDAO vendedorDAO = new VendedorDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        VendaDAO vendaDAO = new VendaDAO();

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        int opcaoMenu = 0;

        Scanner sc = new Scanner(System.in);

        while (opcaoMenu != 9) {
            //Menu Principal
            System.out.println("==== MENU ===");
            System.out.println("(1) Login ");
            System.out.println("(2) Registro ");
            System.out.println("(9) Sair ");
            System.out.print("Escolha Uma Opção: ");
            opcaoMenu = sc.nextInt();

            if (opcaoMenu == 1) {
                System.out.print("Digite seu nome de usuário: ");
                String usuario = sc.next();
                //Menu para o Administrador
                if (usuario.endsWith("@adm.com")) {
                    System.out.println();
                    System.out.println("Bem-vindo, você está logado como administrador!");
                    System.out.println();

                    int opcaoPrincipal = 0;
                    while (opcaoPrincipal != 4) {
                        System.out.println("==== MENU PRINCIPAL ====");
                        System.out.println("(1) Cadastro");
                        System.out.println("(2) Listar");
                        System.out.println("(3) Operações");
                        System.out.println("(4) Sair");
                        System.out.print("Escolha uma opção:");
                        opcaoPrincipal = sc.nextInt();
                        System.out.println();

                        switch (opcaoPrincipal) {
                            case 1:
                                int opcaoCadastro = 0;
                                while (opcaoCadastro != 7) {
                                    System.out.println("==== MENU DE CADASTRO ====");
                                    System.out.println("(1) Cadastrar Admin");
                                    System.out.println("(2) Cadastrar Vendedor");
                                    System.out.println("(3) Cadastrar Cliente");
                                    System.out.println("(4) Cadastrar Fornecedor");
                                    System.out.println("(5) Cadastrar Produto");
                                    System.out.println("(6) Cadastrar Venda");
                                    System.out.println("(7) Voltar");
                                    System.out.print("Escolha uma opção:");
                                    opcaoCadastro = sc.nextInt();
                                    System.out.println();

                                    if (opcaoCadastro == 1) {
                                        System.out.println("Cadastro de administrador selecionado.");
                                        Admin admin = Admin.capturarInformacoesAdmin(scanner);
                                        adminDAO.inserirAdmin(admin);

                                    } else if (opcaoCadastro == 2) {
                                        System.out.println("Cadastro de vendedor selecionado.");
                                        Vendedor vendedor = Vendedor.capturarInformacoesVendedor(scanner);
                                        vendedorDAO.inserirVendedor(vendedor);

                                    } else if (opcaoCadastro == 3) {
                                        System.out.println("Cadastro de Cliente selecionado.");
                                        Cliente cliente = Cliente.capturarInformacoesCliente(scanner);
                                        clienteDAO.inserirCliente(cliente);

                                    } else if (opcaoCadastro == 4) {
                                        System.out.println("Cadastro de fornecedor selecionado.");
                                        Fornecedor fornecedor = Fornecedor.capturarInformacoesFornecedor(scanner);
                                        fornecedorDAO.inserirFornecedor(fornecedor);

                                    } else if (opcaoCadastro == 5) {
                                        System.out.println("Cadastro de produto selecionado.");
                                        Produto produto = Produto.capturarInformacoesProduto(scanner);
                                        produtoDAO.inserirProduto(produto);
                                    } else if (opcaoCadastro == 6) {
                                        System.out.println("Cadastro de venda selecionado.");
                                        Venda venda = Venda.capturarInformacoesVenda(scanner);
                                        vendaDAO.inserirVenda(venda);

                                    } else if (opcaoCadastro == 7) {
                                        System.out.println("Voltando para o menu principal...");
                                    } else {
                                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Listagem selecionada." + "\n");
                                int opcaoListagem = 0;
                                while (opcaoListagem != 8) {
                                    System.out.println("==== MENU LISTAGEM ====");
                                    System.out.println("(1) Listar Vendedor");
                                    System.out.println("(2) Listar Cliente");
                                    System.out.println("(3) Listar Fornecedor");
                                    System.out.println("(4) Listar Produto(estoque)");
                                    System.out.println("(5) Listar Vendas");
                                    System.out.println("(6) Registrar Vendas");
                                    System.out.println("(7) Faturamento do Dia");
                                    System.out.println("(8) Voltar");
                                    System.out.print("Escolha uma opção: ");
                                    opcaoListagem = sc.nextInt();
                                    System.out.println();

                                    if (opcaoListagem == 1) {
                                        System.out.println("Listagem De Vendedor selecionado. ");
                                        ResultSet rs = vendedorDAO.listarVendedor();
                                        try {
                                            if (!rs.isBeforeFirst()) {
                                                System.out.println("Não há nenhum Vendedor cadastrado." + "\n");
                                            } else {
                                                while (rs.next()) {
                                                    System.out.println("Vendedor " + rs.getInt("idVendedor") + ": " + rs.getString("nome") + "\n");
                                                }
                                            }
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                    } else if (opcaoListagem == 2) {
                                        System.out.println("Listagem de Cliente selecionado." + "\n");
                                        ResultSet rs = clienteDAO.listarClientes();
                                        try {
                                            if (!rs.isBeforeFirst()) {
                                                System.out.println("Não há nenhum cliente cadastrado." + "\n");
                                            } else {
                                                while (rs.next()) {
                                                    System.out.println("Cliente " + rs.getInt("idCliente") + ": " + rs.getString("nome") + "\n");
                                                }
                                            }
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                    } else if (opcaoListagem == 3) {
                                        System.out.println("Listagem De Fornecedor selecionado." + "\n");
                                        ResultSet rs = fornecedorDAO.listarFornecedor();
                                        try {
                                            if (!rs.isBeforeFirst()) {
                                                System.out.println("Não há nenhum fornecedor cadastrado." + "\n");
                                            } else {
                                                while (rs.next()) {
                                                    System.out.println("Fornecedor " + rs.getInt("idFornecedor") + ": " + rs.getString("nomeFantasia") + "\n");
                                                }
                                            }
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }

                                    } else if (opcaoListagem == 4) {
                                        System.out.println("Listagem De Produto selecionado." + "\n");
                                        ResultSet rs = produtoDAO.listarProduto();
                                        try {
                                            if (!rs.isBeforeFirst()) {
                                                System.out.println("Não há nenhum Produto cadastrado." + "\n");
                                            } else {
                                                while (rs.next()) {
                                                    System.out.println("Produto " + rs.getInt("idProduto") + ": " + rs.getString("descricao") + "\n");
                                                }
                                            }
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                    } else if (opcaoListagem == 5) {
                                        System.out.println("Listagem De Vendas selecionado. ");
                                        ResultSet rs = vendaDAO.listarVendas();
                                        try {
                                            if (!rs.isBeforeFirst()) {
                                                System.out.println("Não há nenhum Venda cadastrado." + "\n");
                                            } else {
                                                while (rs.next()) {
                                                    System.out.println("Venda " + rs.getInt("idVenda") + ": Tipo de Pagamento: " + rs.getString("tipoPagamento") + "\n");
                                                }
                                            }
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                    } else if (opcaoListagem == 6) {
                                        System.out.println("Regristro de Vendas selecionado. ");
                                    } else if (opcaoListagem == 7) {
                                        System.out.println("Faturamento Do Dia selecionado.");
                                    } else if (opcaoListagem == 8) {
                                        System.out.println("Voltando para o menu principal...");
                                    } else {
                                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Operaçções Selecionada." + "\n");
                                int opcaoOperacoes = 0;
                                while (opcaoOperacoes != 9) {
                                    System.out.println("==== MENU OPERAÇÕES ====");
                                    System.out.println("(1) Apagar Vendedor");
                                    System.out.println("(2) Editar Vendedor");
                                    System.out.println("(3) Apagar Cliente");
                                    System.out.println("(4) Editar Cliente");
                                    System.out.println("(5) Apagar Fornecedor");
                                    System.out.println("(6) Editar Fornecedor");
                                    System.out.println("(7) Apagar Produto");
                                    System.out.println("(8) Editar Produto");
                                    System.out.println("(9) Voltar");
                                    System.out.print("Escolha uma opção: ");
                                    opcaoOperacoes = sc.nextInt();
                                    System.out.println();

                                    if (opcaoOperacoes == 1) {
                                        System.out.println("Apagar Vendedor Selecionado." + "\n");
                                        Vendedor.deletarVendedor(scanner);
                                    } else if (opcaoOperacoes == 2) {
                                        System.out.println("Editar Vendedor Selecionado" + "\n");
                                        Vendedor.updateVendedor(scanner);
                                    } else if (opcaoOperacoes == 3) {
                                        System.out.println("Apagar Cliente Selecionado" + "\n");
                                        Cliente.deletarCliente(scanner);
                                    } else if (opcaoOperacoes == 4) {
                                        System.out.println("Editar Cliente Selecionado" + "\n");
                                        Cliente.updateCliente(scanner);
                                    } else if (opcaoOperacoes == 5) {
                                        System.out.println("Apagar Fornecedor Selecionado" + "\n");
                                        Fornecedor.deletarFornecedor(scanner);
                                    } else if (opcaoOperacoes == 6) {
                                        System.out.println("Editar Fornecedor Selecionado" + "\n");
                                        Fornecedor.updateFornecedor(scanner);
                                    } else if (opcaoOperacoes == 7) {
                                        System.out.println("Apagar Produto Selecionado" + "\n");
                                        Produto.deletarProduto(scanner);
                                    } else if (opcaoOperacoes == 8) {
                                        System.out.println("Editar Produto Selecionado" + "\n");
                                        Produto.updateProduto(scanner);
                                    } else if (opcaoOperacoes == 9) {
                                        System.out.println("Voltando para o menu principal..." + "\n");
                                    } else {
                                        System.out.println("Opção invalida. Por favor, escolha uma opção valida.");
                                    }
                                }
                                break;
                        }
                    }
                }
            }
        }
    }
}
                //Menu para o Vendedor
                /*else if (usuario.endsWith("vendedor.com")) {
                    System.out.println();
                    System.out.println("Bem-vindo, você está logado como Vendedor!");
                    System.out.println();

                    int opcaoPrincipal = 0;
                    while (opcaoPrincipal != 3) {
                        System.out.println("==== MENU PRINCIPAL ====");
                        System.out.println("(1) Cadastro");
                        System.out.println("(2) Listar");
                        System.out.println("(3) Sair");
                        System.out.print("Escolha uma opção:");
                        opcaoPrincipal = sc.nextInt();
                        System.out.println();

                        switch (opcaoPrincipal) {
                            case 1:
                                int opcaoCadastro = 0;
                                while (opcaoCadastro != 4) {
                                    System.out.println("==== MENU DE CADASTRO ====");
                                    System.out.println("(1) Cadastrar Cliente");
                                    System.out.println("(2) Cadastrar Fornecedor");
                                    System.out.println("(3) Cadastrar Produto");
                                    System.out.println("(4) Voltar");

                                    System.out.print("Escolha uma opção:");
                                    opcaoCadastro = sc.nextInt();
                                    System.out.println();

                                    if (opcaoCadastro == 1) {
                                        System.out.println("Cadastro de Cliente selecionado.");
                                        Cliente cliente = Cliente.capturarInformacoesCliente(scanner);
                                        clienteDAO.inserirCliente(cliente);

                                    } else if (opcaoCadastro == 2) {
                                        System.out.println("Cadastro de Fornecedor selecionado.");
                                        Fornecedor fornecedor = Fornecedor.capturarInformacoesFornecedor(scanner);
                                        fornecedorDAO.inserirFornecedor(fornecedor);

                                    } else if (opcaoCadastro == 3) {
                                        System.out.println("Cadastro de Produto selecionado.");
                                        Produto produto = Produto.capturarInformacoesProduto(scanner);
                                        produtoDAO.inserirProduto(produto);

                                    } else {
                                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Listagem selecionada.");
                                int opcaoListagem = 0;
                                while (opcaoListagem != 8) {
                                    System.out.println("==== MENU LISTAGEM ====");
                                    System.out.println("(1) Listar Vendedor");
                                    System.out.println("(2) Listar Cliente");
                                    System.out.println("(3) Listar Fornecedor");
                                    System.out.println("(4) Listar Produto (estoque)");
                                    System.out.println("(5) Listar Vendas");
                                    System.out.println("(6) Registrar Vendas");
                                    System.out.println("(7) Faturamento do Dia");
                                    System.out.println("(8) Voltar");
                                    System.out.print("Escolha uma opção: ");
                                    opcaoListagem = sc.nextInt();
                                    System.out.println();

                                    if (opcaoListagem == 1) {
                                        System.out.println("Listagem De Vendedor selecionado. ");
                                        ResultSet rs = vendedorDAO.listarVendedor();
                                        try {
                                            if (!rs.isBeforeFirst()) {
                                                System.out.println("Não há nenhum Vendedor cadastrado." + "\n");
                                            } else {
                                                while (rs.next()) {
                                                    System.out.println("Vendedor " + rs.getInt("idVemnedor") + ": " + rs.getString("nome" + "\n"));
                                                }
                                            }
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                    else if (opcaoListagem == 2) {
                                        System.out.println("Listagem de Cliente selecionado. ");
                                        ResultSet rs = clienteDAO.listarClientes();
                                        try {
                                            if (!rs.isBeforeFirst()) {
                                                System.out.println("Não há nenhum cliente cadastrado." + "\n");
                                            } else {
                                                while (rs.next()) {
                                                    System.out.println("Cliente " + rs.getInt("idcliente") + ": " + rs.getString("nome"  + "\n"));
                                                }
                                            }
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                    else if (opcaoListagem == 3) {
                                        System.out.println("Listagem De Fornecedor selecionado. ");
                                        ResultSet rs = fornecedorDAO.listarFornecedor();
                                        try {
                                            if (!rs.isBeforeFirst()) {
                                                System.out.println("Não há nenhum fornecedor cadastrado." + "\n");
                                            } else {
                                                while (rs.next()) {
                                                    System.out.println("Fornecedor " + rs.getInt("idfornecedor") + ": " + rs.getString("nomeFantasia" + "\n"));
                                                }
                                            }
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }

                                    }
                                    else if (opcaoListagem == 4) {
                                        System.out.println("Listagem De Produto selecionado. ");
                                        ResultSet rs = produtoDAO.listarProduto();
                                        try {
                                            if (!rs.isBeforeFirst()) {
                                                System.out.println("Não há nenhum Produto cadastrado." + "\n");
                                            } else {
                                                while (rs.next()) {
                                                    System.out.println("Produto " + rs.getInt("idproduto") + ": " + rs.getString("nome" + "\n"));
                                                }
                                            }
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                    else if (opcaoListagem == 5) {
                                        System.out.println("Listagem De Vendas selecionado. ");
                                        ResultSet rs = vendaDAO.listarVendas();
                                        try {
                                            if (!rs.isBeforeFirst()) {
                                                System.out.println("Não há nenhum Venda cadastrado." + "\n");
                                            } else {
                                                while (rs.next()) {
                                                    System.out.println("Venda " + rs.getInt("idvenda") + ": " + rs.getString("nome" + "\n"));
                                                }
                                            }
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                    else if (opcaoListagem == 6) {
                                        System.out.println("Regristro de Vendas selecionado. ");
                                    }
                                    else if (opcaoListagem == 7) {
                                        System.out.println("Faturamento do Dia. ");
                                    }
                                    else if (opcaoListagem == 8) {
                                        System.out.println("Voltando para o menu principal...");
                                    }
                                    else {
                                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                                        scanner.next();
                                    }
                                }
                        }
                    }
                }
            }
        }

                 */