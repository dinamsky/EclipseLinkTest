import entity.Book;
import entity.UserTable;
import repository.BookRepository;
import specifications.BookByPages;
import specifications.BookByTitle;
import specifications.BookByTitleAndYear;
import specifications.BookByYear;
import sun.util.calendar.LocalGregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class TstUserTable {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("OrmExample");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        BookRepository repository = new BookRepository(entityManager);
        for(int i=1;i<6;i++){
            Book book = new Book();
            book.setTitle("Book: "+i);
            book.setPageCount(i*123);
            book.setAddDate(new GregorianCalendar());
            repository.add(book);

        }

        Calendar addDate = new GregorianCalendar(2017, 0 , 25);
        List<Book> bookByTitle = repository.getBySpec(new BookByTitle("Book: 2"));
        List<Book> bookByYear = repository.getBySpec(new BookByYear(addDate));
        List<Book> bookByPages = repository.getBySpec(new BookByPages(300));
        List<Book> bookByTitleAndYear = repository.getBySpec(new BookByTitleAndYear("Book: 2",addDate));


        entityManager.close();
        entityManagerFactory.close();
        System.out.println(bookByTitle.toString());
        System.out.println(bookByYear.toString());
        System.out.println(bookByPages.toString());
        System.out.println(bookByTitleAndYear.toString());


    }
}
