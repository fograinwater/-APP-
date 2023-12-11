package com.example.lexin.slice.Navigation;

import com.example.lexin.ResourceTable;
import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.LayoutScatter;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class MyFraction extends Fraction {
    private static final String TAG="MyFraction";
    private int MY_MODULE=0x00201;
    private   final HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, MY_MODULE, TAG); //

    @Override
    protected Component onComponentAttached(LayoutScatter scatter, ComponentContainer container,
                                            Intent intent) {
        System.out.println("onComponentAttached(生命周期方法");
        Component component = scatter.parse(ResourceTable.Layout_fraction_my, container, false);
        return component;
    }
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        System.out.println("onStart生命周期方法");
    }
    @Override
    protected void onActive() {
        super.onActive();
        System.out.println("onActive生命周期方法");
    }
    @Override
    protected void onInactive() {
        super.onInactive();
        System.out.println("onInactive生命周期方法");
    }
    @Override
    protected void onBackground() {
        super.onBackground();
        System.out.println("onBackground生命周期方法");
    }
    @Override
    protected void onForeground(Intent intent) {
        super.onForeground(intent);
        System.out.println("onForeground生命周期方法");
    }
    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop生命周期方法");
    }

    @Override
    protected void onComponentDetach() {
        super.onComponentDetach();
        System.out.println("onComponentDetach生命周期方法");
    }
}

