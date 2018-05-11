package vn.asiantech.internship.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.asiantech.internship.BuildConfig;

import java.util.concurrent.TimeUnit;

public class ApiServices {
    private static final String BASE_URL = "https://rest.bandsintown.com";
    private static final int CONNECT_TIMEOUT_MILLS = 1000 * 120;
    private static ApiServices sApiServices;
    private IEventApi mIEventApi;

    public static ApiServices getApiServices() {
        if (sApiServices == null) {
            sApiServices = new ApiServices();
        }
        return sApiServices;
    }

    private ApiServices() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClientBuilder().build())
                .build();
        mIEventApi = retrofit.create(IEventApi.class);
    }

    private OkHttpClient.Builder getOkHttpClientBuilder() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT_MILLS, TimeUnit.MILLISECONDS)
                .readTimeout(CONNECT_TIMEOUT_MILLS, TimeUnit.MILLISECONDS)
                .writeTimeout(CONNECT_TIMEOUT_MILLS, TimeUnit.MILLISECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClientBuilder.addInterceptor(interceptor);
        }
        return okHttpClientBuilder;
    }

    public IEventApi getIEventApi() {
        return mIEventApi;
    }
}
