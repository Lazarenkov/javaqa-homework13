import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.products.*;

public class ManagerTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);

    @Test
    public void shouldAddItemBook() {
        Product book = new Book(212, "Учебник", 300, "Тестирование.com", "Роман Савин");
        manager.add(book);
        Product[] expected = {book};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddItemSmartphone() {
        Product smartphone = new Smartphone(55, "Android", 70000, "Galaxy S22", "Samsung");
        manager.add(smartphone);
        Product[] expected = {smartphone};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddSeveralItems() {
        Product book = new Book(212, "Учебник", 300, "Тестирование.com", "Роман Савин");
        Product smartphone = new Smartphone(55, "Android", 70000, "Galaxy S22", "Samsung");
        manager.add(book);
        manager.add(smartphone);
        Product[] expected = {book, smartphone};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionWhenAddItemWithAlreadyExistingID() {
        Product book = new Book(2, "Учебник", 300, "Тестирование.com", "Роман Савин");
        Product smartphone = new Smartphone(2, "Android", 70000, "Galaxy S22", "Samsung");
        manager.add(book);
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            manager.add(smartphone);
        });
    }

    @Test
    public void shouldReturnMatchesIfOneMatch() {
        Product book = new Book(212, "Учебник", 300, "Тестирование.com", "Роман Савин");
        Product smartphone = new Smartphone(55, "Android", 70000, "Galaxy S22", "Samsung");
        Product smartphone1 = new Smartphone(2, "iPhone", 100000, "iPhone 14", "Apple");
        manager.add(book);
        manager.add(smartphone);
        manager.add(smartphone1);
        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy("Android");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnMatchesIfSeveralMatches() {
        Product book = new Book(212, "Учебник", 300, "Тестирование.com", "Роман Савин");
        Product smartphone1 = new Smartphone(2, "iPhone", 100000, "iPhone 14", "Apple");
        Product smartphone2 = new Smartphone(55, "Android", 70000, "Galaxy S22", "Samsung");
        Product smartphone3 = new Smartphone(44, "iPhone", 50000, "iPhone 12", "Apple");
        manager.add(book);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] expected = {smartphone1, smartphone3};
        Product[] actual = manager.searchBy("iPhone");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayIfNoMatch() {
        Product book = new Book(212, "Учебник", 300, "Тестирование.com", "Роман Савин");
        Product smartphone = new Smartphone(55, "Android", 70000, "Galaxy S22", "Samsung");
        manager.add(book);
        manager.add(smartphone);
        Product[] expected = {};
        Product[] actual = manager.searchBy("iPhone");
        Assertions.assertArrayEquals(expected, actual);
    }
}
