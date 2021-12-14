package sheridan.romeroad.finalexam

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import sheridan.romeroad.finalexam.databinding.PetFragmentBinding
import javax.inject.Inject

@AndroidEntryPoint
class PetFragment : Fragment() {

    companion object{
        const val TAG = "PetFragment"
        const val CONFIRM_CLEAR_ALL = "confirmClearAll"
        const val CONFIRM_DELETE_ITEM = "confirmDelete"
    }

    /*private var _binding: PetFragmentBinding? = null
    private val binding: PetFragmentBinding
        get() = _binding!!
*/
    private val viewModel: PetViewModel by viewModels()
    private lateinit var navController: NavController

    @Inject
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = PetFragmentBinding.inflate(inflater, container, false)
        navController = findNavController()
        //return inflater.inflate(R.layout.pet_fragment, container, false)

        val adapter = PetListAdapter(
            onClick = { envelope ->
                navController.navigate(
                    PetFragmentDirections.actionPetToOutput(envelopeId = envelope.id!!)
                )
            },
            onDelete = { envelope ->
                if(settings.confirmDelete){
                    val action = PetFragmentDirections.actionHistoryToConfirmation(
                        requestKey = CONFIRM_DELETE_ITEM,
                        title = getString(R.string.app_name),
                        message = getString(R.string.confirm_delete_message),
                        itemId = envelope.id
                    )
                    navController.navigate(action)
                }else{
                    viewModel.delete(envelope)
                }
            }
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PetViewModel::class.java)
        // TODO: Use the ViewModel
    }

}