package ic.doc;

import ic.doc.catalogues.LibraryCatalogue;

public class BookSearchQueryBuilder {

  private LibraryCatalogue libraryCatalogue = null;
  private String name1 = null;
  private String name2 = null;
  private String title = null;
  private Integer date1 = null;
  private Integer date2 = null;

  private BookSearchQueryBuilder() {}

  public static BookSearchQueryBuilder abookSearchQuery() {
    return new BookSearchQueryBuilder();
  }

  public BookSearchQuery build() {
    BookSearchQuery bookSearchQuery =
        new BookSearchQuery(libraryCatalogue, name1, name2, title, date1, date2);
    return bookSearchQuery;
  }

  public BookSearchQueryBuilder withLibrary(LibraryCatalogue p0) {
    this.libraryCatalogue = p0;
    return this;
  }

  public BookSearchQueryBuilder withFirstName(String p1) {
    this.name1 = p1;
    return this;
  }

  public BookSearchQueryBuilder withSecondName(String p2) {
    this.name2 = p2;
    return this;
  }

  public BookSearchQueryBuilder withTitleContaining(String p3) {
    this.title = p3;
    return this;
  }

  public BookSearchQueryBuilder publishedAfter(Integer p4) {
    this.date1 = p4;
    return this;
  }

  public BookSearchQueryBuilder publishedBefore(Integer p5) {
    this.date2 = p5;
    return this;
  }
}
