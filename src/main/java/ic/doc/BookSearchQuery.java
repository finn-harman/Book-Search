package ic.doc;

import ic.doc.catalogues.LibraryCatalogue;

import java.util.List;

public class BookSearchQuery {

  private final LibraryCatalogue libraryCatalogue;
  private final String name1;
  private final String name2;
  private final String title;
  private final Integer date1;
  private final Integer date2;

  public BookSearchQuery(
      LibraryCatalogue p0, String p1, String p2, String p3, Integer p4, Integer p5) {
    this.libraryCatalogue = p0;
    this.name1 = p1;
    this.name2 = p2;
    this.title = p3;
    this.date1 = p4;
    this.date2 = p5;
  }

  public List<Book> execute() {
    StringBuffer query = new StringBuffer();
    if (name1 != null) {
      query.append("FIRSTNAME='").append(name1).append("' ");
    }
    if (name2 != null) {
      query.append("LASTNAME='").append(name2).append("' ");
    }
    if (title != null) {
      query.append("TITLECONTAINS(").append(title).append(") ");
    }
    if (date1 != null) {
      query.append("PUBLISHEDAFTER(").append(date1).append(") ");
    }
    if (date2 != null) {
      query.append("PUBLISHEDBEFORE(").append(date2).append(") ");
    }
    System.out.println(query);
    return libraryCatalogue.searchFor(query.toString());
  }
}
