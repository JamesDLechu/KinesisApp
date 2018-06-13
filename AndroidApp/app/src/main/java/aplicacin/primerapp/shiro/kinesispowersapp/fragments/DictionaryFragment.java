package aplicacin.primerapp.shiro.kinesispowersapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.activities.Dictionary_ItemDefinitionActivity;
import aplicacin.primerapp.shiro.kinesispowersapp.adapters.DictionaryItemRecyclerAdapter;
import aplicacin.primerapp.shiro.kinesispowersapp.models.DictionaryItem;

public class DictionaryFragment extends Fragment{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private static DictionaryItemRecyclerAdapter adapter;
    private static RecyclerView recyclerView;
    private List<DictionaryItem> itemList;

    public DictionaryFragment() {
    }

    public static DictionaryFragment newInstance(String param1, String param2) {
        DictionaryFragment fragment = new DictionaryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=  inflater.inflate(R.layout.fragment_dictionary, container, false);

        recyclerView= view.findViewById(R.id.recyclerViewDiccionaryFragment);
        itemList= getDictionaryItems();

        adapter= new DictionaryItemRecyclerAdapter(getContext(), itemList);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnDictionaryItemClickListener(new DictionaryItemRecyclerAdapter.OnDictionaryItemClickListener() {
            @Override
            public void onDictionaryItemClick(DictionaryItem dictionaryItem) {
                Intent intent= new Intent(getContext(), Dictionary_ItemDefinitionActivity.class);
                intent.putExtra(Dictionary_ItemDefinitionActivity.dictionaryItemKEY, dictionaryItem);
                startActivity(intent);
            }
        });

        return view;
    }

    public static void loadData(String newText){
        //newText is the searched keyword
        adapter.getFilter().filter(newText);
    }

    public ArrayList<DictionaryItem> getDictionaryItems(){
        return new ArrayList<DictionaryItem>(){
            {
                add(new DictionaryItem(getString(R.string.dictionary_word_1_name),
                        getString(R.string.dictionary_word_1_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_2_name),
                        getString(R.string.dictionary_word_2_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_3_name),
                        getString(R.string.dictionary_word_3_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_4_name),
                        getString(R.string.dictionary_word_4_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_5_name),
                        getString(R.string.dictionary_word_5_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_6_name),
                        getString(R.string.dictionary_word_6_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_7_name),
                        getString(R.string.dictionary_word_7_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_8_name),
                        getString(R.string.dictionary_word_8_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_9_name),
                        getString(R.string.dictionary_word_9_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_10_name),
                        getString(R.string.dictionary_word_10_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_11_name),
                        getString(R.string.dictionary_word_11_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_12_name),
                        getString(R.string.dictionary_word_12_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_13_name),
                        getString(R.string.dictionary_word_13_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_14_name),
                        getString(R.string.dictionary_word_14_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_15_name),
                        getString(R.string.dictionary_word_15_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_16_name),
                        getString(R.string.dictionary_word_16_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_17_name),
                        getString(R.string.dictionary_word_17_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_18_name),
                        getString(R.string.dictionary_word_18_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_19_name),
                        getString(R.string.dictionary_word_19_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_20_name),
                        getString(R.string.dictionary_word_20_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_21_name),
                        getString(R.string.dictionary_word_21_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_22_name),
                        getString(R.string.dictionary_word_22_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_23_name),
                        getString(R.string.dictionary_word_23_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_24_name),
                        getString(R.string.dictionary_word_24_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_25_name),
                        getString(R.string.dictionary_word_25_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_26_name),
                        getString(R.string.dictionary_word_26_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_27_name),
                        getString(R.string.dictionary_word_27_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_28_name),
                        getString(R.string.dictionary_word_28_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_29_name),
                        getString(R.string.dictionary_word_29_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_30_name),
                        getString(R.string.dictionary_word_30_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_31_name),
                        getString(R.string.dictionary_word_31_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_32_name),
                        getString(R.string.dictionary_word_32_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_33_name),
                        getString(R.string.dictionary_word_33_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_34_name),
                        getString(R.string.dictionary_word_34_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_35_name),
                        getString(R.string.dictionary_word_35_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_36_name),
                        getString(R.string.dictionary_word_36_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_37_name),
                        getString(R.string.dictionary_word_37_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_38_name),
                        getString(R.string.dictionary_word_38_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_39_name),
                        getString(R.string.dictionary_word_39_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_40_name),
                        getString(R.string.dictionary_word_40_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_41_name),
                        getString(R.string.dictionary_word_41_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_42_name),
                        getString(R.string.dictionary_word_42_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_43_name),
                        getString(R.string.dictionary_word_43_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_44_name),
                        getString(R.string.dictionary_word_44_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_45_name),
                        getString(R.string.dictionary_word_45_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_46_name),
                        getString(R.string.dictionary_word_46_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_47_name),
                        getString(R.string.dictionary_word_47_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_48_name),
                        getString(R.string.dictionary_word_48_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_49_name),
                        getString(R.string.dictionary_word_49_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_50_name),
                        getString(R.string.dictionary_word_50_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_51_name),
                        getString(R.string.dictionary_word_51_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_52_name),
                        getString(R.string.dictionary_word_52_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_53_name),
                        getString(R.string.dictionary_word_53_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_54_name),
                        getString(R.string.dictionary_word_54_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_55_name),
                        getString(R.string.dictionary_word_55_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_56_name),
                        getString(R.string.dictionary_word_56_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_57_name),
                        getString(R.string.dictionary_word_57_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_58_name),
                        getString(R.string.dictionary_word_58_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_59_name),
                        getString(R.string.dictionary_word_59_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_60_name),
                        getString(R.string.dictionary_word_60_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_61_name),
                        getString(R.string.dictionary_word_61_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_62_name),
                        getString(R.string.dictionary_word_62_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_63_name),
                        getString(R.string.dictionary_word_63_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_64_name),
                        getString(R.string.dictionary_word_64_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_65_name),
                        getString(R.string.dictionary_word_65_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_66_name),
                        getString(R.string.dictionary_word_66_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_67_name),
                        getString(R.string.dictionary_word_67_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_68_name),
                        getString(R.string.dictionary_word_68_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_69_name),
                        getString(R.string.dictionary_word_69_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_70_name),
                        getString(R.string.dictionary_word_70_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_71_name),
                        getString(R.string.dictionary_word_71_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_72_name),
                        getString(R.string.dictionary_word_72_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_73_name),
                        getString(R.string.dictionary_word_73_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_74_name),
                        getString(R.string.dictionary_word_74_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_75_name),
                        getString(R.string.dictionary_word_75_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_76_name),
                        getString(R.string.dictionary_word_76_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_77_name),
                        getString(R.string.dictionary_word_77_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_78_name),
                        getString(R.string.dictionary_word_78_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_79_name),
                        getString(R.string.dictionary_word_79_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_80_name),
                        getString(R.string.dictionary_word_80_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_81_name),
                        getString(R.string.dictionary_word_81_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_82_name),
                        getString(R.string.dictionary_word_82_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_83_name),
                        getString(R.string.dictionary_word_83_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_84_name),
                        getString(R.string.dictionary_word_84_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_85_name),
                        getString(R.string.dictionary_word_85_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_86_name),
                        getString(R.string.dictionary_word_86_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_87_name),
                        getString(R.string.dictionary_word_87_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_88_name),
                        getString(R.string.dictionary_word_88_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_89_name),
                        getString(R.string.dictionary_word_89_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_90_name),
                        getString(R.string.dictionary_word_90_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_91_name),
                        getString(R.string.dictionary_word_91_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_92_name),
                        getString(R.string.dictionary_word_92_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_93_name),
                        getString(R.string.dictionary_word_93_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_94_name),
                        getString(R.string.dictionary_word_94_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_95_name),
                        getString(R.string.dictionary_word_95_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_96_name),
                        getString(R.string.dictionary_word_96_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_97_name),
                        getString(R.string.dictionary_word_97_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_98_name),
                        getString(R.string.dictionary_word_98_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_99_name),
                        getString(R.string.dictionary_word_99_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_100_name),
                        getString(R.string.dictionary_word_100_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_101_name),
                        getString(R.string.dictionary_word_101_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_102_name),
                        getString(R.string.dictionary_word_102_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_103_name),
                        getString(R.string.dictionary_word_103_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_104_name),
                        getString(R.string.dictionary_word_104_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_105_name),
                        getString(R.string.dictionary_word_105_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_106_name),
                        getString(R.string.dictionary_word_106_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_107_name),
                        getString(R.string.dictionary_word_107_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_108_name),
                        getString(R.string.dictionary_word_108_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_109_name),
                        getString(R.string.dictionary_word_109_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_110_name),
                        getString(R.string.dictionary_word_110_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_111_name),
                        getString(R.string.dictionary_word_111_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_112_name),
                        getString(R.string.dictionary_word_112_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_113_name),
                        getString(R.string.dictionary_word_113_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_114_name),
                        getString(R.string.dictionary_word_114_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_115_name),
                        getString(R.string.dictionary_word_115_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_116_name),
                        getString(R.string.dictionary_word_116_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_117_name),
                        getString(R.string.dictionary_word_117_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_118_name),
                        getString(R.string.dictionary_word_118_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_119_name),
                        getString(R.string.dictionary_word_119_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_120_name),
                        getString(R.string.dictionary_word_120_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_121_name),
                        getString(R.string.dictionary_word_121_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_122_name),
                        getString(R.string.dictionary_word_122_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_123_name),
                        getString(R.string.dictionary_word_123_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_124_name),
                        getString(R.string.dictionary_word_124_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_125_name),
                        getString(R.string.dictionary_word_125_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_126_name),
                        getString(R.string.dictionary_word_126_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_127_name),
                        getString(R.string.dictionary_word_127_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_128_name),
                        getString(R.string.dictionary_word_128_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_129_name),
                        getString(R.string.dictionary_word_129_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_130_name),
                        getString(R.string.dictionary_word_130_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_131_name),
                        getString(R.string.dictionary_word_131_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_132_name),
                        getString(R.string.dictionary_word_132_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_133_name),
                        getString(R.string.dictionary_word_133_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_134_name),
                        getString(R.string.dictionary_word_134_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_135_name),
                        getString(R.string.dictionary_word_135_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_136_name),
                        getString(R.string.dictionary_word_136_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_137_name),
                        getString(R.string.dictionary_word_137_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_138_name),
                        getString(R.string.dictionary_word_138_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_139_name),
                        getString(R.string.dictionary_word_139_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_140_name),
                        getString(R.string.dictionary_word_140_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_141_name),
                        getString(R.string.dictionary_word_141_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_142_name),
                        getString(R.string.dictionary_word_142_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_143_name),
                        getString(R.string.dictionary_word_143_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_144_name),
                        getString(R.string.dictionary_word_144_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_145_name),
                        getString(R.string.dictionary_word_145_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_146_name),
                        getString(R.string.dictionary_word_146_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_147_name),
                        getString(R.string.dictionary_word_147_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_148_name),
                        getString(R.string.dictionary_word_148_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_149_name),
                        getString(R.string.dictionary_word_149_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_150_name),
                        getString(R.string.dictionary_word_150_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_151_name),
                        getString(R.string.dictionary_word_151_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_152_name),
                        getString(R.string.dictionary_word_152_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_153_name),
                        getString(R.string.dictionary_word_153_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_154_name),
                        getString(R.string.dictionary_word_154_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_155_name),
                        getString(R.string.dictionary_word_155_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_156_name),
                        getString(R.string.dictionary_word_156_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_157_name),
                        getString(R.string.dictionary_word_157_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_158_name),
                        getString(R.string.dictionary_word_158_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_159_name),
                        getString(R.string.dictionary_word_159_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_160_name),
                        getString(R.string.dictionary_word_160_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_161_name),
                        getString(R.string.dictionary_word_161_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_162_name),
                        getString(R.string.dictionary_word_162_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_163_name),
                        getString(R.string.dictionary_word_163_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_164_name),
                        getString(R.string.dictionary_word_164_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_165_name),
                        getString(R.string.dictionary_word_165_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_166_name),
                        getString(R.string.dictionary_word_166_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_167_name),
                        getString(R.string.dictionary_word_167_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_168_name),
                        getString(R.string.dictionary_word_168_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_169_name),
                        getString(R.string.dictionary_word_169_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_170_name),
                        getString(R.string.dictionary_word_170_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_171_name),
                        getString(R.string.dictionary_word_171_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_172_name),
                        getString(R.string.dictionary_word_172_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_173_name),
                        getString(R.string.dictionary_word_173_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_174_name),
                        getString(R.string.dictionary_word_174_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_175_name),
                        getString(R.string.dictionary_word_175_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_176_name),
                        getString(R.string.dictionary_word_176_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_177_name),
                        getString(R.string.dictionary_word_177_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_178_name),
                        getString(R.string.dictionary_word_178_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_179_name),
                        getString(R.string.dictionary_word_179_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_180_name),
                        getString(R.string.dictionary_word_180_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_181_name),
                        getString(R.string.dictionary_word_181_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_182_name),
                        getString(R.string.dictionary_word_182_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_183_name),
                        getString(R.string.dictionary_word_183_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_184_name),
                        getString(R.string.dictionary_word_184_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_185_name),
                        getString(R.string.dictionary_word_185_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_186_name),
                        getString(R.string.dictionary_word_186_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_187_name),
                        getString(R.string.dictionary_word_187_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_188_name),
                        getString(R.string.dictionary_word_188_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_189_name),
                        getString(R.string.dictionary_word_189_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_190_name),
                        getString(R.string.dictionary_word_190_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_191_name),
                        getString(R.string.dictionary_word_191_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_192_name),
                        getString(R.string.dictionary_word_192_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_193_name),
                        getString(R.string.dictionary_word_193_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_194_name),
                        getString(R.string.dictionary_word_194_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_195_name),
                        getString(R.string.dictionary_word_195_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_196_name),
                        getString(R.string.dictionary_word_196_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_197_name),
                        getString(R.string.dictionary_word_197_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_198_name),
                        getString(R.string.dictionary_word_198_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_199_name),
                        getString(R.string.dictionary_word_199_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_200_name),
                        getString(R.string.dictionary_word_200_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_201_name),
                        getString(R.string.dictionary_word_201_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_202_name),
                        getString(R.string.dictionary_word_202_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_203_name),
                        getString(R.string.dictionary_word_203_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_204_name),
                        getString(R.string.dictionary_word_204_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_205_name),
                        getString(R.string.dictionary_word_205_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_206_name),
                        getString(R.string.dictionary_word_206_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_207_name),
                        getString(R.string.dictionary_word_207_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_208_name),
                        getString(R.string.dictionary_word_208_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_209_name),
                        getString(R.string.dictionary_word_209_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_210_name),
                        getString(R.string.dictionary_word_210_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_211_name),
                        getString(R.string.dictionary_word_211_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_212_name),
                        getString(R.string.dictionary_word_212_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_213_name),
                        getString(R.string.dictionary_word_213_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_214_name),
                        getString(R.string.dictionary_word_214_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_215_name),
                        getString(R.string.dictionary_word_215_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_216_name),
                        getString(R.string.dictionary_word_216_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_217_name),
                        getString(R.string.dictionary_word_217_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_218_name),
                        getString(R.string.dictionary_word_218_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_219_name),
                        getString(R.string.dictionary_word_219_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_220_name),
                        getString(R.string.dictionary_word_220_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_221_name),
                        getString(R.string.dictionary_word_221_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_222_name),
                        getString(R.string.dictionary_word_222_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_223_name),
                        getString(R.string.dictionary_word_223_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_224_name),
                        getString(R.string.dictionary_word_224_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_225_name),
                        getString(R.string.dictionary_word_225_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_226_name),
                        getString(R.string.dictionary_word_226_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_227_name),
                        getString(R.string.dictionary_word_227_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_228_name),
                        getString(R.string.dictionary_word_228_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_229_name),
                        getString(R.string.dictionary_word_229_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_230_name),
                        getString(R.string.dictionary_word_230_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_231_name),
                        getString(R.string.dictionary_word_231_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_232_name),
                        getString(R.string.dictionary_word_232_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_233_name),
                        getString(R.string.dictionary_word_233_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_234_name),
                        getString(R.string.dictionary_word_234_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_235_name),
                        getString(R.string.dictionary_word_235_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_236_name),
                        getString(R.string.dictionary_word_236_definition)));
                add(new DictionaryItem(getString(R.string.dictionary_word_237_name),
                        getString(R.string.dictionary_word_237_definition)));
            }
        };
    }
}
