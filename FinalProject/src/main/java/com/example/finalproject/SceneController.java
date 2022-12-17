package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class SceneController {

    private Stage stage;
    private List<File> fileList;
    private String convertTo = "default";
    private boolean isClear = false;

    @FXML
    private HBox uploadComplete;
    @FXML
    private ScrollPane reviewContainer;
    @FXML
    private VBox convertionComplete;
    @FXML
    private Text downloadSection;
    @FXML
    private Button downloadButton;
    @FXML
    private Label format;


    /* On clicking the "Upload File" button on the file-choosing scene,
       if the
       chooseFile() method calls the file choosing window and stores file chosen in 'fileList' */
    public void chooseFile () {
        isClear = false;
        uploadComplete.setVisible(false);
        convertionComplete.setVisible(false);
        downloadButton.setVisible(false);
        convertTo = "default";
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("View Picture(s)");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        fileList = (List<File>) fileChooser.showOpenMultipleDialog(stage);
        if (fileList != null) {
            uploadComplete.setVisible(true);
        }
    }

    /* On clicking the "Click to see" button,
       clickToSee() method displays 3 images for each row */
    public void clickToSeeButton () throws IOException {
        if (isClear) return;
        VBox box = new VBox();
        for (int i = 0; i < fileList.size(); i = i + 3) {
            HBox hBox = new HBox();
            hBox.setPrefSize(600, 250);

            for (int j = i; j < fileList.size() && j < i + 3; j++) {
                File file = fileList.get(j);
                // prepare the image to show
                Image image = new Image(new FileInputStream(file.getPath()));
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                if (image.getHeight() > image.getWidth()) imageView.setFitHeight(100);
                else imageView.setFitWidth(100);
                imageView.setPreserveRatio(true);
                VBox imageContainer = new VBox();
                imageContainer.setPrefSize(100, 100);
                imageContainer.setAlignment(Pos.CENTER);

                MyImage myImage = new MyImage(file);
                VBox propertyContainer = new VBox();
                propertyContainer.setAlignment(Pos.TOP_CENTER);
                Label info = new Label();
                String[] propertyName = {"Size", "Height", "Width", "Date", "Device"};
                String outputAll = "";
                for (String property: propertyName) {
                    String output = String.format("%-10s%-20s\n",property,myImage.getProperties(property));
                    outputAll = outputAll + output;
                }
                info.setText(outputAll);
                info.setLineSpacing(2);
                info.setAlignment(Pos.CENTER);
                propertyContainer.getChildren().add(info);

                // create a container for image and its information
                VBox infoContainer = new VBox();
                infoContainer.setPrefSize(200, 250);
                infoContainer.setAlignment(Pos.CENTER);

                // add image view to container
                imageContainer.getChildren().add(imageView);
                infoContainer.getChildren().add(imageContainer);
                infoContainer.getChildren().add(propertyContainer);

                // add container to this line (hBox)
                hBox.getChildren().add(infoContainer);
            }
            box.getChildren().add(hBox);
        }
        reviewContainer.setContent(box);
    }

    /* On clicking the buttons below,
       the converted format is chosen */
    public void onJPGClick () {
        format.setText(" JPG files");
        convertTo = "jpg";
    }
    public void onPNGClick () {
        format.setText(" PNG files");
        convertTo = "png";
    }
    public void onTIFFClick () {
        format.setText(" TIFF files");
        convertTo = "gif";
    }

    public void onGIFClick () {
        format.setText(" GIF files");
        convertTo = "gif";
    }

    /* On clicking the "Start" button,
       the image start to be converted */
    public void onStartClick () {
        if (!convertTo.equalsIgnoreCase("default") && isClear == false) {
            convertionComplete.setVisible(true);
            downloadButton.setVisible(true);
        }
    }

    /* On clicking the "Download" button,
       the converted images are downloaded */
    public void onDownloadClick () throws NullPointerException {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose a directory: ");
        File selectedDirectory = directoryChooser.showDialog(stage);
        if (selectedDirectory == null) return;
        if (fileList != null && isClear == false) {
            for (File file: fileList) {
                MyImage myImage = new MyImage(file);
                myImage.saveAs(convertTo, selectedDirectory.toString());
                downloadSection.setVisible(true);
            }
        }
    }

    /* On clicking the "clear" button,
       all items are set to initialized condition */
    public void clearAll() {
        isClear = true;
        reviewContainer.setContent(new VBox());
        convertionComplete.setVisible(false);
        uploadComplete.setVisible(false);
        downloadSection.setVisible(false);
    }
}
