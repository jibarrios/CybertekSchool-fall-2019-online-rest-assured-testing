package com.automation.pojos;

/**
 * "address": {
 * *  *             "addressId": 11573,
 * *  *             "street": "7925 Jones Branch Dr",
 * *  *             "city": "McLean",
 * *  *             "state": "Virginia",
 * *  *             "zipCode": 22102
 * *  *         }
 */
public class Address {
    private int addressId;
    private String street;
    private String city;
    private String state;
    private int zipCode;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
