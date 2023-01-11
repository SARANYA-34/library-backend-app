package com.nestdigital.librarybackendapp.dao;

import com.nestdigital.librarybackendapp.Model.LibraryModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LibraryDao extends CrudRepository<LibraryModel,Integer> {

    @Modifying
    @Query(value = "DELETE FROM `libraries` WHERE `id`= :id",nativeQuery = true)
    void deleteBookById(Integer id);


    @Query(value = "SELECT `id`, `author`, `name`, `stock`, `year` FROM `libraries` WHERE `name`=:name",nativeQuery = true)
    List<LibraryModel> SearchBook(String name);

    @Modifying
    @Query(value = "UPDATE `libraries` SET `author`= :author,`name`= :name,`stock`= :stock,`year`= :year WHERE `id`=:id",nativeQuery = true)
    void editBooks(String author,String name,Integer stock,Integer year,Integer id);
}
