package model;

import java.util.ArrayList;
import java.io.*;

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> listaPessoaJuridica = new ArrayList<>();
    
    public ArrayList<PessoaJuridica> obterTodos(){
        return this.listaPessoaJuridica;
    }
    public void inserir(PessoaJuridica pessoa){
        obterTodos().add(pessoa);
    }
    public void alterar(PessoaJuridica pessoa, PessoaJuridica alteracao){
        int index = obterTodos().indexOf(pessoa);
        obterTodos().set(index, alteracao);
    }
    public void excluir(int Id){
        for(PessoaJuridica pessoa: obterTodos()){
            if(pessoa.getId() == Id){
                obterTodos().remove(pessoa);
            }
        }
    }
    public PessoaJuridica obter(int Id){
        for(PessoaJuridica pessoa: obterTodos()){
            if(pessoa.getId() == Id){
                return pessoa;
            }
        }
        return null;
    }
    public void persistir(String nome_arquivo)throws FileNotFoundException, IOException{
            FileOutputStream arquivo = new FileOutputStream(nome_arquivo + ".ser");
            ObjectOutputStream output = new ObjectOutputStream(arquivo);
            output.writeObject(obterTodos());
            output.close();
            arquivo.close();
            System.out.println("Dados de Pessoa Jurídica Armazenados");
    }
    public void recuperar(String nome_arquivo) throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<PessoaJuridica> lista = null;
        String nome_arquivo_completo = nome_arquivo + ".ser";
        FileInputStream arquivo = new FileInputStream(nome_arquivo_completo);
        ObjectInputStream input = new ObjectInputStream(arquivo);
        lista = (ArrayList<PessoaJuridica>) input.readObject();
        input.close();
        arquivo.close();
        System.out.println("Dados de Pessoa Jurídica Recuperados");
        this.listaPessoaJuridica = lista;
    }
}
