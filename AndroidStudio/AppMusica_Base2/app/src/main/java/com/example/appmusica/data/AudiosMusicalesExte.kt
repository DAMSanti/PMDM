package com.example.appmusica.data

import com.example.appmusica.model.AudioMusicalExt
import java.time.LocalDate

val audiosMusicalesExt = listOf(
    AudioMusicalExt(
        titulo = "El Encuentro",
        artist = "Vetusta Morla",
        urlImagen = "https://example.com/images/vetusta_morla_el_encuentro.jpg",
        urlAudio = "https://example.com/audios/vetusta_morla_el_encuentro.mp3",
        fecha = LocalDate.of(2024, 11, 4),
        estrellas = 4.6
    ),
    AudioMusicalExt(
        titulo = "Baile Existencialista",
        artist = "León Benavente",
        urlImagen = "https://example.com/images/leon_benavente_baile_existencialista.jpg",
        urlAudio = "https://example.com/audios/leon_benavente_baile_existencialista.mp3",
        fecha = LocalDate.of(2024, 11, 5),
        estrellas = 4.7
    ),
    AudioMusicalExt(
        titulo = "Devenir Paisaje",
        artist = "Fin del Mundo",
        urlImagen = "https://live.staticflickr.com/65535/51229086481_56a80938f8_c_d.jpg",
        urlAudio = "https://example.com/audios/fin_del_mundo_devenir_paisaje.mp3",
        fecha = LocalDate.now(),
        estrellas = 4.6
    ),
    AudioMusicalExt(
        titulo = "Brujería!",
        artist = "Judeline",
        urlImagen = "https://example.com/images/judeline_brujeria.jpg",
        urlAudio = "https://example.com/audios/judeline_brujeria.mp3",
        fecha = LocalDate.of(2024, 11, 8),
        estrellas = 4.4
    ),
    AudioMusicalExt(
        titulo = "Nos Volveremos a Ver",
        artist = "La La Love You",
        urlImagen = "https://example.com/images/la_la_love_you_nos_volveremos_a_ver.jpg",
        urlAudio = "https://example.com/audios/la_la_love_you_nos_volveremos_a_ver.mp3",
        fecha = LocalDate.of(2024, 11, 6),
        estrellas = 4.6
    ),
    AudioMusicalExt(
        titulo = "Tenemos la Respuesta",
        artist = "ELYELLA feat. Lori Meyers",
        urlImagen = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/Lori_Meyers_-_Palencia_Sonora_2018_02.jpg/640px-Lori_Meyers_-_Palencia_Sonora_2018_02.jpg",
        urlAudio = "https://example.com/audios/elyella_tenemos_la_respuesta.mp3",
        fecha = LocalDate.of(2024, 11, 12),
        estrellas = 4.5
    )
)
