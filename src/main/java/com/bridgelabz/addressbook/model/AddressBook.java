package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;

    private String name;
    private String email;

    @ElementCollection
    @CollectionTable(name = "contact_phone", joinColumns = @JoinColumn(name = "contactId"))
    @Column(name = "phone")
    private List<String> phone;

    private String address;
    private String city;
    private String state;

    public AddressBook(AddressBookDTO addressBookDTO) {
        this.updateAddressBook(addressBookDTO);
    }

    public void updateAddressBook(AddressBookDTO addressBookDTO) {
        this.name = addressBookDTO.getName();
        this.email = addressBookDTO.getEmail();
        this.phone = addressBookDTO.getPhone();
        this.address = addressBookDTO.getAddress();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
    }
}
