package com.drake.brv.sample.ui.fragment

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.drake.brv.sample.R
import com.drake.brv.sample.databinding.FragmentCoordinatorLayoutBinding
import com.drake.engine.base.EngineFragment
import com.google.android.material.tabs.TabLayoutMediator

class CoordinatorLayoutFragment :
    EngineFragment<FragmentCoordinatorLayoutBinding>(R.layout.fragment_coordinator_layout) {
    override fun initView() {
        val fragments = listOf(PreloadFragment(), PreloadFragment(), PreloadFragment())
        val titles = listOf("简介", "评论","测试")
//        binding.vp.adapter = FragmentPagerAdapter(fragments, titles)
//        binding.tab.setupWithViewPager(binding.vp)

        val viewPager2Adapter = PostViewPager2Adapter(titles.size, this)
        binding.vp.adapter = viewPager2Adapter

        TabLayoutMediator(
            binding.tab, binding.vp, true, true
        ) { tab, position ->
            tab.setText(titles[position])
        }.attach()
        // `CoordinatorLayout+ViewPager`使用缺省页要求缺省页的XML根布局为 NestedScrollView, 否则显示缺省页后无法正常滑动
    }

    override fun initData() {
    }
}

class PostViewPager2Adapter(private val count: Int, fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return count
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return PreloadFragment()
            1 -> return PreloadFragment()
            2 -> return PreloadFragment()
        }
        throw IllegalArgumentException("Illegal position")
    }
}