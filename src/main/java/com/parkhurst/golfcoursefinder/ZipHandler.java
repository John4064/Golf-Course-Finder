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

    public ZipHandler() throws IOException {
        String[] propArr = getPropValues();
        //Check if null
        url = propArr[3];
        System.out.println(apiKey);

        //apiKey= propArr[1];
    }

    /**@param preZip This is the zipcode for the apiCAll
     * @brief This method makes the api call based on the Zipcode parameter
     * @return Jsonarray as a String
     * @throws IOException
     */
    private String makeCall(String preZip) throws IOException {
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

    /**
     * @param preParse: The json array we get from our API call
     * @return A String array of length two of Lattiude,longitude
     */
    private String[] parseStr(String preParse){
        String[] longLatArr = new String[2];
        final JSONArray obj = new JSONArray(preParse);
        try{
            JSONObject jsonobject = obj.getJSONObject(0);
            longLatArr[0]=jsonobject.getString("Latitude");
            longLatArr[1]= jsonobject.getString("Longitude");
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error on Reading API CALL");
        }
        return longLatArr;
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
        return parseStr(makeCall(zipcode));
        //return parseStr("[{\"ZipCode\":\"6820\",\"City\":\"DARIEN\",\"State\":\"CT\",\"County\":\"FAIRFIELD\",\"AreaCode\":\"203\\/475\",\"CityType\":\"N\",\"CityAliasAbbreviation\":\"\",\"CityAliasName\":\"NOROTON HEIGHTS\",\"Latitude\":\"41.075974\",\"Longitude\":\"-73.481568\",\"TimeZone\":\"5\",\"Elevation\":\"86\",\"CountyFIPS\":\"001\",\"DayLightSaving\":\"Y\",\"PreferredLastLineKey\":\"V20153\",\"ClassificationCode\":\" \",\"MultiCounty\":\" \",\"StateFIPS\":\"9\",\"CityStateKey\":\"V20455\",\"CityAliasCode\":\"\",\"PrimaryRecord\":\" \",\"CityMixedCase\":\"Darien\",\"CityAliasMixedCase\":\"Noroton Heights\",\"StateANSI\":\"9\",\"CountyANSI\":\"001\",\"FacilityCode\":\"N\",\"CityDeliveryIndicator\":\"Y\",\"CarrierRouteRateSortation\":\"D\",\"FinanceNumber\":\"81734\",\"UniqueZIPName\":\"\",\"CountyMixedCase\":\"Fairfield\"},{\"ZipCode\":\"6820\",\"City\":\"DARIEN\",\"State\":\"CT\",\"County\":\"FAIRFIELD\",\"AreaCode\":\"203\\/475\",\"CityType\":\"N\",\"CityAliasAbbreviation\":\"\",\"CityAliasName\":\"TOKENEKE\",\"Latitude\":\"41.075974\",\"Longitude\":\"-73.481568\",\"TimeZone\":\"5\",\"Elevation\":\"86\",\"CountyFIPS\":\"001\",\"DayLightSaving\":\"Y\",\"PreferredLastLineKey\":\"V20153\",\"ClassificationCode\":\" \",\"MultiCounty\":\" \",\"StateFIPS\":\"9\",\"CityStateKey\":\"V20714\",\"CityAliasCode\":\"\",\"PrimaryRecord\":\" \",\"CityMixedCase\":\"Darien\",\"CityAliasMixedCase\":\"Tokeneke\",\"StateANSI\":\"9\",\"CountyANSI\":\"001\",\"FacilityCode\":\"N\",\"CityDeliveryIndicator\":\"Y\",\"CarrierRouteRateSortation\":\"D\",\"FinanceNumber\":\"81734\",\"UniqueZIPName\":\"\",\"CountyMixedCase\":\"Fairfield\"},{\"ZipCode\":\"6820\",\"City\":\"DARIEN\",\"State\":\"CT\",\"County\":\"FAIRFIELD\",\"AreaCode\":\"203\\/475\",\"CityType\":\"N\",\"CityAliasAbbreviation\":\"\",\"CityAliasName\":\"NOROTON\",\"Latitude\":\"41.075974\",\"Longitude\":\"-73.481568\",\"TimeZone\":\"5\",\"Elevation\":\"86\",\"CountyFIPS\":\"001\",\"DayLightSaving\":\"Y\",\"PreferredLastLineKey\":\"V20153\",\"ClassificationCode\":\" \",\"MultiCounty\":\" \",\"StateFIPS\":\"9\",\"CityStateKey\":\"V20453\",\"CityAliasCode\":\"\",\"PrimaryRecord\":\" \",\"CityMixedCase\":\"Darien\",\"CityAliasMixedCase\":\"Noroton\",\"StateANSI\":\"9\",\"CountyANSI\":\"001\",\"FacilityCode\":\"N\",\"CityDeliveryIndicator\":\"Y\",\"CarrierRouteRateSortation\":\"D\",\"FinanceNumber\":\"81734\",\"UniqueZIPName\":\"\",\"CountyMixedCase\":\"Fairfield\"},{\"ZipCode\":\"6820\",\"City\":\"DARIEN\",\"State\":\"CT\",\"County\":\"FAIRFIELD\",\"AreaCode\":\"203\\/475\",\"CityType\":\"P\",\"CityAliasAbbreviation\":\"\",\"CityAliasName\":\"DARIEN\",\"Latitude\":\"41.075974\",\"Longitude\":\"-73.481568\",\"TimeZone\":\"5\",\"Elevation\":\"86\",\"CountyFIPS\":\"001\",\"DayLightSaving\":\"Y\",\"PreferredLastLineKey\":\"V20153\",\"ClassificationCode\":\" \",\"MultiCounty\":\" \",\"StateFIPS\":\"9\",\"CityStateKey\":\"V20153\",\"CityAliasCode\":\"\",\"PrimaryRecord\":\"P\",\"CityMixedCase\":\"Darien\",\"CityAliasMixedCase\":\"Darien\",\"StateANSI\":\"9\",\"CountyANSI\":\"001\",\"FacilityCode\":\"P\",\"CityDeliveryIndicator\":\"Y\",\"CarrierRouteRateSortation\":\"D\",\"FinanceNumber\":\"81734\",\"UniqueZIPName\":\"\",\"CountyMixedCase\":\"Fairfield\"}]\n");
    }
}
