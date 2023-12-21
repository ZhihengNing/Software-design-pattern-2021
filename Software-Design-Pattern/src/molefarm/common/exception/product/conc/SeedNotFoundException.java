package molefarm.common.exception.product.conc;

import molefarm.common.exception.product.ProductNotFoundException;

public class SeedNotFoundException extends ProductNotFoundException {
    public SeedNotFoundException(String message) {
        super(message);
    }
}
