package ic.doc;

import static ic.doc.BookSearchQueryBuilder.abookSearchQuery;

import ic.doc.catalogues.LibraryCatalogue;
import java.util.List;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class BookSearchQueryTest {

  @Rule public JUnitRuleMockery context = new JUnitRuleMockery();
  LibraryCatalogue libraryCatalogue = context.mock(LibraryCatalogue.class);

  @Test
  public void libraryCatalogueIsSearched() {

    StringBuffer query = new StringBuffer();
    query.append("LASTNAME='dickens' ");

    context.checking(
        new Expectations() {
          {
            exactly(1).of(libraryCatalogue).searchFor(query.toString());
          }
        });

    List<Book> books =
        abookSearchQuery()
            .withLibrary(libraryCatalogue)
            .withSecondName("dickens")
            .build()
            .execute();
  }
}
