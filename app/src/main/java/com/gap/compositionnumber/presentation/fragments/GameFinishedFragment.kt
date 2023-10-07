package com.gap.compositionnumber.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.gap.compositionnumber.databinding.FragmentGameFinishedBinding
import com.gap.compositionnumber.domain.entities.GameResult
import com.gap.compositionnumber.domain.entities.GameSettings

class GameFinishedFragment : Fragment() {

    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding ?: throw RuntimeException("FragmentGameFinishedBinding = null")

    private lateinit var gameResult: GameResult

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    private fun parseArgs() {
        requireArguments().getParcelable<GameResult>(KEY_GAME_RESULT)?.let {
            gameResult = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonRetry.setOnClickListener {
            goToGameAgain()
        }
        requireActivity().onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    goToGameAgain()
                }
            })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun goToGameAgain() {
        requireActivity().supportFragmentManager
            .popBackStack(KEY_GAME, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    companion object {

        const val KEY_GAME = "game_again"
        private const val KEY_GAME_RESULT = "result"
        fun newInstance(gameResult: GameResult): GameFinishedFragment {
            val args = Bundle()
            args.putParcelable(KEY_GAME_RESULT, gameResult)
            val fragment = GameFinishedFragment()
            fragment.arguments = args
            return fragment
        }

        fun newInstanceKotlinVol(gameResult: GameResult): GameFinishedFragment {
            return GameFinishedFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_GAME_RESULT, gameResult)
                }
            }
        }

    }


}