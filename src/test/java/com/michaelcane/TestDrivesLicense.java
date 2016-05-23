package com.michaelcane;

import Tools.CompareUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;

public class TestDrivesLicense {

    DriversLicense testLicense;

    private String name = "Mike Jones";
    private String address = "123 Atl drive";
    private String eyeColor = "Brown";
    private Date expectedDOB = new Date(); // 3 times
    private Date expectedIssueDate = expectedDOB;
    private Date expectedExpirationDate = expectedDOB;
    private String licenseNum = "007";
    private String issuingState = "TX";
    private String trump = "Trump";
    private char male = 'M';
    private boolean federallyCompliantStatus = false;
    private char licenseClassification = 'C';

    @Before
    public void setUp() throws Exception {
        testLicense = new DriversLicense();

        testLicense.setName(name);
        testLicense.setAddress(address);
        testLicense.setEyeColor(eyeColor);
        testLicense.setDateOfBirth(expectedDOB);
        testLicense.setIssueDate(expectedIssueDate);
        testLicense.setExpirationDate(expectedExpirationDate);
        testLicense.setLicenseNumber(licenseNum);
        testLicense.setIssuingState(issuingState);
        testLicense.setEndorsements(trump);
        testLicense.setSex(male);
        testLicense.setFederallyCompliant(federallyCompliantStatus);
        testLicense.setLicenseClassification(licenseClassification);
    }

    @Test
    public void testSerializeToCSV() throws Exception {

        String actualCSVResult = testLicense.serializeToCSV();

        String expectedCSVResult = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%c,%b,%c",
                name, address, eyeColor, expectedDOB,expectedIssueDate, expectedExpirationDate,
                licenseNum, issuingState, trump, male, federallyCompliantStatus, licenseClassification);

        assertEquals("Actual CSV result did not match expectations.",expectedCSVResult, actualCSVResult);
    }

    @Test
    public void testGetCSVHeader(){
        /*
        order: name, address, eyeColor, expectedDOB,expectedIssueDate, expectedExpirationDate,
                licenseNum, issuingState, trump, male, federallyCompliantStatus, licenseClassification
         */
        String expectedHeader = "NAME,ADDRESS,EYE COLOR,DATE OF BIRTH,ISSUE DATE,EXPIRATION DATE," +
                "LICENSE NUMBER,STATE,ENDORSEMENTS,SEX,FEDERAL COMPLIANCE,CLASSIFICATION";

        String actualHeader = DriversLicense.getCSVHeader();

        assertEquals(expectedHeader, actualHeader);
    }

    @Test
    public void testDeserializeFromCSV() throws Exception {
        List<DriversLicense> licenses = DriversLicense.deserializeFromCSV(DriversLicense.getCSVHeader() + testLicense.serializeToCSV());
        DriversLicense deserializedTestLicense = licenses.get(0);
        assertTrue(CompareUtils.compareCSV(deserializedTestLicense, testLicense));
    }
}
