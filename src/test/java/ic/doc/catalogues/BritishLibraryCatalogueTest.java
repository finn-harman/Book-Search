package ic.doc.catalogues;

import static ic.doc.BookSearchQueryBuilder.abookSearchQuery;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import ic.doc.Book;
import java.util.List;
import org.junit.Test;

public class BritishLibraryCatalogueTest {

  @Test
  public void instancesOfBritishLibraryCatalogueAreTheSame() {

    LibraryCatalogue catalogue1 = BritishLibraryCatalogue.getInstance();
    LibraryCatalogue catalogue2 = BritishLibraryCatalogue.getInstance();

    assertThat(catalogue1.equals(catalogue2), is(true));
  }

  @Test
  public void searchesForBooksInLibraryCatalogueByAuthorSurname() {

    List<Book> books =
        abookSearchQuery()
            .withLibrary(BritishLibraryCatalogue.getInstance())
            .withSecondName("dickens")
            .build()
            .execute();

    assertThat(books.size(), is(2));
    assertTrue(books.get(0).matchesAuthor("dickens"));
  }

  @Test
  public void searchesForBooksInLibraryCatalogueByAuthorFirstname() {

    List<Book> books =
        abookSearchQuery()
            .withLibrary(BritishLibraryCatalogue.getInstance())
            .withFirstName("Jane")
            .build()
            .execute();

    assertThat(books.size(), is(2));
    assertTrue(books.get(0).matchesAuthor("Austen"));
  }

  @Test
  public void searchesForBooksInLibraryCatalogueByTitle() {

    List<Book> books =
        abookSearchQuery()
            .withLibrary(BritishLibraryCatalogue.getInstance())
            .withTitleContaining("Two Cities")
            .build()
            .execute();

    assertThat(books.size(), is(1));
    assertTrue(books.get(0).matchesAuthor("dickens"));
  }

  @Test
  public void searchesForBooksInLibraryCatalogueBeforeGivenPublicationYear() {

    List<Book> books =
        abookSearchQuery()
            .withLibrary(BritishLibraryCatalogue.getInstance())
            .publishedBefore(1700)
            .build()
            .execute();

    assertThat(books.size(), is(1));
    assertTrue(books.get(0).matchesAuthor("Shakespeare"));
  }

  @Test
  public void searchesForBooksInLibraryCatalogueAfterGivenPublicationYear() {

    List<Book> books =
        abookSearchQuery()
            .withLibrary(BritishLibraryCatalogue.getInstance())
            .publishedAfter(1950)
            .build()
            .execute();

    assertThat(books.size(), is(1));
    assertTrue(books.get(0).matchesAuthor("Golding"));
  }

  @Test
  public void searchesForBooksInLibraryCatalogueWithCombinationOfParameters() {

    List<Book> books =
        abookSearchQuery()
            .withLibrary(BritishLibraryCatalogue.getInstance())
            .withFirstName("dickens")
            .publishedBefore(1840)
            .build()
            .execute();

    assertThat(books.size(), is(1));
    assertTrue(books.get(0).matchesAuthor("charles dickens"));
  }

  @Test
  public void searchesForBooksInLibraryCatalogueWithCombinationOfTitleAndOtherParameters() {

    List<Book> books =
        abookSearchQuery()
            .withLibrary(BritishLibraryCatalogue.getInstance())
            .withTitleContaining("of")
            .publishedAfter(1800)
            .publishedBefore(2000)
            .build()
            .execute();

    assertThat(books.size(), is(3));
    assertTrue(books.get(0).matchesAuthor("charles dickens"));
  }
}
