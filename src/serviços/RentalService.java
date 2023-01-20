package serviços;

import java.time.Duration;

import entities.CarRental;
import entities.Invoice;

public class RentalService {
    private Double preçoHora;
    private Double preçoDia;

    private TaxaBrasil taxaBrasil;

    public RentalService(Double preçoHora, Double preçoDia, TaxaBrasil taxaBrasil) {
        this.preçoHora = preçoHora;
        this.preçoDia = preçoDia;
        this.taxaBrasil = taxaBrasil;
    }

    public Double getPreçoHora() {
        return preçoHora;
    }

    public void setPreçoHora(Double preçoHora) {
        this.preçoHora = preçoHora;
    }

    public Double getPreçoDia() {
        return preçoDia;
    }

    public void setPreçoDia(Double preçoDia) {
        this.preçoDia = preçoDia;
    }

    public TaxaBrasil getTaxaBrasil() {
        return taxaBrasil;
    }

    public void setTaxaBrasil(TaxaBrasil taxaBrasil) {
        this.taxaBrasil = taxaBrasil;
    }

    
    public void processInvoice(CarRental carRental) {
        double minutes =  Duration.between(carRental.getMomentInicial(), carRental.getMomentFinal()).toMinutes();

        Double horas = minutes / 60;

        Double valor, taxa;
        if (horas <= 12) {
            valor = preçoHora * Math.ceil(horas);
        }
        else {
            valor = preçoDia * Math.ceil(horas / 24);
        }

        taxa = taxaBrasil.taxa(valor);

        Invoice invoice = new Invoice(valor, taxa);

        carRental.setFatura(invoice);
    }
    
}
