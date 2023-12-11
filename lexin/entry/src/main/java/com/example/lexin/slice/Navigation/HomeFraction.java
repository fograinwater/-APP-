package com.example.lexin.slice.Navigation;

import com.example.lexin.ResourceTable;
import com.example.lexin.slice.Navigation.bean.Device;
import com.example.lexin.slice.Navigation.provider.DeviceItemProvider;
import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.content.Intent;
import ohos.agp.components.*;

import java.util.ArrayList;
import java.util.List;

public class HomeFraction extends Fraction {
    private ListContainer listContainer;

    private DeviceItemProvider deviceItemProvider;

    private ArrayList<Device> deviceData;
    private Button btn_add;
    @Override
    protected Component onComponentAttached(LayoutScatter scatter, ComponentContainer container,
                                            Intent intent) {
        System.out.println("onComponentAttached(生命周期方法");
        super.onComponentAttached(scatter, container, intent);


        initComponents();
        initContactData();
        initProvider();

        //加载布局
        Component component = scatter.parse(ResourceTable.Layout_fraction_home, container, false);

        //初始化列表和按钮
        listContainer = component.findComponentById(ResourceTable.Id_list_container);
        btn_add = component.findComponentById(ResourceTable.Id_bnt_add);
        //初始化设备数据列表
        deviceData = new ArrayList<Device>();

        return component;
    }


    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        System.out.println("onStart生命周期方法");

    }

    private void initComponents() {
        listContainer = (ListContainer) findComponentById(ResourceTable.Id_list_container);
        Component btnAdd = findComponentById(ResourceTable.Id_bnt_add);
        btnAdd.setClickedListener(component -> addAndUpdateContact(deviceData.size()));
    }

    private void initProvider() {
        deviceItemProvider = new DeviceItemProvider(this, deviceData);
        listContainer.setItemProvider(deviceItemProvider);
        listContainer.setReboundEffect(true);
    }

    private void addAndUpdateContact(int index) {
        addContact(index);
        deviceItemProvider.update(deviceData);
    }

    private void initContactData() {
        deviceData = new ArrayList<>();
        for (int i = 0; i < LIST_ITEM_COUNT; i++) {
            addContact(i);
        }
    }

    private void addContact(int index) {
        contactData.add(new Contact("User " + index, "100000000" + index));
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

