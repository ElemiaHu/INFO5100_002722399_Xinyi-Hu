package com.example.exercise4;
import java.util.regex.*;

public class RegexDemo {

    private static void matchHelper (String name, String test, Matcher matcher) {
        if (matcher.find()) {
            System.out.println(name + " \"" + test + "\" " +"is valid.");
        } else {
            System.out.println(name + " \"" + test + "\" " +"is not valid.");
        }
    }

    public static void main (String[] args) {
        //Flight Number
        Pattern flight = Pattern.compile("\\b[A-Z]{2,3}[1-9][0-9]*\\b");
        String testFlight = "UA1";
        Matcher flightMatcher = flight.matcher(testFlight);
        matchHelper("Flight number", testFlight, flightMatcher);
        testFlight = "UAL0024";
        flightMatcher = flight.matcher(testFlight);
        matchHelper("Flight number", testFlight, flightMatcher);

        //IP address
        Pattern ip = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
        String testIP = "12.1.1.108";
        Matcher ipMatcher = ip.matcher(testIP);
        matchHelper("IP address", testIP, ipMatcher);
        testIP = "002.003.0-2.110";
        ipMatcher = ip.matcher(testIP);
        matchHelper("IP address", testIP, ipMatcher);

        //Date
        Pattern date = Pattern.compile("\\b(0?[1-9]|1[0-2])[./-](0?[1-9]|[12][0-9]|3[01])[./-](19|20)[0-9][0-9]\\b");
        String testDate = "10/21/1998";
        Matcher dateMatcher = date.matcher(testDate);
        matchHelper("Date", testDate, dateMatcher);
        testDate = "24/17/1999";
        dateMatcher = date.matcher(testDate);
        matchHelper("Date", testDate, dateMatcher);

        //Full name
        Pattern name = Pattern.compile("^[A-Z][a-z]*( [A-Z][a-z]*){1,2}$");
        String testFullName = "James Bond";
        Matcher nameMatcher = name.matcher(testFullName);
        matchHelper("Full name", testFullName, nameMatcher);
        testFullName = "James Bond 007";
        nameMatcher = name.matcher(testFullName);
        matchHelper("Full name", testFullName, nameMatcher);

        //Zip Code
        Pattern zipCode = Pattern.compile("\\b\\d{5}(-\\d{4})?\\b");
        String testZip = "95134";
        Matcher zipMatcher = zipCode.matcher(testZip);
        matchHelper("Zip code", testZip, zipMatcher);
        testZip = "94123-23";
        zipMatcher = zipCode.matcher(testZip);
        matchHelper("Zip code", testZip, zipMatcher);
    }
}
