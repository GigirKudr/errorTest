package ru.netology.error;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotFoundExceptionTest {
    //Product product1 = new Product(1, "Мяч", 100);
    //Product product2 = new Product(2, "Бита", 200);
    //Product product3 = new Product(3, "Валанчик", 7000);

    @Test
    public void errorWithNotId() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Мяч", 100);
        Product product2 = new Product(2, "Бита", 200);
        Product product3 = new Product(3, "Валанчик", 7000);
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(10);
        });
    }

    @Test
    public void delProductOnRepo() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Мяч", 100);
        Product product2 = new Product(2, "Бита", 200);
        Product product3 = new Product(3, "Валанчик", 7000);
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.removeById(2);

        Product[] expected = {product1, product3};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }
}
