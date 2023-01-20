package serviços;

public class TaxaBrasil {
    public Double taxa(Double montante) {
        if (montante <= 100) {
            return montante * 0.20;
        }
        else {
            return montante * 0.15;
        }
    }
}
