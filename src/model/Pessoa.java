package model;

import java.io.Serializable; 

public class Pessoa implements Serializable{
    private int id;
    private String nome;
    
    public Pessoa (int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    public int getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void exibir(){
        System.out.printf("ID: %d \nNome: %s\n", getId(), getNome());
    }
}
