package br.com.fiap.games.model;

import java.time.LocalDate;

public class Game {

    private int codigo;
    private String nome;
    private double nota;
    private int ano;
    private LocalDate dataCompra;
    private boolean finalizado;

    public Game() {}

    //cadastrar o codigo é gerado pelo banco
    public Game(String nome, double nota, int ano, LocalDate dataCompra, boolean finalizado) {
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
        this.dataCompra = dataCompra;
        this.finalizado = finalizado;
    }

    public Game(int codigo, String nome, double nota, int ano, LocalDate dataCompra, boolean finalizado) {
        this.codigo = codigo;
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
        this.dataCompra = dataCompra;
        this.finalizado = finalizado;
    }

    @Override
    public String toString() {
        return "Game{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", nota=" + nota +
                ", ano=" + ano +
                ", dataCompra=" + dataCompra +
                ", finalizado=" + finalizado +
                '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    //LocalDate -> data
    //LocalDateTime -> data e hora
    //LocalTime -> hora

}
