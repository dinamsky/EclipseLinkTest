package specifications;

import entity.Book;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BookByTitle extends AbstractSpecification<Book> {
    String title;

    public BookByTitle(String title) {
        this.title = title;
    }

    public Predicate toPredicate(Root<Book> root, CriteriaBuilder criteriaBuilder) {
        return  criteriaBuilder.equal(root.<String>get("title"),title);
    }
}
