package be.tftic.web2023.test_parcelable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import be.tftic.web2023.test_parcelable.databinding.ActivitySecondBinding
import be.tftic.web2023.test_parcelable.models.ExampleData

class SecondActivity : AppCompatActivity() {

    companion object {
        val EXTRA_EXAMPLE_DATA = "extra_data"
    }

    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
    }

    private fun loadData() {
        // Load data from Bundle
        var exampleData : ExampleData? = null

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            // Nouvelle version depuis Android 33
            exampleData = intent.getParcelableExtra(EXTRA_EXAMPLE_DATA, ExampleData::class.java)
        }
        else {
            // Ancienne version
            exampleData = intent.getParcelableExtra<ExampleData>(EXTRA_EXAMPLE_DATA)
        }

        if(exampleData != null) {
            populateView(exampleData)
        }
    }

    private fun populateView(exampleData: ExampleData) {
        binding.etSecondFirstname.setText(exampleData.firstname)
        binding.etSecondLastname.setText(exampleData.lastname)
        binding.etSecondNumber.setText(exampleData.number.toString())
    }
}