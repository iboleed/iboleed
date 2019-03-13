package com.iboleed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@RestController
//@RequestMapping("/books")
public class IboleedApplication {

	public static void main(String[] args) {
		SpringApplication.run(IboleedApplication.class, args);
	}

//	private List<Book> bookList = Arrays.asList(
//			new Book(1L, "Baeldung goes to the market", "Tim Schimandle"),
//			new Book(2L, "Baeldung goes to the park", "Slavisa")
//	);
//
//	@GetMapping("")
//	public List<Book> findAllBooks() {
//		return bookList;
//	}
//
//	@GetMapping("/{bookId}")
//	public Book findBook(@PathVariable Long bookId) {
//		return bookList.stream().filter(b -> b.getId().equals(bookId)).findFirst().orElse(null);
//	}
//
//	class Book {
//    private Long id;
//    private String author;
//    private String title;
// 
//		    // standard getters and setters
//
//	}

}

