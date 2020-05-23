package com.automation.pojos;

/**
 * "company": {
 * *         "companyId": 11553,
 * *         "companyName": "Cybertek",
 * *         "title": "SDET",
 * *         "startDate": "02/02/2020",
 * *         "address": {
 * *             "addressId": 11573,
 * *             "street": "7925 Jones Branch Dr",
 * *             "city": "McLean",
 * *             "state": "Virginia",
 * *             "zipCode": 22102
 * *         }
 * *     }
 */
public class Company {
    private int companyId;
    private String companyName;
    private String title;
    private String startDate;
    private Address address;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", title='" + title + '\'' +
                ", startDate='" + startDate + '\'' +
                ", address=" + address +
                '}';
    }
}
