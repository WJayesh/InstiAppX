package iitbbs.iitbhubaneswar;


import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     OptionsListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 * <p>You activity (or fragment) needs to implement {//@link OptionsListDialogFragment//.Listener.</p>
 */
public class OptionsListDialogFragment extends BottomSheetDialogFragment {
    public OptionsListDialogFragment(){}

    // Customize parameter argument names
    private static final String ARG_ITEM_COUNT = "item_count";
    //private Listener mListener;

    // Customize parameters
//    public static OptionsListDialogFragment newInstance(int itemCount) {
//        final OptionsListDialogFragment fragment = new OptionsListDialogFragment();
//        final Bundle args = new Bundle();
//        args.putInt(ARG_ITEM_COUNT, itemCount);
//        fragment.setArguments(args);
//        return fragment;
//    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_options_list_dialog, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        final RecyclerView recyclerView = (RecyclerView) view;
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(new OptionsAdapter(getArguments().getInt(ARG_ITEM_COUNT)));
          NavigationView nav_view = (NavigationView) view.findViewById(R.id.navigation_view);
          nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
              public boolean onNavigationItemSelected( MenuItem item){
                switch (item.getItemId()) {
                    case iitbbs.iitbhubaneswar.R.id.nav_map:
                        //setTitle("Campus Map");
                        setNavFragment(iitbbs.iitbhubaneswar.R.layout.map);
                        break;
                    case iitbbs.iitbhubaneswar.R.id.nav_timetable:
                        //setTitle("Academic Time Table");
                        setNavFragment(iitbbs.iitbhubaneswar.R.layout.timetable);
                        break;
                    case iitbbs.iitbhubaneswar.R.id.nav_calendar:
                        //setTitle("Academic Calendar");
                        setNavFragment(iitbbs.iitbhubaneswar.R.layout.calendar);
                        break;
                    case iitbbs.iitbhubaneswar.R.id.nav_messMenu:
                        //setTitle("Mess Menu");
                        setNavFragment(iitbbs.iitbhubaneswar.R.layout.mess_menu);
                        break;
                    case iitbbs.iitbhubaneswar.R.id.nav_holidays:
                        //setTitle("Public Holidays");
                        setNavFragment(iitbbs.iitbhubaneswar.R.layout.holiday_list);
                        break;
                    case iitbbs.iitbhubaneswar.R.id.nav_regulations:
                        //setTitle("Regulations");
                        setNavFragment(iitbbs.iitbhubaneswar.R.layout.regulations);
                        break;

                }
                return  true;
              }
          });
    }
    private void setNavFragment(int navLayout) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        NavFragmentOrig navFragmentOrig = new NavFragmentOrig();
        navFragmentOrig.setNewLayout(navLayout);

        fragmentTransaction.replace(iitbbs.iitbhubaneswar.R.id.content_frame, navFragmentOrig);
        fragmentTransaction.commit();
    }



//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        final Fragment parent = getParentFragment();
//        if (parent != null) {
//            mListener = (Listener) parent;
//        } else {
//            mListener = (Listener) context;
//        }
//    }

//    @Override
//    public void onDetach() {
//        mListener = null;
//        super.onDetach();
//    }

//    public interface Listener {
//        void onOptionsClicked(int position);
//    }

//    private class ViewHolder extends RecyclerView.ViewHolder {
//
//        final TextView text;
//
//        ViewHolder(LayoutInflater inflater, ViewGroup parent) {
//            //  Customize the item layout
//            super(inflater.inflate(R.layout.fragment_options_list_dialog_item, parent, false));
//            text = (TextView) itemView.findViewById(R.id.text);
//            text.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (mListener != null) {
//                        mListener.onOptionsClicked(getAdapterPosition());
//                        dismiss();
//                    }
//                }
//            });
//        }
//
//    }
//
//    private class OptionsAdapter extends RecyclerView.Adapter<ViewHolder> {
//
//        private final int mItemCount;
//
//        OptionsAdapter(int itemCount) {
//            mItemCount = itemCount;
//        }
//
//        @Override
//        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
//        }
//
//        @Override
//        public void onBindViewHolder(ViewHolder holder, int position) {
//            holder.text.setText(String.valueOf(position));
//        }
//
//        @Override
//        public int getItemCount() {
//            return mItemCount;
//        }
//
//    }

}
