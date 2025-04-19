package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;

import java.util.List;

public interface IAddressBookService {

    AddressBook createAddressBook(AddressBookDTO addressBookDTO);
    List<AddressBook> getAllAddressBooks();
    AddressBook getAddressBookById(Long id);
    AddressBook updateAddressBook(Long id, AddressBookDTO addressBookDTO);
    void deleteAddressBookById(Long id);

}
