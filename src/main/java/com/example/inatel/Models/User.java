package com.example.inatel.Models;

public class User {
  private int id;
  private String nome;
  private String cpf;

  // Constructors
  public User(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
  }
  public User(String nome, String cpf, int id) {
    this.nome = nome;
    this.cpf = cpf;
    this.id = id;
  }

  // Getters
  public String getNome() {
    return nome;
  }
  public String getCpf() {
    return cpf;
  }
  public int getId() {
    return id;
  }
}
