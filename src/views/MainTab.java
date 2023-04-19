package views;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import views.registry.RegistryView;

public class MainTab extends TabPane {

    Tab carTab;
    Tab registryTab;
    MainView mainView;
    RegistryView registryView;

    public MainTab(MainView mainView) {

        this.mainView = mainView;
        this.registryView = new RegistryView();
        this.initComponent();
        this.addComponent();

    }

    private void initComponent() {
        this.carTab = new Tab("Autók", this.mainView);
        this.registryTab = new Tab("Regisztráció", this.registryView);
    }

    private void addComponent() {
        this.getTabs().add(this.carTab);
        this.getTabs().add(this.registryTab);
    }

}
