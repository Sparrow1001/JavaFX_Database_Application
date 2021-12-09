module JavaFX.Database.Application {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.desktop;
    requires java.sql;
    opens sample;
    opens Domain.Model;
    opens Presentation.AddScene;
    opens Presentation.MainWindow;
    opens Presentation.TerminalWindow;
    opens Repository;
}