package ru.netology.javaqa.products;

public class Manager {

    Repository repo = new Repository();

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        int i = 0;
        for (Product product : repo.getItems()) {

            if (matches(product, text)) {
                Product[] tmp = new Product[i + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[i] = product;
                result = tmp;
                i++;
            }
        }
        return result;
    }

    private boolean matches(Product product, String search) {
        return product.getName().equals(search);
    }
}
