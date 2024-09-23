package model;

public class PessoaJuridica extends Pessoa {
    private String cnpj;
    
    public PessoaJuridica (int id, String nome, String cnpj){
        super(id, nome);
        this.cnpj = cnpj;
    }
    
    public String getCnpj(){
        return this.cnpj;
    }
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
    
    @Override
    public void exibir(){
        System.out.printf("ID: %d \nNome: %s\nCNPJ: %s\n", getId(), getNome(), getCnpj());
    }
}
