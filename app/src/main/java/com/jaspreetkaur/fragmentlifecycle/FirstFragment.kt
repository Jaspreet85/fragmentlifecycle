package com.jaspreetkaur.fragmentlifecycle

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.jaspreetkaur.fragmentlifecycle.databinding.FragmentFirstBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment(){
    lateinit var mainactivity: MainActivity
    lateinit var binding : FragmentFirstBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainactivity = activity as MainActivity
        Toast.makeText(mainactivity,resources.getString(R.string.onattach_fragment), Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(mainactivity, resources.getString(R.string.oncreate_fragment), Toast.LENGTH_LONG).show()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        Toast.makeText(mainactivity, resources.getString(R.string.oncreate_view_fragment), Toast.LENGTH_LONG).show()
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(mainactivity, resources.getString(R.string.on_view_create_fragment),Toast.LENGTH_LONG).show()
        binding.tvFrag.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("Test", "testing")
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }
    }

      override fun onStart() {
          super.onStart()
          Toast.makeText(mainactivity, resources.getString(R.string.onstart_fragment), Toast.LENGTH_LONG).show()
        }

        override fun onResume() {
            super.onResume()
            Toast.makeText(mainactivity, resources.getString(R.string.onresume_fragment), Toast.LENGTH_LONG).show()
        }

         override fun onPause() {
             super.onPause()
             Toast.makeText(mainactivity, resources.getString(R.string.onpause_fragment), Toast.LENGTH_LONG).show()
         }

         override fun onStop() {
             super.onStop()
             Toast.makeText(mainactivity, resources.getString(R.string.onstop_fragment), Toast.LENGTH_LONG).show()
         }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(mainactivity, resources.getString(R.string.ondestroy_view_fragment), Toast.LENGTH_LONG).show()
    }

    override fun onDetach() {
        super.onDetach()
        Toast.makeText(mainactivity, resources.getString(R.string.ondetach_fragment), Toast.LENGTH_LONG).show()
    }



companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}