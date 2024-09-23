package model;

public class PessoaFisica extends Pessoa {
    private String cpf;
    private int idade;
    
    public PessoaFisica(int id, String nome, String cpf, int idade){
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    public int getIdade(){
        return this.idade;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    
    @Override
    public void exibir(){
        System.out.printf("ID: %d \nNome: %s\nCPF: %s\nIdade: %d\n", getId(), getNome(), getCpf(), getIdade());
    }
}
