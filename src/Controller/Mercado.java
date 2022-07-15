package Controller;

import Model.Cliente;
import Model.Produto;
import Model.Vendedor;
import Utils.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mercado {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Produto> produtos;

    private static ArrayList<Cliente> cliente;

    private static ArrayList<Vendedor> vendedor;
    private static Map<Produto, Integer> carrinho;

    public static void main(String[] args) {
        produtos = new ArrayList<>();

        carrinho = new HashMap<>();

        menuInicial();

    }


    private static void menuInicial() {

        System.out.println("--------------------------------------------------------------------");
        System.out.println("-------------------------------Menu Inicial ------------------------");
        System.out.println("-------------Selecione a operação que deseja realizar---------------");
        System.out.println(" 1 - Cadastro");
        System.out.println(" 2 - Login");
        System.out.println(" 3 - Sair ");

        int option = input.nextInt();


        switch (option) {

            case 1:
                cadastro();
                break;
            //case 2:
            //   login();
            //  break;
            default:
                System.out.println("Não existe a opção selecionada, favor selecionar uma opção válida");
                menuInicial();
                break;
        }

    }

    private static void cadastro() {
        System.out.println("-------------Selecione a operação que deseja realizar---------------");
        System.out.println(" 1 - Cadastro de Cliente");
        System.out.println(" 2 - Cadastro de Vendedor");
        System.out.println(" 3 - Sair ");

        int option = input.nextInt();


        switch (option) {

            case 1:
                cadastroCliente();
                break;
            case 2:
                cadastroVendedor();
                break;
            default:
                System.out.println("Não existe a opção selecionada, favor selecionar uma opção válida");
                cadastro();
                break;
        }
        menuInicial();
    }


    private static void cadastroVendedor() {

        System.out.println("Nome do Vendedor: ");
        String nome = input.next();

        System.out.println("Nova Senha ");
        String senha = input.next();

        String status = "vendedor";
        Vendedor vendedor = new Vendedor(nome, senha, status);
        vendedor.add(vendedor);

        System.out.println("O Vendedor " + vendedor.getNome() + " foi cadastrado com sucesso!");
    }

    private static void cadastroCliente() {

        System.out.println("Nome do Cliente: ");
        String nome = input.next();

        System.out.println("Senha: ");
        String senha = input.next();

        String status = "cliente";

        Cliente cliente = new Cliente(nome, senha, status);
        cliente.add(cliente);

        System.out.println("O cliente: " + cliente.getNome() + " foi cadastrado com sucesso!");

    }

    private static void menuVendedor() {

        System.out.println("--------------------------------------------------------------------");
        System.out.println("-------------------------------Menu Vendedor ------------------------");
        System.out.println("-------------Selecione a operação que deseja realizar---------------");
        System.out.println(" 1 - Cadastrar um produto");
        System.out.println(" 2 - Listar produtos cadastrados");
        System.out.println(" 3 - Sair ");

        int option = input.nextInt();


        switch (option) {

            case 1:
                cadastrarProdutos();
                break;
            case 2:
                listarProdutosVendedor();
                break;
            default:
                System.out.println("Não existe a opção selecionada, favor selecionar uma opção válida");
                menuVendedor();
                break;
        }

    }

    private static void menuCliente() {

        System.out.println("--------------------------------------------------------------------");
        System.out.println("-------------------------------Menu --------------------------------");
        System.out.println("-------------Selecione a operação que deseja realizar---------------");
        System.out.println(" 1 - Listar");
        System.out.println(" 2 - Comprar");
        System.out.println(" 3 - Carrinho");
        System.out.println(" 4 - Sair ");

        int option = input.nextInt();


        switch (option) {

            case 1:
                listarProdutosCLiente();
                break;
            case 2:
                comprarProdutos();
                break;
            case 3:
                verCarrinho();
                break;
            case 4:
                System.out.println("Compra Finalizada");
                System.exit(0);
            default:
                System.out.println("Não existe a opção selecionada, favor selecionar uma opção válida");
                menuCliente();
                break;
        }

    }

    private static void cadastrarProdutos() {
        System.out.println("Nome do Produto: ");
        String nome = input.next();

        System.out.println("Valor do produto: ");
        Double valor = input.nextDouble();

        Produto produto = new Produto(nome, valor);
        produtos.add(produto);

        System.out.println("O produto " + produto.getNomeProduto() + " foi cadastrado com sucesso!");
    }

    private static void listarProdutosCLiente() {
        if (produtos.size() > 0) {
            System.out.println("Lista de produtos \n");

            for (Produto p : produtos) {
                System.out.println(p);
            }
        } else {
            System.out.println("Não existe nenhum produto disponível");
        }

        menuCliente();
    }

    private static void listarProdutosVendedor() {
        if (produtos.size() > 0) {
            System.out.println("Lista de produtos \n");

            for (Produto p : produtos) {
                System.out.println(p);
            }
        } else {
            System.out.println("Você não cadastrou nenhum produto");
        }

        menuVendedor();
    }

    private static void comprarProdutos() {
        if (produtos.size() > 0) {
            System.out.println("Código do proguto: \n");
            System.out.println("------------ Produtos Disponíveis --------");
            for (Produto p : produtos) {
                System.out.println(p + "\n");
            }

            int id = Integer.parseInt(input.next());
            boolean isPresent = false;

            for (Produto p : produtos) {
                if (p.getId() == id) {
                    int quantidade = 0;
                    try {
                        quantidade = carrinho.get(p);
                        // checa se o produto já está no carrinho, se estiver, incrementa quantidade.
                        carrinho.put(p, quantidade + 1);
                    } catch (NullPointerException e) {
                        // Se o produto não existir no carrinho, adiciona 1.
                        carrinho.put(p, 1);
                    }

                    System.out.println("O produto" + p.getNomeProduto() + "foi adicionado ao carrinho.");
                    isPresent = true;

                    if (isPresent) {
                        System.out.println("Gostaria de adicionar outro produto ao carrinho?");
                        System.out.println("Digite:\n 1 - Continuar Comprando \n 2 - Finalizar a Compra");
                        int option = Integer.parseInt(input.next());

                        if (option == 1) {
                            comprarProdutos();
                        } else {
                            finalizarCompra();
                        }
                    }
                } else {
                    System.out.println("Produto não encontrado");
                    menuCliente();
                }
            }
        } else {
            System.out.println("Não existem produtos cadastrados");
            menuCliente();
        }
    }

    private static void verCarrinho() {
        System.out.println("Produtos no carrinho: ");
        if (carrinho.size() > 0) {
            for (Produto p : carrinho.keySet()) {
                System.out.println("Produto: " + p + "\n Quantidade: " + carrinho.get(p));
            }
        } else {
            System.out.println("Seu carrinho está vazio!");
        }
        menuCliente();
    }

    private static void finalizarCompra() {
        Double valorTotal = 0.0;
        System.out.println("Seus produtos: ");

        for (Produto p : carrinho.keySet()) {
            int quantidade = carrinho.get(p);
            valorTotal += p.getValor() * quantidade;
            System.out.println(p);
            System.out.println("Quantidade: " + quantidade);
        }
        System.out.println(" O Valor total da sua compra é : " + Util.doubleToString(valorTotal));
        carrinho.clear();
        System.out.println("Volte sempre!");
        menuCliente();
    }
}


