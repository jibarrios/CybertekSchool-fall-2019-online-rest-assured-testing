package com.automation.pojos;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * {
 *             "employee_id": 100,
 *             "first_name": "Steven",
 *             "last_name": "King",
 *             "email": "SKING",
 *             "phone_number": "515.123.4567",
 *             "hire_date": "2003-06-17T04:00:00Z",
 *             "job_id": "AD_PRES",
 *             "salary": 24000,
 *             "commission_pct": null,
 *             "manager_id": null,
 *             "department_id": 90,
 *             "links": [
 *                 {
 *                     "rel": "self",
 *                     "href": "http://3.85.41.58:1000/ords/hr/employees/100"
 *                 }
 *             ]
 *         },
 */
public class Employee {
    @SerializedName("employee_id")
    private int employeeId;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    private String email; // --> "email": "SKING", since name is the same, no need to use @SerializedName
    @SerializedName("phone_number")
    private String phoneNumber;
    @SerializedName("hire_date")
    private String hireDate;
    @SerializedName("job_id")
    private String jobId;
    private int salary;
    @SerializedName("commission_pct")
    private double commissionPct;
    @SerializedName("manager_id")
    private int managerId;
    @SerializedName("department_id")
    private int departmentId;
    private List<Link> links;

    public int getEmployeeId() {
        return employeeId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(double commissionPct) {
        this.commissionPct = commissionPct;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", jobId='" + jobId + '\'' +
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                ", managerId=" + managerId +
                ", departmentId=" + departmentId +
                ", links=" + links +
                '}';
    }
}
