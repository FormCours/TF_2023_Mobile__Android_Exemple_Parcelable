package be.tftic.web2023.test_parcelable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import be.tftic.web2023.test_parcelable.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
    }

    private fun loadData() {
        // Load data from Bundle
    }

}