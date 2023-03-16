package com.example.moviesample.util

import okhttp3.Interceptor
import okhttp3.Response
/*
synchronized(): Paralel isteklerde ortaya çıkabilecek hataları engellemek için.
Ne gibi derseniz ilk isteğin tokeni yenilenmeden ikinci atılan istek için token yenileme işlemine başlama durumu gibi.

response.close(): chain.proceed() işlemini yani bir isteği birden fazla çağıracaksak bir öncekini kapatmamız gerekiyor.

refreshToken(): Kendi yapınızda tokeni yenileme işlemlerini orada yapılması gerekiyor.

removeHeader(): Geçerliliğini yitirmiş token bilgisini headerden silmek için kullanıyoruz.
*/
class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url
            .newBuilder()
            .addQueryParameter(API_KEY, "ba9a4de3e4d6d96704500ca20fe6b452")
            .build()

        val requestBuilder = request.newBuilder()
            .url(url)

        return chain.proceed(requestBuilder.build())
    }

    companion object {
        private const val API_KEY = "api_key"
    }
}