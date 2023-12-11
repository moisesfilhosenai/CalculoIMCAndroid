package br.com.senai.calculoimc;

public class IMC {
    private float peso;
    private float altura;
    private float resultado;
    private String classificacao;
    private int imagemId;

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

    public String getClassificacao() {
        return classificacao;
    }

    public int getImagemId() {
        return imagemId;
    }

    public void classificar() {
        if (this.resultado < 18.5) {
            this.classificacao = "Baixo peso";
            this.imagemId = R.drawable.magreza;
        } else if (this.resultado >= 18.5 &&
                this.resultado <= 24.9) {
            this.classificacao = "Peso normal";
            this.imagemId = R.drawable.normal;
        } else if (this.resultado >= 25 &&
                this.resultado <= 29.9) {
            this.classificacao = "Sobrepeso";
            this.imagemId = R.drawable.obeso;
        } else if (this.resultado >= 30 &&
                this.resultado <= 34.9) {
            this.classificacao = "Obesidade grau I";
            this.imagemId = R.drawable.obesidade2;
        } else if (this.resultado >= 35 &&
                this.resultado <= 39.9) {
            this.classificacao = "Obesidade grau II";
            this.imagemId = R.drawable.obesidade2;
        } else if (this.resultado > 40) {
            this.classificacao = "Obesidade grau III";
            this.imagemId = R.drawable.obesidade2;
        }
    }

}
