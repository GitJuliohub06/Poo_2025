package com.proyecto.demo;

public class Figura {
    private int base;
    private int altura;
    private int radio;

    public Figura (){}

    public Figura(int base, int altura, int radio) {
        this.base = base;
        this.altura = altura;
        this.radio = radio;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }



}
