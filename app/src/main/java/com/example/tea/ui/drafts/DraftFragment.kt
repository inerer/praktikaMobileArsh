package com.example.tea.ui.drafts

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tea.R
import com.example.tea.databinding.FragmentDraftBinding
import com.example.tea.databinding.FragmentHomeBinding
import com.example.tea.ui.home.HomeViewModel

class DraftFragment : Fragment() {

    private var _binding: FragmentDraftBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val draftViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentDraftBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDraft
        draftViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}