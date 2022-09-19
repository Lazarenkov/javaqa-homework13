import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.products.*;

public class RepositoryTest {
    Repository repo = new Repository();


    @Test
    public void shouldSaveItemBook() {
        Product book = new Book(12, "Роман", 300, "Три сестры", "А.П.Чехов");
        repo.save(book);
        Product[] expected = {book};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveItemSmartphone() {
        Product smartphone = new Smartphone(2, "iPhone", 100000, "iPhone 14", "Apple");
        repo.save(smartphone);
        Product[] expected = {smartphone};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveSeveralItems() {
        Product book = new Book(212, "Учебник", 300, "Тестирование.com", "Роман Савин");
        Product smartphone = new Smartphone(55, "Android", 70000, "Galaxy S22", "Samsung");
        repo.save(book);
        repo.save(smartphone);
        Product[] expected = {book, smartphone};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionWhenSaveItemWithAlreadyExistingID() {
        Product book = new Book(5, "Учебник", 300, "Тестирование.com", "Роман Савин");
        Product smartphone = new Smartphone(5, "Android", 70000, "Galaxy S22", "Samsung");
        repo.save(book);
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(smartphone);
        });
    }

    @Test
    public void shouldRemoveItemIfIdMatching() {
        Product book = new Book(212, "Учебник", 300, "Тестирование.com", "Роман Савин");
        Product smartphone = new Smartphone(55, "Android", 70000, "Galaxy S22", "Samsung");
        repo.save(book);
        repo.save(smartphone);
        repo.removeById(212);
        Product[] expected = {smartphone};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionIfNoIdMatching() {
        Product book1 = new Book(212, "Учебник", 300, "Тестирование.com", "Роман Савин");
        Product smartphone1 = new Smartphone(55, "Android", 70000, "Galaxy S22", "Samsung");
        Product smartphone2 = new Smartphone(2, "iPhone", 100000, "iPhone 14", "Apple");
        Product book2 = new Book(12, "Роман", 300, "Три сестры", "А.П.Чехов");
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(100);
        });
    }

    @Test
    public void shouldThrowExceptionIfRemoveFromEmptyRepository() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(1);
        });
    }

    @Test
    public void shouldGetId() {
        Product book = new Book(212, "Учебник", 300, "Тестирование.com", "Роман Савин");
        Product smartphone = new Smartphone(55, "Android", 70000, "Galaxy S22", "Samsung");
        repo.save(book);
        repo.save(smartphone);
        int expected = 55;
        int actual = repo.getItems()[1].getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetName() {
        Product book = new Book(212, "Учебник", 300, "Тестирование.com", "Роман Савин");
        Product smartphone = new Smartphone(55, "Android", 70000, "Galaxy S22", "Samsung");
        repo.save(book);
        repo.save(smartphone);
        String expected = "Учебник";
        String actual = repo.getItems()[0].getName();
        Assertions.assertEquals(expected, actual);
    }
}
