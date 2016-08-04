package com.maowubian.baseproject.api;

import android.app.Application;
import android.content.Context;

import com.maowubian.baseproject.factory.StoreConfigFactory;
import com.maowubian.baseproject.utils.DimensUtil;
import com.orhanobut.logger.Logger;


/**
 * Created by zhuruqiao on 16/8/1.
 */
public class AppContext extends Application {

    public static Context mContext;
    public static int statusBarHeight;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        statusBarHeight= DimensUtil.getStatusbarHeight();


    }

//    private void initOkhttp() {
//        long httpCacheSize = StoreConfigFactory.configStoreLimitSize(StoreConfigFactory.DIRECTORY_HTTP);
//        File httpCacheDirectory = new File(StoreConfigFactory.getStorePath(StoreConfigFactory.DIRECTORY_HTTP));
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .connectTimeout(30, TimeUnit.SECONDS)
//                .readTimeout(60,TimeUnit.SECONDS)
//                .writeTimeout(60,TimeUnit.SECONDS)
//                .followRedirects(true)
//                .retryOnConnectionFailure(true)
//                .addNetworkInterceptor(new UsualRequestInterceptor())
//                .cache(new Cache(httpCacheDirectory, httpCacheSize))
//                .authenticator(new Authenticator() {
//                    @Override
//                    public Request authenticate(Route route, Response response) throws IOException {
//                        AccountManager.get().invalidateToken();
//                        try {
//                            String token = AccountManager.get().getToken();
//                            return response.request().newBuilder().header("token", token).build();
//                        } catch (Exception ignored) {
//
//                        }
//                        return response.request();
//                    }
//                })
//                .build();
//        mObjectMapper = configObjectMapper();
//        JacksonConverterFactory factory = JacksonConverterFactory.create(mObjectMapper);
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
//                .client(okHttpClient)
//                .addConverterFactory(factory)
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//
//        service = retrofit.create(MarketService.class);
//    }
}
