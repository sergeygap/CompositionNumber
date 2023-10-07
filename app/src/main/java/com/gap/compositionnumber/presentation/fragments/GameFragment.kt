package com.gap.compositionnumber.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gap.compositionnumber.R
import com.gap.compositionnumber.databinding.FragmentGameBinding
import com.gap.compositionnumber.domain.entities.GameResult
import com.gap.compositionnumber.domain.entities.GameSettings
import com.gap.compositionnumber.domain.entities.Level

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding = null")

    private lateinit var level: Level

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParams()
    }

    private fun parseParams() {
        level = requireArguments().getSerializable(KEY_LEVEL) as Level
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.sumTV.setOnClickListener {
            launchGameFinishedFragment(GameResult(true, 1, 1, GameSettings(
                1,
                1,
                1,
                1
            )))
        }
    }

    private fun launchGameFinishedFragment(gameResult: GameResult) {
//        requireActivity().supportFragmentManager.popBackStack()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, GameFinishedFragment.newInstance(gameResult))
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val KEY_LEVEL = "level"
        fun newInstance(level: Level): GameFragment {
            // args with Bundle
            val gameFragment = GameFragment()
            val args = Bundle()
            args.putSerializable(KEY_LEVEL, level)
            gameFragment.arguments = args
            return gameFragment
        }
    }

}