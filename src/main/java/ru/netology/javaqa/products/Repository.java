package ru.netology.javaqa.products;

public class Repository {

    private Product[] items = new Product[0];


    public void save(Product product) {
        if (findById(product.getId()) != null) {
            throw new AlreadyExistsException("Такой ID уже есть у товара " + (findById(product.getId())).getName());
        }
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
        if (findById(id) == null) {
            throw new NotFoundException("Элемент с id " + id + " не найден.");
        }
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

    private Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

}
