package br.com.senai.calculoimc;

public class IMC {
    private float peso;
    private float altura;
    private float resultado;

    public IMC(float peso, float altura) {
        this.peso = peso;
        this.altura = altura;
    }

    public void calcular() {
        this.resultado = this.peso / (this.altura * this.altura);
    }

    public float getResultado() {
        return resultado;
    }
}
