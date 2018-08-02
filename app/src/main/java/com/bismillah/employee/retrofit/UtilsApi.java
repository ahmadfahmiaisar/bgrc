package com.bismillah.employee.retrofit;

public class UtilsApi {
    public static final String BASE_URL_API = "http://172.20.20.107/androidsignlogin/v1/";

    public static BaseApiService getApiService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}

