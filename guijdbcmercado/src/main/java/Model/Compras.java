package Model;

import java.security.Timestamp;

public class Compras {
   private String total;
   private String codigo;
   private String qtdeGasta;
   private Timestamp date;
   

public Compras(String total, Timestamp date, String codigo, String qtdeGasta) {
    this.total = total;
    this.date = date;
    this.codigo = codigo;
    this.qtdeGasta = qtdeGasta;
}

public String getTotal() {
    return total;
}

public void setTotal(String total) {
    this.total = total;
}

public Timestamp getDate() {
    return date;
}

public void setDate(Timestamp date) {
    this.date = date;
}

public String getQtdeGasta() {
    return qtdeGasta;
}

public void setQtdeGasta(String qtdeGasta) {
    this.qtdeGasta = qtdeGasta;
}

public String getCodigo() {
    return codigo;
}

public void setCodigo(String codigo) {
    this.codigo = codigo;
}

public Compras(String codigo, String qtdeGasta) {
    this.codigo = codigo;
    this.qtdeGasta = qtdeGasta;
}
   
}
