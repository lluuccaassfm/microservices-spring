package com.estudo.bookservice.controller;

import com.estudo.bookservice.client.CambioClient;
import com.estudo.bookservice.model.Book;
import com.estudo.bookservice.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CambioClient cambioClient;

    @Operation(summary = "Find a specific book by your ID")
    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {
        var book = bookRepository.getById(id);

        var cambio = cambioClient.getCambio(book.getPrice(), "USD", currency);

        var port = environment.getProperty("local.server.port");
        book.setEnvironment(
                "Book port: " + port +
                        " Cambio port: " + cambio.getEnviroment());
        book.setPrice(cambio.getConvertValue());
        return book;
    }

    /*
    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {
        var book = bookRepository.getById(id);
        var port = environment.getProperty("local.server.port");

        HashMap<String, String> params = new HashMap<>();
        params.put("amount", book.getPrice().toString());
        params.put("from", "USD");
        params.put("to", currency);
        var response = new RestTemplate().getForEntity("http://localhost:8000/cambio-service/" +
                "{amount}/{from}/{to}", Cambio.class, params);

        var cambio = response.getBody();
        book.setEnvironment(port);
        book.setPrice(cambio.getConvertValue());
        return book;
    } */
}
