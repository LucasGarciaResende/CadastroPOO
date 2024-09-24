package cadastropoo;

import java.io.*;
import model.*;
import java.util.Scanner;

public class CadastroPOO {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        PessoaFisicaRepo repo_fisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repo_juridica = new PessoaJuridicaRepo();
        Scanner scanner = new Scanner(System.in);
        int opicao;
        do{
            System.out.println("""
                               [=======================]
                               |(1) Incluir uma Pessoa |
                               |(2) Alterar uma Pessoa |
                               |(3) Excluir Pessoa     |
                               |(4) Buscar pelo Id     |
                               |(5) Exibir Todos       |
                               |(6) Persistir Dados    |
                               |(7) Recuperar Dados    |
                               |(0) Finalizar Programa |
                               [=======================]
                               """);
           
            opicao = scanner.nextInt();
            scanner.nextLine();
            switch (opicao){
               case 0:
                   break;
                case 1:
                    System.out.println("F - Pessoa Física | J - Pessoa Júridica");
                    String opicao_pessoa1 = scanner.nextLine();
                    switch (opicao_pessoa1) {
                        case "F":
                            System.out.println("Digite o Id da pessoa:");
                            int id1 = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Insira os dados\nNome:");
                            String nome1 = scanner.nextLine();
                            System.out.println("CPF:");
                            String cpf = scanner.nextLine();
                            System.out.println("Idade:");
                            int idade = scanner.nextInt();
                            scanner.nextLine();
                            PessoaFisica pessoa1 = new PessoaFisica(id1, nome1, cpf, idade);
                            repo_fisica.inserir(pessoa1);
                            pessoa1.exibir();
                            break;
                        case "J":
                            System.out.println("Digite o Id da pessoa:");
                            int id2 = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Insira os dados\nNome:");
                            String nome2 = scanner.nextLine();
                            System.out.println("CNPJ:");
                            String cnpj = scanner.nextLine();
                            PessoaJuridica pessoa2 = new PessoaJuridica(id2, nome2, cnpj);
                            repo_juridica.inserir(pessoa2);
                            pessoa2.exibir();
                            break;
                        default:
                            System.out.println("Input Inválido");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("F - Pessoa Física | J - Pessoa Júridica");
                    String opicao_pessoa2 = scanner.nextLine();
                    switch (opicao_pessoa2) {
                        case "F":
                            System.out.println("Digite o Id da pessoa:");
                            int id1 = scanner.nextInt();
                            scanner.nextLine();
                            PessoaFisica pessoa1 = repo_fisica.obter(id1);
                            if (pessoa1 != null) {
                                pessoa1.exibir();
                                System.out.println("Digite o novo Id da pessoa:");
                                int id2 = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Insira os novos dados\nNome:");
                                String nome1 = scanner.nextLine();
                                System.out.println("Novo CPF:");
                                String cpf = scanner.nextLine();
                                System.out.println("Nova Idade:");
                                int idade = scanner.nextInt();
                                scanner.nextLine();
                                PessoaFisica pessoa2 = new PessoaFisica(id2, nome1, cpf, idade);
                                repo_fisica.alterar(pessoa1, pessoa2);
                            } else {
                                System.out.println("Pessoa Física não encontrada.");
                            }
                            break;
                        case "J":
                            System.out.println("Digite o Id da pessoa:");
                            int id3 = scanner.nextInt();
                            scanner.nextLine();
                            PessoaJuridica pessoa3 = repo_juridica.obter(id3);
                            if (pessoa3 != null) {
                                pessoa3.exibir();
                                System.out.println("Digite o novo Id da pessoa:");
                                int id4 = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Insira os novos dados\nNome:");
                                String nome2 = scanner.nextLine();
                                System.out.println("Novo CNPJ:");
                                String cnpj = scanner.nextLine();
                                PessoaJuridica pessoa4 = new PessoaJuridica(id4, nome2, cnpj);
                                repo_juridica.alterar(pessoa3, pessoa4);
                            } else {
                                System.out.println("Pessoa Jurídica não encontrada.");
                            }
                            break;
                        default:
                            System.out.println("Input Inválido");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("F - Pessoa Física | J - Pessoa Júridica");
                    String opicao_pessoa3 = scanner.nextLine();
                    switch(opicao_pessoa3){
                        case "F":
                            System.out.println("Digite o Id da pessoa a ser excluida:");
                            int id1 = scanner.nextInt();
                            scanner.nextLine();
                            repo_fisica.excluir(id1);
                            break;
                        case "J":
                            System.out.println("Digite o Id da pessoa a ser excluida:");
                            int id2 = scanner.nextInt();
                            scanner.nextLine();
                            repo_juridica.excluir(id2);
                            break;
                        default:
                            System.out.println("Input Inválido");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("F - Pessoa Física | J - Pessoa Júridica");
                    String opicao_pessoa4 = scanner.nextLine();
                    switch(opicao_pessoa4){
                        case "F":
                            System.out.println("Digite o Id da pessoa a ser excluida:");
                            int id1 = scanner.nextInt();
                            scanner.nextLine();
                            PessoaFisica pessoa1 = repo_fisica.obter(id1);
                            pessoa1.exibir();
                            break;
                        case "J":
                            System.out.println("Digite o Id da pessoa a ser excluida:");
                            int id2 = scanner.nextInt();
                            scanner.nextLine();
                            PessoaJuridica pessoa2 = repo_juridica.obter(id2);
                            pessoa2.exibir();
                            break;
                        default:
                            System.out.println("Input Inválido");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("F - Pessoa Física | J - Pessoa Júridica");
                    String opicao_pessoa5 = scanner.nextLine();
                    switch(opicao_pessoa5){
                        case "F":
                            for (PessoaFisica pessoa: repo_fisica.obterTodos()){
                                pessoa.exibir();
                            }
                            break;
                        case "J":
                            for (PessoaJuridica pessoa: repo_juridica.obterTodos()){
                                pessoa.exibir();
                            }
                            break;
                        default:
                            System.out.println("Input Inválido");
                            break;
                        }
                    break;
                case 6:
                    try{
                        System.out.println("Digite o nome do arquivo de pessoa física para persistir");
                        String nome_fisico1 = scanner.nextLine();
                        System.out.println("Digite o nome do arquivo de pessoa jurídica para persistir");
                        String nome_juridica1 = scanner.nextLine();
                        repo_fisica.persistir(nome_fisico1);
                        repo_juridica.persistir(nome_juridica1);
                        System.out.println("Arquivos salvos!");
                    }
                    catch(FileNotFoundException e){             
                        System.out.println("Erro: " + e);
                    }
                    catch(IOException e){
                        System.out.println("Erro: " + e);
                    }
                    break;
                case 7:
                    try{
                        System.out.println("Digite o nome do arquivo de pessoa fisica para recuperar");
                        String nome_fisico2 = scanner.nextLine();
                        System.out.println("Digite o nome do arquivo de pessoa jurídica para recuperar");
                        String nome_juridica2 = scanner.nextLine();
                        repo_fisica.recuperar(nome_fisico2);
                        repo_juridica.recuperar(nome_juridica2);
                        System.out.println("Arquivos recuperados!");
                    }
                    catch(FileNotFoundException e){
                        System.out.println("Erro: " + e);
                    }
                    catch(IOException | ClassNotFoundException e){
                        System.out.println("Erro: " + e);
                    }
                    break;
            }   
        }    
        while(opicao != 0);
    }
}

