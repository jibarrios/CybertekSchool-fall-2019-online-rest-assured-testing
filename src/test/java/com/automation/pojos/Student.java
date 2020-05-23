package com.automation.pojos;

/**
 * {
 * "studentId": 10662,
 * "firstName": "Vera",
 * "lastName": "Jakson",
 * "batch": 14,
 * "joinDate": "02/02/2020",
 * "birthDate": "02/02/1985",
 * "password": "123",
 * "subject": "string",
 * "gender": "F",
 * "admissionNo": "string",
 * "major": "abc",
 * "section": "12",
 * "contact": {
 * "contactId": 10662,
 * "phone": "7738557985",
 * "emailAddress": "aaa@gmail.com",
 * "premanentAddress": "123 main str"
 * },
 * "company": {
 * "companyId": 10662,
 * "companyName": "Cybertek",
 * "title": "string",
 * "startDate": "string",
 * "address": {
 * "addressId": 10662,
 * "street": " 100 S Clark str",
 * "city": "Chicago",
 * "state": "IL",
 * "zipCode": 60606
 * }
 * }
 * },
 */
public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private int batch;
    private String joinDate;
    private String birthDate;
    private String password;
    private String subject;
    private String gender;
    private String admissionNo;
    private String major;
    private String section;
    private Contact contact;
    private Company company;

    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdmissionNo() {
        return admissionNo;
    }

    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", batch=" + batch +
                ", joinDate='" + joinDate + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", password='" + password + '\'' +
                ", subject='" + subject + '\'' +
                ", gender='" + gender + '\'' +
                ", admissionNo='" + admissionNo + '\'' +
                ", major='" + major + '\'' +
                ", section='" + section + '\'' +
                ", contact=" + contact +
                ", company=" + company +
                '}';
    }
}
