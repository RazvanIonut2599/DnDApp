package InterfacesOrAbstracts;

import androidx.fragment.app.Fragment;

import com.Base.dndcharactersheet.MainActivity;

public abstract class FragmentBase extends Fragment {
    protected MainActivity mainActivity;
    public FragmentBase(int fragmentId, MainActivity parent){
        super(fragmentId);
        this.mainActivity=parent;
    }
    public abstract void MakeEditable();
    public abstract void MakeNotEditable();
}
