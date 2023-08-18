package com.aking.maverickscounter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.PersistState
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.aking.maverickscounter.databinding.FragmentCounterBinding
import com.aking.maverickscounter.utils.binding

/**
 * Created by Rick on 2023-08-18  12:05.<p>
 *
 * Description: Mavericks MVI Sample.
 */

data class CounterState(@PersistState val count: Int = 0) : MavericksState

class CounterViewModel(state: CounterState) : MavericksViewModel<CounterState>(state) {
    fun incrementCount() = setState { copy(count = count + 1) }
}

class CounterFragment : Fragment(R.layout.fragment_counter), MavericksView {

    private val binding: FragmentCounterBinding by binding()
    private val viewModel: CounterViewModel by activityViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.counterText.setOnClickListener {
            viewModel.incrementCount()
        }
    }

    override fun invalidate() = withState(viewModel) {
        binding.counterText.text = "${it.count}"
    }

}