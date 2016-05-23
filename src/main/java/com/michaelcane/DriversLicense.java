package com.michaelcane;

import Tools.MyStringUtils;

import java.util.*;
import java.util.spi.CalendarNameProvider;

import static Tools.MyStringUtils.*;

public class DriversLicense {

    private String name, address, licenseNumber, endorsements, issuingState, eyeColor;

    private int height;
    private double weight;
    private char licenseClassification, sex;
    private boolean organDonor, federallyCompliant;
    private Date dateOfBirth, issueDate, expirationDate;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public char getLicenseClassification() {
        return licenseClassification;
    }

    public void setLicenseClassification(char licenseClassification) {
        this.licenseClassification = licenseClassification;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public boolean isOrganDonor() {
        return organDonor;
    }

    public void setOrganDonor(boolean organDonor) {
        this.organDonor = organDonor;
    }

    public boolean isFederallyCompliant() {
        return federallyCompliant;
    }

    public void setFederallyCompliant(boolean federallyCompliant) {
        this.federallyCompliant = federallyCompliant;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getEndorsements() {
        return endorsements;
    }

    public void setEndorsements(String endorsements) {
        this.endorsements = endorsements;
    }

    public String getIssuingState() {
        return issuingState;
    }

    public void setIssuingState(String issuingState) {
        this.issuingState = issuingState;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * (include description of field order here)
     * @return
     */
    public String serializeToCSV(){

        StringBuilder csvBuilder = new StringBuilder();

        csvBuilder.append("\n").append(name).append(',')
                .append(address).append(',')
                .append(eyeColor).append(',')
                .append(dateOfBirth).append(',')
                .append(issueDate).append(',')
                .append(expirationDate).append(',')
                .append(licenseNumber).append(',')
                .append(issuingState).append(',')
                .append(endorsements).append(',')
                .append(sex).append(',')
                .append(federallyCompliant).append(',')
                .append(licenseClassification);

        return csvBuilder.toString();
    }

    public static String getCSVHeader(){
        return "NAME,ADDRESS,EYE COLOR,DATE OF BIRTH,ISSUE DATE,EXPIRATION DATE,LICENSE NUMBER,STATE,ENDORSEMENTS,SEX,FEDERAL COMPLIANCE,CLASSIFICATION";
    }

    public static List<DriversLicense> deserializeFromCSV(String content) throws Exception {
        Scanner stringReader = new Scanner(content);
        List<DriversLicense> licenses = new ArrayList<>();
        stringReader.nextLine();

        while(stringReader.hasNextLine()) {
            String[] licenseEntries = stringReader.nextLine().split(",");
            DriversLicense licenseBuilder = new DriversLicense();

            licenseBuilder.setName(licenseEntries[0]);
            licenseBuilder.setAddress(licenseEntries[1]);
            licenseBuilder.setEyeColor(licenseEntries[2]);
            licenseBuilder.setDateOfBirth(convertStringToDate(licenseEntries[3]));
            licenseBuilder.setIssueDate(convertStringToDate(licenseEntries[4]));
            licenseBuilder.setExpirationDate(convertStringToDate(licenseEntries[5]));
            licenseBuilder.setLicenseNumber(licenseEntries[6]);
            licenseBuilder.setIssuingState(licenseEntries[7]);
            licenseBuilder.setEndorsements(licenseEntries[8]);
            licenseBuilder.setSex(convertStringToChar(licenseEntries[9]));
            licenseBuilder.setFederallyCompliant(convertStringToBoolean(licenseEntries[10]));
            licenseBuilder.setLicenseClassification(convertStringToChar(licenseEntries[11]));

            licenses.add(licenseBuilder);
        }
        return licenses;
    }
}
