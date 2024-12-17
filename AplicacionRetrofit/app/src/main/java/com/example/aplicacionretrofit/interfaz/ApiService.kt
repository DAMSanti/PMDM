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
    private const val BASE_URL = "https://crudcrud.com/api/b76227add08545a8a9cfae731e4d3dae/"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}