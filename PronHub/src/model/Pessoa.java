package model;

import java.util.Date;

public abstract class Pessoa {
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private String email;
    private String senha;
    private String telefone;
    private String CPF;
    private String cidade;
    private String estado;
    private String pais;
    private String endereco;
    private int numero;

    // Construtor para Cliente e Vendedor
    public Pessoa(String nome, String sobrenome, Date dataNascimento, String telefone, String CPF, String cidade, String estado, String pais,
                  String endereco, int numero, String email, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.CPF = CPF;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.endereco = endereco;
        this.numero = numero;
    }

    // Construtor para Fornecedor
    public Pessoa(String email, String senha, String telefone, String cidade, String estado, String pais,
                  String endereco, int numero) {
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.endereco = endereco;
        this.numero = numero;
    }

    // Construtor para Admin
    public Pessoa(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Método abstrato
    public abstract String capturarDados();

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
