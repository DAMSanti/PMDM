package com.example.aplicacionretrofit.interfaz

import com.example.aplicacionretrofit.models.Heroe
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiService {
    @GET("heroe")
    suspend fun getHeroes(): List<Heroe>

    @POST("heroe")
    suspend fun addHeroe(@Body heroe: Heroe): Heroe
}

object RetrofitClient {
    private const val BASE_URL = "https://crudcrud.com/api/ca5628a2eb7d4972853a7ec0aca7a330/"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}