package com.lamarques.testingfeatures.featurelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.lamarques.testingfeatures.databinding.ActivityFeatureListBinding
import com.lamarques.testingfeatures.featurelist.adapter.FeatureListAdapter
import com.lamarques.testingfeatures.featurelist.model.Feature
import com.lamarques.testingfeatures.featurelist.model.FeatureName
import com.lamarques.testingfeatures.savecontact.SaveContactActivity

class FeatureListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeatureListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeatureListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createList()
    }

    private fun createList() {
        val featureList = Feature.getFeatures()

        val adapter = FeatureListAdapter(this, featureList, object : FeatureListAdapter.Callback {
            override fun onClick(featureName: FeatureName) {
                loadFeature(featureName)
            }
        })
        binding.rcFeatures.layoutManager = LinearLayoutManager(this)
        binding.rcFeatures.adapter = adapter

    }

    private fun loadFeature(featureName: FeatureName) {
        val intentFeature: Intent
        when(featureName) {
            FeatureName.SAVE_CONTACT -> {
                intentFeature = Intent(this, SaveContactActivity::class.java)
            }
        }
        intentFeature.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intentFeature.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intentFeature)
    }
}