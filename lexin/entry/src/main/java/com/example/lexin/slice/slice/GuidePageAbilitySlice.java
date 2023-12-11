package com.example.lexin.slice.slice;

import com.example.lexin.slice.Navigation.HomeFraction;
import com.example.lexin.slice.Navigation.MyFraction;
import com.example.lexin.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.ability.fraction.FractionAbility;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;

public class GuidePageAbilitySlice extends AbilitySlice implements Component.ClickedListener {
    private Button mbtHome, mbtMe;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_guidepage);

        mbtHome = findComponentById(ResourceTable.Id_home_img);
        mbtMe = findComponentById(ResourceTable.Id_me_img);
        mbtHome.setClickedListener(this);
        mbtMe.setClickedListener(this);
        addHomeFraction();
    }
    private void addHomeFraction(){
        ((FractionAbility)getAbility()).getFractionManager()
                .startFractionScheduler()
                .add(ResourceTable.Id_main_content, new HomeFraction())
                .submit();
    }

    private void replaceHomeFraction(){
        ((FractionAbility)getAbility()).getFractionManager()
                .startFractionScheduler()
                .replace(ResourceTable.Id_main_content, new Fraction())
                .submit();
    }

    private void replaceMyFraction(){
        ((FractionAbility)getAbility()).getFractionManager()
                .startFractionScheduler()
                .replace(ResourceTable.Id_main_content, new MyFraction())
                .submit();
    }
    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    @Override
    public void onClick(Component component) {
        switch (component.getId()) {
            case ResourceTable.Id_home_img:
                replaceHomeFraction();
                break;
            case ResourceTable.Id_me_img:
                replaceMyFraction();
                break;
            default:
                break;
        }
    }
}
