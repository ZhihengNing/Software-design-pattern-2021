package molefarm.common.exception.product.conc;

import molefarm.common.exception.product.ProductNotFoundException;

public class CropsNotFoundException extends ProductNotFoundException {
    public CropsNotFoundException(String message) {
        super(message);
    }
}
