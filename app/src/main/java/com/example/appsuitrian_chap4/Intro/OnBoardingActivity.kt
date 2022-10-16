package com.example.appsuitrian_chap4.Intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.appsuitrian_chap4.Intro.inputname.InputPlayerName
import com.example.appsuitrian_chap4.R
import com.github.appintro.AppIntro2
import com.github.appintro.AppIntroFragment

class OnboardingActivity : AppIntro2() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setupSliderFragment()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        if(currentFragment is OnFinishNavigateListener){
            currentFragment.onFinishNavigateListener()
        }
    }

    private fun setupSliderFragment(){
        isSkipButtonEnabled = false
        addSlide(
            AppIntroFragment.createInstance(
            title = getString(R.string.title_satu),
            description = getString(R.string.desc_satu),
            imageDrawable = R.drawable.page_1,
            titleTypefaceFontRes = R.font.pixelated_font,
            descriptionTypefaceFontRes = R.font.pixelated_font,
            backgroundDrawable = R.color.purple_500,
            descriptionColorRes = R.color.white,
            titleColorRes = R.color.white
        ))
        addSlide(
            AppIntroFragment.createInstance(
            description = getString(R.string.desc_dua),
            imageDrawable = R.drawable.page_2,
            titleTypefaceFontRes = R.font.pixelated_font,
            descriptionTypefaceFontRes = R.font.pixelated_font,
            backgroundDrawable = R.color.purple_500,
            descriptionColorRes = R.color.white,
            titleColorRes = R.color.white
        ))
        addSlide(InputPlayerName())
    }
}

interface OnFinishNavigateListener{
    fun onFinishNavigateListener()
}