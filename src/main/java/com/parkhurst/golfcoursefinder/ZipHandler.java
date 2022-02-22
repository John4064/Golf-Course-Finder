package com.parkhurst.golfcoursefinder;



import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import static com.parkhurst.golfcoursefinder.PropertyHandler.getPropValues;

public class ZipHandler extends Handler{
    private String apiKey;
    private String url;

    private String preZip;

    public ZipHandler() throws IOException {
        String[] propArr = getPropValues();
        url = propArr[3];
        apiKey= propArr[1];
    }

    private String makeCall() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url+"/?zipcode="+preZip)
                .get()
                .addHeader("x-rapidapi-host", "us-zip-code-information.p.rapidapi.com")
                .addHeader("x-rapidapi-key", apiKey)
                .build();

        Response response = client.newCall(request).execute();
        return Objects.requireNonNull(response.body()).string();
    }

    private void parseStr(String preParse){
        String lat;
        String lon;
        final JSONArray obj = new JSONArray(preParse);
        try{
            JSONObject jsonobject = obj.getJSONObject(5);
            String name = jsonobject.getString("City");
            lat = jsonobject.getString("Latitude");
            lon = jsonobject.getString("Longitude");
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error on ZIP API CALL");
        }


        //System.out.println(preParse);
    }
    /**
     * @param zipcode a zipcode length 6
     * @brief Uses google api to convert a zipcode to longitude and lattitude
     * @return
     */
    public String[] zipToLL(@NotNull String zipcode) throws IOException {
        if(zipcode.length()!=5){
            return null;
        }
        String[] ans = new String[2];
        preZip=zipcode;
        //parseStr(makeCall());
        parseStr("[{\"ZipCode\":\"6820\",\"City\":\"DARIEN\",\"State\":\"CT\",\"County\":\"FAIRFIELD\",\"AreaCode\":\"203\\/475\",\"CityType\":\"N\",\"CityAliasAbbreviation\":\"\",\"CityAliasName\":\"NOROTON HEIGHTS\",\"Latitude\":\"41.075974\",\"Longitude\":\"-73.481568\",\"TimeZone\":\"5\",\"Elevation\":\"86\",\"CountyFIPS\":\"001\",\"DayLightSaving\":\"Y\",\"PreferredLastLineKey\":\"V20153\",\"ClassificationCode\":\" \",\"MultiCounty\":\" \",\"StateFIPS\":\"9\",\"CityStateKey\":\"V20455\",\"CityAliasCode\":\"\",\"PrimaryRecord\":\" \",\"CityMixedCase\":\"Darien\",\"CityAliasMixedCase\":\"Noroton Heights\",\"StateANSI\":\"9\",\"CountyANSI\":\"001\",\"FacilityCode\":\"N\",\"CityDeliveryIndicator\":\"Y\",\"CarrierRouteRateSortation\":\"D\",\"FinanceNumber\":\"81734\",\"UniqueZIPName\":\"\",\"CountyMixedCase\":\"Fairfield\"},{\"ZipCode\":\"6820\",\"City\":\"DARIEN\",\"State\":\"CT\",\"County\":\"FAIRFIELD\",\"AreaCode\":\"203\\/475\",\"CityType\":\"N\",\"CityAliasAbbreviation\":\"\",\"CityAliasName\":\"TOKENEKE\",\"Latitude\":\"41.075974\",\"Longitude\":\"-73.481568\",\"TimeZone\":\"5\",\"Elevation\":\"86\",\"CountyFIPS\":\"001\",\"DayLightSaving\":\"Y\",\"PreferredLastLineKey\":\"V20153\",\"ClassificationCode\":\" \",\"MultiCounty\":\" \",\"StateFIPS\":\"9\",\"CityStateKey\":\"V20714\",\"CityAliasCode\":\"\",\"PrimaryRecord\":\" \",\"CityMixedCase\":\"Darien\",\"CityAliasMixedCase\":\"Tokeneke\",\"StateANSI\":\"9\",\"CountyANSI\":\"001\",\"FacilityCode\":\"N\",\"CityDeliveryIndicator\":\"Y\",\"CarrierRouteRateSortation\":\"D\",\"FinanceNumber\":\"81734\",\"UniqueZIPName\":\"\",\"CountyMixedCase\":\"Fairfield\"},{\"ZipCode\":\"6820\",\"City\":\"DARIEN\",\"State\":\"CT\",\"County\":\"FAIRFIELD\",\"AreaCode\":\"203\\/475\",\"CityType\":\"N\",\"CityAliasAbbreviation\":\"\",\"CityAliasName\":\"NOROTON\",\"Latitude\":\"41.075974\",\"Longitude\":\"-73.481568\",\"TimeZone\":\"5\",\"Elevation\":\"86\",\"CountyFIPS\":\"001\",\"DayLightSaving\":\"Y\",\"PreferredLastLineKey\":\"V20153\",\"ClassificationCode\":\" \",\"MultiCounty\":\" \",\"StateFIPS\":\"9\",\"CityStateKey\":\"V20453\",\"CityAliasCode\":\"\",\"PrimaryRecord\":\" \",\"CityMixedCase\":\"Darien\",\"CityAliasMixedCase\":\"Noroton\",\"StateANSI\":\"9\",\"CountyANSI\":\"001\",\"FacilityCode\":\"N\",\"CityDeliveryIndicator\":\"Y\",\"CarrierRouteRateSortation\":\"D\",\"FinanceNumber\":\"81734\",\"UniqueZIPName\":\"\",\"CountyMixedCase\":\"Fairfield\"},{\"ZipCode\":\"6820\",\"City\":\"DARIEN\",\"State\":\"CT\",\"County\":\"FAIRFIELD\",\"AreaCode\":\"203\\/475\",\"CityType\":\"P\",\"CityAliasAbbreviation\":\"\",\"CityAliasName\":\"DARIEN\",\"Latitude\":\"41.075974\",\"Longitude\":\"-73.481568\",\"TimeZone\":\"5\",\"Elevation\":\"86\",\"CountyFIPS\":\"001\",\"DayLightSaving\":\"Y\",\"PreferredLastLineKey\":\"V20153\",\"ClassificationCode\":\" \",\"MultiCounty\":\" \",\"StateFIPS\":\"9\",\"CityStateKey\":\"V20153\",\"CityAliasCode\":\"\",\"PrimaryRecord\":\"P\",\"CityMixedCase\":\"Darien\",\"CityAliasMixedCase\":\"Darien\",\"StateANSI\":\"9\",\"CountyANSI\":\"001\",\"FacilityCode\":\"P\",\"CityDeliveryIndicator\":\"Y\",\"CarrierRouteRateSortation\":\"D\",\"FinanceNumber\":\"81734\",\"UniqueZIPName\":\"\",\"CountyMixedCase\":\"Fairfield\"}]\n");
        return ans;
    }
}
