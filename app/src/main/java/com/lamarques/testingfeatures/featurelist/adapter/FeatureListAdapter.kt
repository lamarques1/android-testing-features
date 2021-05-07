package com.lamarques.testingfeatures.featurelist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lamarques.testingfeatures.R
import com.lamarques.testingfeatures.featurelist.model.Feature
import com.lamarques.testingfeatures.featurelist.model.FeatureName

class FeatureListAdapter (private val context: Context, private val features: ArrayList<Feature>,
                          val callback: Callback)
    : RecyclerView.Adapter<FeatureListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_feature, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val featureItem = features[position]
        holder.bind(featureItem)
        holder.setClickListener(featureItem.name)
    }

    override fun getItemCount(): Int = features.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvFeatureTitle = itemView.findViewById<TextView>(R.id.tvFeatureTitle)
        private val tvFeatureDescription = itemView.findViewById<TextView>(R.id.tvFeatureDescription)
        private val tvFeatureDate = itemView.findViewById<TextView>(R.id.tvFeatureDate)

        fun bind(data: Feature) {
            tvFeatureTitle.text = data.title
            tvFeatureDescription.text = data.description
            tvFeatureDate.text = data.date


        }

        fun setClickListener(featureName: FeatureName) {
            itemView.setOnClickListener {
                callback.onClick(featureName)
            }
        }
    }

    interface Callback {
        fun onClick(featureName: FeatureName)
    }
}