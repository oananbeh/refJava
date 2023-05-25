@RestController
@RequestMapping("/api/books")
public class BookController {

    private List<Book> books;

    public BookController() {
        books = new ArrayList<>();
        books.add(new Book("123", "Java Programming"));
        books.add(new Book("456", "Spring Boot in Action"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return ResponseEntity.ok(book);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        books.add(book);
        return ResponseEntity.ok(book);
    }

    // Other controller methods...

}
