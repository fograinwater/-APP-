package com.example.lexin.slice.Navigation.provider;

import com.example.lexin.ResourceTable;
import com.example.lexin.slice.Navigation.bean.Device;
import ohos.agp.components.*;
import ohos.agp.window.dialog.CommonDialog;
import ohos.app.Context;

import java.util.List;

public class DeviceItemProvider extends BaseItemProvider {
    private static final int DIALOG_WIDTH = 900;

    private static final int DIALOG_HEIGHT = 600;

    private static final int DIALOG_CORNER_RADIUS = 30;

    private CommonDialog commonDialog;
    private List<Device> deviceData;
    private final Context context;

    public DeviceItemProvider(Context context,List<Device> deviceData){
        this.deviceData =deviceData;
        this.context=context;
    }

    @Override
    public int getCount() {
        return deviceData == null ? 0 : deviceData.size();
    }

    @Override
    public Object getItem(int position) {
        if (deviceData != null && position >= 0 && position < deviceData.size()){
            return deviceData.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Component getComponent(int position, Component component, ComponentContainer componentContainer) {
        return getItemComponent(position);
    }
    private Component getItemComponent(int position) {
        return getComponent(position);
    }

    public Component getComponent(int position) {
        Device device = deviceData.get(position);
        Component container = LayoutScatter.getInstance(context).parse(ResourceTable.Layout_list_dev_item, null, false);
        Text name = (Text) container.findComponentById(ResourceTable.Id_item_dev_name);
        Text id = (Text) container.findComponentById(ResourceTable.Id_item_dev_id);
        Component btnEdit = container.findComponentById(ResourceTable.Id_item_btn_edit);

        name.setText(device.getMdev_name());
        id.setText("id:" + device.getMdev_id());
        btnEdit.setClickedListener(component -> showContactDetailDialog(device, position));

        return container;
    }

    private void showContactDetailDialog(Device contact, int position) {
        Component container = LayoutScatter.getInstance(context).parse(ResourceTable.Layout_dialog_layout, null, false);
        TextField name = (TextField) container.findComponentById(ResourceTable.Id_name);
        name.setText(contact.getMdev_name());
        TextField id = (TextField) container.findComponentById(ResourceTable.Id_id);
        id.setText(contact.getMdev_id());
        Button btnOk = (Button) container.findComponentById(ResourceTable.Id_btn_ok);

        btnOk.setClickedListener(component -> saveEdit(name.getText(), id.getText(), position));
        commonDialog = new CommonDialog(context);
        commonDialog.setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
        commonDialog.setCornerRadius(DIALOG_CORNER_RADIUS);
        commonDialog.setContentCustomComponent(container);
        commonDialog.show();
    }
    private void saveEdit(String name, String id, int position) {
        deviceData.get(position).setMdev_name(name);
        deviceData.get(position).setMdev_id(id);
        notifyDataChanged();
        commonDialog.destroy();
    }



}
