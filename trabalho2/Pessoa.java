package trabalho;

import java.lang.reflect.Constructor;

public abstract class Pessoa {
    String nome;
    String tel;
    
    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }


    String saldo;
    String num;
    String senha;
    

//construtor
public Pessoa(String nome, String tel, String saldo, String num) {
    this.nome = nome;
    this.tel = tel;
    this.saldo = saldo;
    this.num = num;

}


public Pessoa() {
}


//get and set
public String getNome() {
    return nome;
}


public void setNome(String nome) {
    this.nome = nome;
}


public String getTel() {
    return tel;
}


public void setTel(String tel) {
    this.tel = tel;
}


public String getSaldo() {
    return saldo;
}


public void setSaldo(String saldo) {
    this.saldo = saldo;
}


public String getNum() {
    return num;
}


public void setNum(String num) {
    this.num = num;
}
   
   

}
