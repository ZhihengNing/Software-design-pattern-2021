package molefarm.pattern.factory;

import molefarm.common.exception.MyException;
import molefarm.common.exception.product.ProductNotFoundException;
import molefarm.common.product.IProduct;

import java.lang.reflect.InvocationTargetException;

public interface Factory {
    /**
     * 所有抽象工厂要继承这个接口，并且重写这个方法
     *
     * @param name
     * @return
     * @throws MyException
     */
    IProduct create(String name) throws ProductNotFoundException;

    static <T extends IProduct> T createProduct(String name) throws ProductNotFoundException {
        T abstractObj = null;
        try {
            Class<T> aClass = (Class<T>) Class.forName(name);
            try {
                abstractObj = aClass.getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            throw new ProductNotFoundException();
        }
        return abstractObj;
    }

    /**
     * 此方法不要使用！！！！
     *
     * @param message
     * @param tClass
     * @param <T>
     * @return
     * @throws MyException
     */
    static <T> T createProduct(String message, Class<T> tClass) throws MyException {
        T abstractObj = null;
        try {
            abstractObj = tClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new MyException(message);
        }
        return abstractObj;
    }
}
