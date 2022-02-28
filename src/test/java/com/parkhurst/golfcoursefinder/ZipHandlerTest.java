package com.parkhurst.golfcoursefinder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZipHandlerTest {

    //Fields
    static ZipHandler zipH;

    @BeforeEach
    void setUp() throws IOException {
        System.out.println("Executing Setup");
        zipH = new ZipHandler();
    }

    @Tag("Parse")
    @Test
    void testParse() {
        System.out.println("Executing Test 1");
        String[] longLatArr = new String[2];
        longLatArr[1] = "-73.481568";
        longLatArr[0] = "41.075974";
        assertEquals(Arrays.toString(zipH.parseStr("[{\"ZipCode\":\"6820\",\"City\":\"DARIEN\",\"State\":\"CT\",\"County\":\"FAIRFIELD\",\"AreaCode\":\"203\\/475\",\"CityType\":\"N\",\"CityAliasAbbreviation\":\"\",\"CityAliasName\":\"NOROTON HEIGHTS\",\"Latitude\":\"41.075974\",\"Longitude\":\"-73.481568\",\"TimeZone\":\"5\",\"Elevation\":\"86\",\"CountyFIPS\":\"001\",\"DayLightSaving\":\"Y\",\"PreferredLastLineKey\":\"V20153\",\"ClassificationCode\":\" \",\"MultiCounty\":\" \",\"StateFIPS\":\"9\",\"CityStateKey\":\"V20455\",\"CityAliasCode\":\"\",\"PrimaryRecord\":\" \",\"CityMixedCase\":\"Darien\",\"CityAliasMixedCase\":\"Noroton Heights\",\"StateANSI\":\"9\",\"CountyANSI\":\"001\",\"FacilityCode\":\"N\",\"CityDeliveryIndicator\":\"Y\",\"CarrierRouteRateSortation\":\"D\",\"FinanceNumber\":\"81734\",\"UniqueZIPName\":\"\",\"CountyMixedCase\":\"Fairfield\"},{\"ZipCode\":\"6820\",\"City\":\"DARIEN\",\"State\":\"CT\",\"County\":\"FAIRFIELD\",\"AreaCode\":\"203\\/475\",\"CityType\":\"N\",\"CityAliasAbbreviation\":\"\",\"CityAliasName\":\"TOKENEKE\",\"Latitude\":\"41.075974\",\"Longitude\":\"-73.481568\",\"TimeZone\":\"5\",\"Elevation\":\"86\",\"CountyFIPS\":\"001\",\"DayLightSaving\":\"Y\",\"PreferredLastLineKey\":\"V20153\",\"ClassificationCode\":\" \",\"MultiCounty\":\" \",\"StateFIPS\":\"9\",\"CityStateKey\":\"V20714\",\"CityAliasCode\":\"\",\"PrimaryRecord\":\" \",\"CityMixedCase\":\"Darien\",\"CityAliasMixedCase\":\"Tokeneke\",\"StateANSI\":\"9\",\"CountyANSI\":\"001\",\"FacilityCode\":\"N\",\"CityDeliveryIndicator\":\"Y\",\"CarrierRouteRateSortation\":\"D\",\"FinanceNumber\":\"81734\",\"UniqueZIPName\":\"\",\"CountyMixedCase\":\"Fairfield\"},{\"ZipCode\":\"6820\",\"City\":\"DARIEN\",\"State\":\"CT\",\"County\":\"FAIRFIELD\",\"AreaCode\":\"203\\/475\",\"CityType\":\"N\",\"CityAliasAbbreviation\":\"\",\"CityAliasName\":\"NOROTON\",\"Latitude\":\"41.075974\",\"Longitude\":\"-73.481568\",\"TimeZone\":\"5\",\"Elevation\":\"86\",\"CountyFIPS\":\"001\",\"DayLightSaving\":\"Y\",\"PreferredLastLineKey\":\"V20153\",\"ClassificationCode\":\" \",\"MultiCounty\":\" \",\"StateFIPS\":\"9\",\"CityStateKey\":\"V20453\",\"CityAliasCode\":\"\",\"PrimaryRecord\":\" \",\"CityMixedCase\":\"Darien\",\"CityAliasMixedCase\":\"Noroton\",\"StateANSI\":\"9\",\"CountyANSI\":\"001\",\"FacilityCode\":\"N\",\"CityDeliveryIndicator\":\"Y\",\"CarrierRouteRateSortation\":\"D\",\"FinanceNumber\":\"81734\",\"UniqueZIPName\":\"\",\"CountyMixedCase\":\"Fairfield\"},{\"ZipCode\":\"6820\",\"City\":\"DARIEN\",\"State\":\"CT\",\"County\":\"FAIRFIELD\",\"AreaCode\":\"203\\/475\",\"CityType\":\"P\",\"CityAliasAbbreviation\":\"\",\"CityAliasName\":\"DARIEN\",\"Latitude\":\"41.075974\",\"Longitude\":\"-73.481568\",\"TimeZone\":\"5\",\"Elevation\":\"86\",\"CountyFIPS\":\"001\",\"DayLightSaving\":\"Y\",\"PreferredLastLineKey\":\"V20153\",\"ClassificationCode\":\" \",\"MultiCounty\":\" \",\"StateFIPS\":\"9\",\"CityStateKey\":\"V20153\",\"CityAliasCode\":\"\",\"PrimaryRecord\":\"P\",\"CityMixedCase\":\"Darien\",\"CityAliasMixedCase\":\"Darien\",\"StateANSI\":\"9\",\"CountyANSI\":\"001\",\"FacilityCode\":\"P\",\"CityDeliveryIndicator\":\"Y\",\"CarrierRouteRateSortation\":\"D\",\"FinanceNumber\":\"81734\",\"UniqueZIPName\":\"\",\"CountyMixedCase\":\"Fairfield\"}]\n")), Arrays.toString(longLatArr));
    }
}