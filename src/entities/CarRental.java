package entities;
import java.time.LocalDateTime;

public class CarRental {
    private LocalDateTime momentInicial;
    private LocalDateTime momentFinal;

    private Veiculo veiculo;
    private Invoice fatura;


    public CarRental(LocalDateTime momentInicial, LocalDateTime momentFinal, Veiculo veiculo) {
        this.momentInicial = momentInicial;
        this.momentFinal = momentFinal;
        this.veiculo = veiculo;
    }


    public LocalDateTime getMomentInicial() {
        return momentInicial;
    }


    public void setMomentInicial(LocalDateTime momentInicial) {
        this.momentInicial = momentInicial;
    }


    public LocalDateTime getMomentFinal() {
        return momentFinal;
    }


    public void setMomentFinal(LocalDateTime momentFinal) {
        this.momentFinal = momentFinal;
    }


    public Veiculo getVeiculo() {
        return veiculo;
    }


    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }


    public Invoice getFatura() {
        return fatura;
    }
    
    public void setFatura(Invoice fatura) {
        this.fatura = fatura;
    }



    



    
}
