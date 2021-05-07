package com.lamarques.testingfeatures.featurelist.model

data class Feature(
    val name: FeatureName,
    val title: String,
    val description: String,
    val date: String
) {
    companion object {
        fun getFeatures(): ArrayList<Feature> {
            return arrayListOf<Feature>().apply {
                add(Feature(FeatureName.SAVE_CONTACT, "Save Contact", "Method to save a new contact", "05/07/2021"))
            }
        }
    }
}