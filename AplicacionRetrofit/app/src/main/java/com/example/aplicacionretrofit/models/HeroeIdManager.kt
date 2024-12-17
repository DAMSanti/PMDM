import android.content.Context
import android.content.SharedPreferences

object HeroeIdManager {
    private const val PREFS_NAME = "heroe_prefs"
    private const val KEY_HEROE_ID = "heroe_id"

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun getNextId(context: Context): Int {
        val prefs = getPreferences(context)
        val currentId = prefs.getInt(KEY_HEROE_ID, 1)
        prefs.edit().putInt(KEY_HEROE_ID, currentId + 1).apply()
        return currentId
    }

    fun resetId(context: Context) {
        val prefs = getPreferences(context)
        prefs.edit().putInt(KEY_HEROE_ID, 1).apply()
    }
}