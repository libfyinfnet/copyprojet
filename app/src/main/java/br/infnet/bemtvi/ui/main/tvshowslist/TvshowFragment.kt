package br.infnet.bemtvi.ui.main.tvshowslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.infnet.bemtvi.R
import br.infnet.bemtvi.databinding.FragmentTvshowListBinding
import br.infnet.bemtvi.ui.main.tvshowslist.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class TvshowFragment : Fragment() {

    private var columnCount = 2
    private lateinit var binding:FragmentTvshowListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTvshowListBinding.inflate(inflater,container,false)


            with(binding.rvlistTvshows as RecyclerView) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyTvshowRecyclerViewAdapter(PlaceholderContent.ITEMS)
            }
        return binding.root
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            TvshowFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}