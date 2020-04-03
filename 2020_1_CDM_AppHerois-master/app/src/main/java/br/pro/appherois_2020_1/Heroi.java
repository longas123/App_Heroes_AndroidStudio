package br.pro.appherois_2020_1;

import androidx.annotation.NonNull;

public class Heroi {

    public int id;
    private String nome, grupo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @NonNull
    @Override
    public String toString() {
        return nome + " - " + grupo;
    }
}












