package com.intive.selftraining.selftraining.movieDetails.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MoviesPagerAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

  private var fragmentList: MutableList<Fragment> = ArrayList()

  override fun getItem(position: Int) = fragmentList[position]

  override fun getCount() = fragmentList.size

  fun addFragments(fragment: Fragment) = fragmentList.add(fragment)
}