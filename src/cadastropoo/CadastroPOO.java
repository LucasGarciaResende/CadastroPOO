package cadastropoo;

import java.io.*;
import model.*;

public class CadastroPOO {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
       PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
       PessoaFisica fisica1 = new PessoaFisica(001, "Júlio Cesar", "316.988.256-82", 29);
       repo1.inserir(fisica1);
       PessoaFisica fisica2 = new PessoaFisica(002, "Agatha Schmit", "489.262.739-19", 41);
       repo1.inserir(fisica2);
       repo1.persistir("PessoaFisica01");
       PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
       repo2.recuperar("PessoaFisica01");
       for (PessoaFisica pessoa: repo2.obterTodos()){
           pessoa.exibir();
       }
       PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
       PessoaJuridica juridica1 = new PessoaJuridica(003, "Abragravata Roupas & Acessórios", "51.900.438/0001-31");
       repo3.inserir(juridica1);
       PessoaJuridica juridica2 = new PessoaJuridica(004, "Failproof Logistics", "12.542.566/0001-92");
       repo3.inserir(juridica2);
       repo3.persistir("PessoaJuridica01");
       PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
       repo4.recuperar("PessoaJuridica01");
       for (PessoaJuridica pessoa: repo4.obterTodos()){
           pessoa.exibir();
       }
    }
}
