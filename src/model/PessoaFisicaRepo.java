package model;

import java.util.ArrayList;
import java.io.*;


public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> listaPessoaFisica = new ArrayList<>();
    
    public ArrayList<PessoaFisica> obterTodos(){
        return this.listaPessoaFisica;
    }
    public void inserir(PessoaFisica pessoa){
        obterTodos().add(pessoa);
    }
    public void alterar(PessoaFisica pessoa, PessoaFisica alteracao){
        int index = obterTodos().indexOf(pessoa);
        obterTodos().set(index, alteracao);
    }
    public void excluir(int Id){
        for(PessoaFisica pessoa: obterTodos()){
            if(pessoa.getId() == Id){
                obterTodos().remove(pessoa);
            }
        }
    }
    public PessoaFisica obter(int Id){
        for(PessoaFisica pessoa: obterTodos()){
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
            System.out.println("Dados de Pessoa Física Armazenados");
    }
    public void recuperar(String nome_arquivo) throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<PessoaFisica> lista = null;
        String nome_arquivo_completo = nome_arquivo + ".ser";
        FileInputStream arquivo = new FileInputStream(nome_arquivo_completo);
        ObjectInputStream input = new ObjectInputStream(arquivo);
        lista = (ArrayList<PessoaFisica>) input.readObject();
        input.close();
        arquivo.close();
        System.out.println("Dados de Pessoa Física Recuperados");
        this.listaPessoaFisica = lista;
    }
}
