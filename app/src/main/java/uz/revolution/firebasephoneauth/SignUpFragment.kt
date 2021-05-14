package uz.revolution.firebaseauth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import uz.revolution.firebasephoneauth.R
import uz.revolution.firebasephoneauth.databinding.FragmentSignUpBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SignUpFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(layoutInflater)

        binding.signUpBtn.setOnClickListener {
            var phoneNumber = binding.inputEt.text.toString()
            phoneNumber = phoneNumber.replace("(", "", true)
            phoneNumber = phoneNumber.replace(")", "", true)
            phoneNumber = phoneNumber.replace(" ", "", true)
            phoneNumber = phoneNumber.replace("-", "", true)

            val phoneNumber2 = binding.inputEt.text.toString()

            val bundle = Bundle()
            bundle.putString("phone", phoneNumber)
            bundle.putString("phone2", phoneNumber2)

            if (phoneNumber.length == 13) {
                findNavController().navigate(R.id.inputCodeFragment, bundle)
            } else {
                Snackbar.make(binding.root, "Raqamni to'liq kiriting!", Snackbar.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

}