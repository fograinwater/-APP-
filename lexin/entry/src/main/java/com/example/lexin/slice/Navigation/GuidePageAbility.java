package com.example.lexin.slice.Navigation;

import com.example.lexin.slice.slice.GuidePageAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.ability.fraction.FractionAbility;
import ohos.aafwk.content.Intent;

public class GuidePageAbility extends FractionAbility {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(GuidePageAbilitySlice.class.getName());
    }
}
