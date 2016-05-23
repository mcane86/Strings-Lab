package Tools;

import com.michaelcane.DriversLicense;

public class CompareUtils {

    public static boolean compareCSV(DriversLicense license1, DriversLicense license2) {
        if (!license1.getName().equals(license2.getName())) {
            return false;
        } else if (!license1.getAddress().equals(license2.getAddress())) {
            return false;
        } else if (!license1.getEyeColor().equals(license2.getEyeColor())) {
            return false;
        } else if (!license1.getDateOfBirth().equals(license2.getDateOfBirth())) {
            return false;
        } else if (!license1.getIssueDate().equals(license2.getIssueDate())) {
            return false;
        } else if (!license1.getExpirationDate().equals(license2.getExpirationDate())) {
            return false;
        } else if (!license1.getLicenseNumber().equals(license2.getLicenseNumber())) {
            return false;
        } else if (!license1.getIssuingState().equals(license2.getIssuingState())) {
            return false;
        } else if (!license1.getEndorsements().equals(license2.getEndorsements())) {
            return false;
        } else if (license1.getSex() != license2.getSex()) {
            return false;
        } else if (license1.isFederallyCompliant() != license2.isFederallyCompliant()) {
            return false;
        } else if (license1.getLicenseClassification() != license2.getLicenseClassification()) {
            return false;
        } else {
            return true;
        }
    }
}
