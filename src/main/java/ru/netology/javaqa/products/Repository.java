package ru.netology.javaqa.products;

public class Repository {

    private Product[] items = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[items.length] = product;
        items = tmp;
    }

    public Product[] getItems() {
        return items;
    }

    public void removeById(int id) {
        Product[] result = new Product[0];
        int i = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                Product[] tmp = new Product[i + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[i] = item;
                result = tmp;
                i++;
            }
        }
        items = result;
    }

}
