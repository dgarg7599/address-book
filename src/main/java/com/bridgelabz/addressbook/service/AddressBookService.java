package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exceptions.AddressBookDataException;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public AddressBook createAddressBook(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(addressBookDTO);
        log.debug("Address Book data: {}", addressBook);
        return addressBookRepository.save(addressBook);
    }

    @Override
    public List<AddressBook> getAllAddressBooks() {
        log.info("Fetching All Address Book Data...");
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBook getAddressBookById(Long id) {
        log.info("Fetching Address Book Data by ID: {}", id);
        return addressBookRepository.findById(id).orElseThrow(() -> {log.error("Address Book Data by ID {} not found", id);
        return new AddressBookDataException("No contact by this Id {}" + id);});
    }

    @Override
    public AddressBook updateAddressBook(Long id, AddressBookDTO addressBookDTO) {
        log.info("Updating Address Book Data by ID: {}", id);
        AddressBook addressBook = getAddressBookById(id);
        addressBook.updateAddressBook(addressBookDTO);
        return addressBookRepository.save(addressBook);
    }

    @Override
    public void deleteAddressBookById(Long id) {
        log.info("Delete contact with id: {}", id);
        addressBookRepository.deleteById(id);
    }
}
