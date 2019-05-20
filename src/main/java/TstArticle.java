import entity.Article;
import entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TstArticle {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("OrmExample");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Author author = new Author();
        author.setName("tolstoy");
        entityManager.persist(author);
        for (int i=1;i<7;i++){
            Article article = new Article();
            article.setTitle("Article: "+i);
            article.setAuthor(author);
            entityManager.persist(article);


        }
        entityManager.getTransaction().commit();
        Author author1 = entityManager.find(Author.class,1);
        List<Article> articles = entityManager.find(Author.class,1).getArticles();
        System.out.println(articles.toString());
    }
}
