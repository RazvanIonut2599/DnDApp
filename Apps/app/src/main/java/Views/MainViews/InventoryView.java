package Views.MainViews;

import android.widget.Button;
import android.widget.EditText;

public class InventoryView extends InterfacesOrAbstracts.View{
    public Button buttonInventory;
    public EditText inventory;
    @Override
    public void MakeEditable() {
        inventory.setEnabled(true);
    }

    @Override
    public void MakeNotEditable() {
        inventory.setEnabled(false);
    }
}
