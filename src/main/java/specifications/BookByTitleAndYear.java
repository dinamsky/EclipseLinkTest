package specifications;

import entity.Book;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Calendar;

public class BookByTitleAndYear extends AbstractSpecification<Book> {
    private String title;
    private Calendar addDate;

    public BookByTitleAndYear(String title, Calendar addDate) {
        this.title = title;
        this.addDate = addDate;
    }

    public Predicate toPredicate(Root root, CriteriaBuilder criteriaBuilder) {
        Predicate author = criteriaBuilder.equal(root.<String>get("title"),title);
        Predicate year = criteriaBuilder.greaterThan(root.<String>get("addDate"),addDate);
        return criteriaBuilder.and(author,year);
    }
}
