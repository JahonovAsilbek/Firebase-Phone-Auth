package uz.revolution.firebasephoneauth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.revolution.firebasephoneauth.databinding.FragmentSuccesBinding

private const val ARG_PARAM1 = "number2"
private const val ARG_PARAM2 = "param2"

class SuccesFragment : Fragment() {

    private var number: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            number = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var binding:FragmentSuccesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSuccesBinding.inflate(layoutInflater)

        binding.text1.text = number

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(number: String, param2: String) =
            SuccesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, number)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}