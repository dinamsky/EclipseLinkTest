package specifications;

import entity.Book;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Calendar;

public class BookByYear extends AbstractSpecification<Book> {
    private Calendar bookDate;

    public BookByYear(Calendar bookDate) {
        this.bookDate = bookDate;
    }

    public Predicate toPredicate(Root root, CriteriaBuilder criteriaBuilder) {

        return  criteriaBuilder.greaterThan(root.<String>get("addDate"),bookDate);
    }
}
