package APIModels;

import lombok.Data;

@Data
public class Books {
    private BooksResponse books[];

    @Data
    public static class BooksResponse {
        private String isbn;
        private String title;
        private String subTitle;
        private String author;
        private String publish_date;
        private String publisher;
        private int pages;
        private String description;
        private String website;
    }
}
