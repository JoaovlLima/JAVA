package RevisaoFPOO.Agendamento;

public class Agenda {
   String data;
   String hora;
   String dataHora;
public Agenda(String data, String hora) {
    this.data = data;
    this.hora = hora;
}
public String getData() {
    return data;
}
public Agenda() {
}
public void setData(String data) {
    this.data = data;
}
public String getHora() {
    return hora;
}
public void setHora(String hora) {
    this.hora = hora;
}
public String getDataHora() {
    dataHora = data+hora;
    return dataHora;
}
public void setDataHora(String dataHora) {
    this.dataHora = dataHora;
}

}
