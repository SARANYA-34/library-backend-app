package com.nestdigital.librarybackendapp.Controller;

import com.nestdigital.librarybackendapp.Model.LibraryModel;
import com.nestdigital.librarybackendapp.dao.LibraryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.transaction.Transactional;
import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private LibraryDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/bookentry",consumes = "application/json",produces = "application/json")
    public String Bookentry(@RequestBody LibraryModel library){
        System.out.println(library.toString());
        dao.save(library);
        return "{Status:'Success'}";
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/viewbook")
    public List<LibraryModel> ViewBook(){
        return (List<LibraryModel>)dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/deletebook",consumes = "application/json",produces = "application/json")
    public String DeleteBook(@RequestBody LibraryModel library){
        dao.deleteBookById(library.getId());
        return "{Status:'Success'}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchBook",consumes = "application/json",produces = "application/json")
    public List<LibraryModel> Searchbook(@RequestBody LibraryModel library)
    {
        return (List<LibraryModel>) dao.SearchBook(library.getName());
    }

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/editBook",consumes = "application/json",produces = "application/json")
    public String EditBook(@RequestBody LibraryModel library){
        dao.editBooks(library.getAuthor(),library.getName(),library.getStock(),library.getYear(),library.getId());
        return "{status:'Success'}";
    }


}
