package molefarm.common.exception.product.conc;

import molefarm.common.exception.product.ProductNotFoundException;

public class ToolNotFoundException extends ProductNotFoundException {

    public ToolNotFoundException(String message) {
        super(message);
    }
}
