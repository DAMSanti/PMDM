package com.example.appmusica.model

import com.example.appmusica.R
import java.time.LocalDate


data class AudioMusical (val titulo:String, val artist:String, val imagen : Int, val audio:Int, val fecha: LocalDate, val estrellas:Double) {
    companion object {
        val audiosMusicales = listOf(
            AudioMusical(
                titulo = "El Encuentro",
                artist = "Vetusta Morla",
                imagen = R.drawable.vetusta_morla_el_encuentro,
                audio = 1,
                fecha = LocalDate.of(2024, 11, 4),
                estrellas = 4.6
            ),
            AudioMusical(
                titulo = "Baile Existencialista",
                artist = "León Benavente",
                imagen = R.drawable.leon_benavente_baile_existencialista,
                audio = 2,
                fecha = LocalDate.of(2024, 11, 5),
                estrellas = 4.7
            ),
            AudioMusical(
                titulo = "Devenir Paisaje",
                artist = "Fin del Mundo",
                imagen = R.drawable.fin_del_mundo_devenir_paisaje,
                audio = 3,
                fecha = LocalDate.of(2024, 11, 12),
                estrellas = 4.6
            ),
            AudioMusical(
                titulo = "Brujería!",
                artist = "Judeline",
                imagen = R.drawable.judeline_brujeria,
                audio = 4,
                fecha = LocalDate.of(2024, 11, 8),
                estrellas = 4.4
            ),
            AudioMusical(
                titulo = "Nos Volveremos a Ver",
                artist = "La La Love You",
                imagen = R.drawable.la_la_love_you_nos_volveremos_a_ver,
                audio = 5,
                fecha = LocalDate.of(2024, 11, 6),
                estrellas = 4.6
            ),
            AudioMusical(
                titulo = "Tenemos la respuesta",
                artist = "ELYELLA feat. Lori Meyers",
                imagen = R.drawable.elyella_tenemos_la_respuesta,
                audio = 6,
                fecha = LocalDate.of(2024, 11, 10),
                estrellas = 4.5
            )
        )
    }
}
