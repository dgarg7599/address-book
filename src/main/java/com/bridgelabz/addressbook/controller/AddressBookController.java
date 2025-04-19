package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.service.AddressBookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/contact")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        log.info("Creating AddressBook with name: {} ", addressBookDTO.getName());
        AddressBook addressBook = addressBookService.createAddressBook(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Successfully created AddressBook", addressBook);
        log.info("AddressBook created with name: {} ", addressBookDTO.getName());
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> getAllAddressBooks() {
        log.info("Fetching all AddressBooks...");
        List<AddressBook> addressBook = addressBookService.getAllAddressBooks();
        ResponseDTO responseDTO = new ResponseDTO("All Address Books ", addressBook);
        log.info("Fetched {} AddressBooks", addressBook.size());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getAddressBookById(@PathVariable Long id) {
        log.info("Fetching AddressBook with id: {} ", id);
        AddressBook addressBook = addressBookService.getAddressBookById(id);
        ResponseDTO responseDTO = new ResponseDTO("Address Book with id: " + id, addressBook);
        log.info("Fetched AddressBook with id: {} ", id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateAddressBook(@PathVariable Long id, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        log.info("Updating AddressBook with id: {} ", id);
        AddressBook addressBook = addressBookService.updateAddressBook(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Address Book updated successfully.", addressBook);
        log.info("Updated AddressBook with id: {} ", id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressBook(@PathVariable Long id) {
        log.info("Deleting AddressBook with id: {} ", id);
        addressBookService.deleteAddressBookById(id);
        ResponseDTO responseDTO = new ResponseDTO("Address Book deleted successfully.", id);
        log.info("Deleted AddressBook with id: {} ", id);
        return new ResponseEntity<>(responseDTO, HttpStatus.NO_CONTENT);
    }

}
