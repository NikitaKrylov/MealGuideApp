import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.recipeguideapp.R
import com.example.recipeguideapp.data.models.MealData
import com.example.recipeguideapp.databinding.MealItemBinding
import com.example.recipeguideapp.ui.view.MealItemDiffCalculator
import com.example.recipeguideapp.ui.view.MealViewHolder

class MealListAdapter(
    mealDiffCalculator: MealItemDiffCalculator,
) : ListAdapter<MealData, MealViewHolder>(mealDiffCalculator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        return MealViewHolder(MealItemBinding.inflate(LayoutInflater.from(parent.context)), parent.context)
    }


    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}