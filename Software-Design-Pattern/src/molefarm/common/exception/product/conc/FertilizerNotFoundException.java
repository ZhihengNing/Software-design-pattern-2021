package molefarm.common.exception.product.conc;

import molefarm.common.exception.product.ProductNotFoundException;

public class FertilizerNotFoundException extends ProductNotFoundException {
    public FertilizerNotFoundException(String message) {
        super(message);
    }
}
