package be.tftic.web2023.test_parcelable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import be.tftic.web2023.test_parcelable.SecondActivity.Companion.EXTRA_EXAMPLE_DATA
import be.tftic.web2023.test_parcelable.databinding.ActivityMainBinding
import be.tftic.web2023.test_parcelable.models.ExampleData

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Listener bouton "Switch"
        binding.btnMainSwitch.setOnClickListener { openSecondActivity() }
    }

    private fun openSecondActivity() {
        // Création d'un object "ExampleData"
        val data = ExampleData(
            binding.etMainFirstname.text.toString(),
            binding.etMainLastname.text.toString(),
            binding.etMainNumber.text.toString().toInt()
        )

        // Intent de navigation
        val navIntent = Intent(this, SecondActivity::class.java).apply {
            // Ajout des données dans l'extra de l'intent
            putExtra(EXTRA_EXAMPLE_DATA, data)
        }
        startActivity(navIntent)
    }
}