package xyz.bitnaesser.multiplechoice.question;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import nucleus5.factory.RequiresPresenter;
import xyz.bitnaesser.multiplechoice.R;
import xyz.bitnaesser.multiplechoice.base.ServerAPI;
import xyz.bitnaesser.multiplechoice.logging.LoggingFragment;

@RequiresPresenter(QuestionPresenter.class)
public class QuestionFragment extends LoggingFragment<QuestionPresenter> {

    CheckedTextView check1;
    CheckedTextView check2;
    ArrayAdapter<ServerAPI.Question> adapter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null)
            getPresenter().request(QuestionPresenter.DEFAULT_NAME);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        check1 = (CheckedTextView)view.findViewById(R.id.check1);
        check2 = (CheckedTextView)view.findViewById(R.id.check2);

        check1.setText(MainPresenter.NAME_1);
        check2.setText(MainPresenter.NAME_2);

        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().request(MainPresenter.NAME_1);
            }
        });
        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().request(MainPresenter.NAME_2);
            }
        });

        ListView listView = (ListView)view.findViewById(R.id.listView);
        listView.setAdapter(adapter = new ArrayAdapter<>(getActivity(), R.layout.item));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ServerAPI.Item item = adapter.getItem(position);
                ((MainActivity)getActivity()).push(new ItemFragment(item.toString()));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        check1 = null;
        check2 = null;
        adapter = null;
        ((ListView)getView().findViewById(R.id.listView)).setOnItemClickListener(null);
    }

    public void onItems(ServerAPI.Item[] items, String user) {
        check1.setChecked(user.equals(MainPresenter.NAME_1));
        check2.setChecked(user.equals(MainPresenter.NAME_2));

        adapter.clear();
        adapter.addAll(items);
    }

    public void onNetworkError(Throwable throwable) {
        Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_LONG).show();
    }
}
