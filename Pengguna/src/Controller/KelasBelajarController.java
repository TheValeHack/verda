package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Main.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import Models.KelasBelajar;
import Models.KelasQuiz;
import Models.KelasVideo;

public class KelasBelajarController {

    @FXML
    private VBox vboxdaftarmateri;

    private ArrayList<KelasVideo> kelasMateri;
    private ArrayList<KelasQuiz> kelasQuiz;

    public void initData(KelasBelajar kelasBelajar) {
        kelasMateri = kelasBelajar.getVideos();
        kelasQuiz = kelasBelajar.getQuizzes();

        ArrayList<Object> combinedList = new ArrayList<>();
        combinedList.addAll(kelasMateri);
        combinedList.addAll(kelasQuiz);

        Collections.sort(combinedList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof KelasVideo && o2 instanceof KelasQuiz) {
                    return ((KelasVideo) o1).getOrderVideo() - ((KelasQuiz) o2).getOrderQuiz();
                } else if (o1 instanceof KelasQuiz && o2 instanceof KelasVideo) {
                    return ((KelasQuiz) o1).getOrderQuiz() - ((KelasVideo) o2).getOrderVideo();
                } else if (o1 instanceof KelasVideo && o2 instanceof KelasVideo) {
                    return ((KelasVideo) o1).getOrderVideo() - ((KelasVideo) o2).getOrderVideo();
                } else {
                    return ((KelasQuiz) o1).getOrderQuiz() - ((KelasQuiz) o2).getOrderQuiz();
                }
            }
        });

        for (Object item : combinedList) {
            try {
                HBox hbox;
                if (item instanceof KelasVideo) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/MateriItem.fxml"));
                    hbox = loader.load();
                    MateriItemController controller = loader.getController();
                    controller.setData((KelasVideo) item);
                } else {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/KuisItem.fxml"));
                    hbox = loader.load();
                    KuisItemController controller = loader.getController();
                    controller.setData((KelasQuiz) item);
                }
                vboxdaftarmateri.getChildren().add(hbox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    private void handleBackButtonClick(MouseEvent event) throws Exception {
        App.showPelatihanView();
    }
}
