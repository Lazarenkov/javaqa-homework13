import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.products.*;

public class ManagerTest {
    Repository repo=new Repository();
    Manager manager=new Manager(repo);

    @Test
    public void shouldAddItemBook(){
        Product book=new Book(212,"Учебник", 300,"Тестирование.com", "Роман Савин");
        manager.add(book);
        Product[] expected = {book};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldAddItemSmartphone(){
        Product smartphone=new Smartphone(55,"Android", 70000,"Galaxy S22", "Samsung");
        manager.add(smartphone);
        Product[] expected = {smartphone};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldAddSeveralItems(){
        Product book=new Book(212,"Учебник", 300,"Тестирование.com", "Роман Савин");
        Product smartphone=new Smartphone(55,"Android", 70000,"Galaxy S22", "Samsung");
        manager.add(book);
        manager.add(smartphone);
        Product[] expected = {book, smartphone};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldReturnMatchesIfMatch(){
        Product book=new Book(212,"Учебник", 300,"Тестирование.com", "Роман Савин");
        Product smartphone=new Smartphone(55,"Android", 70000,"Galaxy S22", "Samsung");
        manager.add(book);
        manager.add(smartphone);
        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy("Android");
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldReturnEmptyArrayIfNoMatch(){
        Product book=new Book(212,"Учебник", 300,"Тестирование.com", "Роман Савин");
        Product smartphone=new Smartphone(55,"Android", 70000,"Galaxy S22", "Samsung");
        manager.add(book);
        manager.add(smartphone);
        Product[] expected = {};
        Product[] actual = manager.searchBy("iPhone");
        Assertions.assertArrayEquals(expected,actual);
    }
}
