package br.com.example.view;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.example.controle.ProdutoControle;
import br.com.example.modelo.Produto;

public class ProdutoView {
    private Scanner sc = new Scanner (System.in);
    private ProdutoControle controle = new ProdutoControle();

    public void menu() {
        int opcao;

        do { 
            System.out.println("\n==== SISTEMA DE PRODUTOS ====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar");
            System.out.println("4 - Alterar");
            System.out.println("5 - Remover");
            System.out.println("0 - Sair");
            System.out.println("Escolha a opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 : cadastrar();break;
                case 2 : listar();break;
                case 3 : buscar();break;
                case 4 : alterar();break;
                case 5 : remover();break;
                case 0 : System.out.println("Sistema encerrado");break;
                default:System.out.println("Opção inválida");
            }
        }while (opcao != 0);
        sc.close();
    }
    private void cadastrar() {
        System.out.println("\n---CADASTRAR---");
        System.out.println("Código: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Preço: ");
        double preco = sc.nextDouble();

        if (controle.cadastrar(codigo, nome, preco)) {
            System.out.println("Produto cadastrado com Sucesso!");
        } else {
            System.out.println("Não foi possivel cadastrar");
        }
    }
    private void listar() {
        System.out.println("\n---Produto---");
        ArrayList<Produto> produtos = controle.listar();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado");
        } else {
            for (Produto produto : produtos) {
                System.out.println("Código: " + produto.getCodigo());
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Preço: " + produto.getPreco());
                System.out.println("-----------------------------------");
            }
        }
    }

    private void buscar() {
        System.out.println("Digite o código");
        int codigo = sc.nextInt();
        Produto produto = controle.buscar(codigo);

        if (produto != null) {
            System.out.println("Código: " + produto.getCodigo());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
        } else {
            System.out.println("Produto não encontrado");
        }
    }
    private void alterar() {
        System.out.println("Códido do produto: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        Produto produto = controle.buscar(codigo);

        if (produto == null) {
            System.out.println("Produto não encontrado");
            return;
        }
       System.out.println("Novo nome: ");
       String nome = sc.nextLine();
       System.out.println("Novo preço");
       double preco = sc.nextDouble();
    
       if (controle.alterar(codigo, nome, preco)) {
        System.out.println("Produto alterado");
       } else {
            System.out.println("Não foi possivel alterar");
       }
    }   
    private void remover() {
        System.out.println("Código do produto: ");
        int codigo = sc.nextInt();
        if (controle.remover(codigo)) {
            System.out.println("Produto removido");
        } else {
            System.out.println("Produto não encontrado");
        }
    }
}
